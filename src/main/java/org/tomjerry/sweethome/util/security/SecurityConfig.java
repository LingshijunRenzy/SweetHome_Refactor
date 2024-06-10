package org.tomjerry.sweethome.util.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.tomjerry.sweethome.util.token.TokenService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private final TokenService tokenService;

    public SecurityConfig(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    /*
        * 配置安全过滤器链
        * @param http HttpSecurity对象
        * @return SecurityFilterChain对象
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session   // 设置session为无状态
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.authorizeHttpRequests(authorize -> authorize   // 配置请求的权限
                .requestMatchers("/article/test").authenticated()
                .requestMatchers(HttpMethod.POST, "/article").authenticated()
                .requestMatchers(HttpMethod.PATCH, "/article/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/article/**").authenticated()

                .requestMatchers(HttpMethod.PATCH, "/user/info").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/user/info").authenticated()

                .requestMatchers(HttpMethod.POST, "/comment/add").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/comment/**").authenticated()

                .anyRequest().permitAll());                         // 其他请求放行


        // 添加JWT认证过滤器
        http.addFilterBefore(new JwtAuthenticationFilter(tokenService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(org.springframework.security.core.userdetails.User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .authorities("ROLE_USER")
                .build());
        return manager;
    }

}
