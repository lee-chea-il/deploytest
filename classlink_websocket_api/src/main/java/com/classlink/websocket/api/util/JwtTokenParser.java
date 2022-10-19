
package com.classlink.websocket.api.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenParser {

    //==Jwt 토큰의 유효성 체크 메소드==//
    public Claims parseJwtToken(String token) {
        token = BearerRemove(token); // Bearer 제거
        return Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(("345345fsdfsf5345").getBytes()))
                .parseClaimsJws(token)
                .getBody();
    }
    
    //==토큰 앞 부분('Bearer') 제거 메소드==//
    private String BearerRemove(String token) {
    	
        return token.substring("Bearer ".length());
    }
}
