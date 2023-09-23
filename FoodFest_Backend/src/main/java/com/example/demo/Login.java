package com.example.demo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

import com.example.demo.model.UserModel;
import com.example.demo.UserService;

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
public class Login {
    private final UserService userService;
    @Autowired
    public Login(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserModel user) throws JsonProcessingException {
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

        if (userService.login(username, password)) {
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

//    @PostMapping("/login")
//    public String login(@RequestBody UserModel user) throws JsonProcessingException {
//
//        String username=user.getName();
//        String password= user.getPassword();
//
//        int mod = 1000000007;
//        int base = 11;
//        int cur = 1, hash = 0;
//        for (int i = 0; i < password.length(); i++) {
//            hash = (hash + cur * password.charAt(i));
//            cur = (cur * base) % mod;
//        }
//        password= String.valueOf(hash);
//        //System.out.println(password);
//        int ret=checkLoginCred(username,password);
//        return String.valueOf(ret);
//
//    }
//
//    public int checkLoginCred(String username,String password)
//    {
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultSet = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krunch", "root", "Rubaiyat26");
//
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM user WHERE name = ? AND password=?");
//            //System.out.println(username);
//            psCheckUserExists.setString(1, username);
//            psCheckUserExists.setString(2, password);
//            resultSet = psCheckUserExists.executeQuery();
//            /**/
//            if (resultSet.isBeforeFirst()) {
//                System.out.println(username +" "+password);
//                System.out.println("found");
//
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3));
//                }
//                connection.close();
//                return 1;
//            }
//            else {
//                System.out.println("no user");
//                return 0;
//
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return 0;
//    }
}
