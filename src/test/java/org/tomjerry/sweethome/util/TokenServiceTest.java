package org.tomjerry.sweethome.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.tomjerry.sweethome.util.token.TokenService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
 * TokenService的测试类
 * 测试TokenService的方法
 */
@SpringBootTest
public class TokenServiceTest {
    private TokenService tokenService;

    @BeforeEach
    public void setUp() {
        tokenService = TokenService.getInstance();
    }

    @Test
    public void testGenerateToken() {
        String token = tokenService.generateToken(114514);
        assertNotNull(token);
    }

    @Test
    public void testGetUserIdFromToken() {
        String token = tokenService.generateToken(1919810);
        Integer userId = tokenService.getUserIdFromToken(token);
        assertNotNull(userId);
    }

    @Test
    public void testValidateToken() {
        String token = tokenService.generateToken(1145);
        boolean result = tokenService.validateToken(token);
        assertNotNull(result);
    }
}
