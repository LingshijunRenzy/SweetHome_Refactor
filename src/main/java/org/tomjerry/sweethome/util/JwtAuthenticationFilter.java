package org.tomjerry.sweethome.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.tomjerry.sweethome.util.token.TokenService;

import java.io.IOException;

/*
 * @Description: 这个类是用来处理JWT的认证过滤器
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    public JwtAuthenticationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //跳过login和register请求的JWT验证
        if(request.getRequestURI().contains("login") || request.getRequestURI().contains("register")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getJwtFromRequest(request);

        if(token != null && tokenService.validateToken(token)) {
            Integer userId = tokenService.getUserIdFromToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
