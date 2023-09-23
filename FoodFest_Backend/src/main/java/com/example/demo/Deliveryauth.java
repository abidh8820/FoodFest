package com.example.demo;
import com.example.demo.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import com.example.demo.model.DeliveryuserModel;

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
public class Deliveryauth {
    private final DeliveryuserService deliveryuserService;
    @Autowired
    public Deliveryauth(DeliveryuserService deliveryuserService) {
        this.deliveryuserService = deliveryuserService;
    }

    @PostMapping("/deliverylogin")
    public ResponseEntity<String> deliverylogin(@RequestBody DeliveryuserModel user) throws JsonProcessingException {
        String username = user.getName();
        String password = user.getPassword();
        int mod = 1000000007;
        int base = 11;
        int cur = 1, hash = 0;
        for (int i = 0; i < password.length(); i++) {
            hash = (hash + cur * password.charAt(i));
            cur = (cur * base) % mod;
        }
        password= String.valueOf(hash);

        if (deliveryuserService.login(username, password)) {
            //return new ResponseEntity<>("1", HttpStatus.OK);
            String jwtSecret = "qwertyui";
            String usernameClaim = "username";

            // Generate a secure key using the secretKeyFor method
            SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

            // Convert the key to a byte array
            byte[] keyBytes = key.getEncoded();

            // Use the generated key for signing the JWT
            String jwtToken = Jwts.builder()
                    .setSubject(username)
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

            //System.out.println("Generated JWT: " + jwtToken);

            // Verify the JWT
            boolean isValid = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody()
                    .getSubject()
                    .equals(username);

            //System.out.println("Is valid JWT? " + isValid);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setBearerAuth(jwtToken);

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(jwtToken);
            //return ResponseEntity.ok(jwtToken);
        } else {
            //System.out.println("Hello, world2!");
            return new ResponseEntity<>("0", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/deliverysignup")
    public ResponseEntity<String> deliverysignup(@RequestBody DeliveryuserModel user) throws JsonProcessingException {

        String username = user.getName();
        String password = user.getPassword();

        int mod = 1000000007;
        int base = 11;
        int cur = 1, hash = 0;
        for (int i = 0; i < password.length(); i++) {
            hash = (hash + cur * password.charAt(i));
            cur = (cur * base) % mod;
        }
        password = String.valueOf(hash);


        if (deliveryuserService.signup(username, password)) {
            String jwtSecret = "qwertyui";
            String usernameClaim = "username";

            // Generate a secure key using the secretKeyFor method
            SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

            // Convert the key to a byte array
            byte[] keyBytes = key.getEncoded();

            // Use the generated key for signing the JWT
            String jwtToken = Jwts.builder()
                    .setSubject(username)
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

            //System.out.println("Generated JWT: " + jwtToken);

            // Verify the JWT
            boolean isValid = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody()
                    .getSubject()
                    .equals(username);

            //System.out.println("Is valid JWT? " + isValid);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setBearerAuth(jwtToken);

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(jwtToken);

            //return new ResponseEntity<>("1", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("0", HttpStatus.BAD_REQUEST);
        }
    }
}
