package org.tomjerry.sweethome.util.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.tomjerry.sweethome.util.token.TokenService;

import java.io.IOException;

/*
 * @Description: 这个类是用来处理JWT的认证过滤器
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private CustomUserDetailService customUserDetailService;

    public JwtAuthenticationFilter(TokenService tokenService, CustomUserDetailService customUserDetailService) {
        this.tokenService = tokenService;
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        String token = getJwtFromRequest(request);
        if(token != null && tokenService.validateToken(token)) {
            // 解析token
            Claims claims = tokenService.getClaimsFromToken(token);

            // 获取用户id
            String userId = claims.getSubject();
            request.setAttribute("userId", userId);

            UserDetails userDetails = customUserDetailService.loadUserByUsername(userId);

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);

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
