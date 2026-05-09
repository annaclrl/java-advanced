package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("{api.security.token.secret}")
    private String secret;

    public String generateToken(Usuario usuario){

        try {
            Algorithm algoritm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("api-rest")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(genExpirationDate())
                    .sign(algoritm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro na geração do token", e);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("fiap")
                    .build()  //descriptografa
                    .verify(token) //valida
                    .getSubject(); // pega o usuario
        }catch (JWTVerificationException e) {
            throw new RuntimeException("Erro na verificação do token", e);
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusMinutes(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
