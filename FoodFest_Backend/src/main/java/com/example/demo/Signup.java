package com.example.demo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import com.example.demo.model.UserModel;

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
public class Signup {

    private final UserService userService;

    @Autowired
    public Signup(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody  UserModel user) throws JsonProcessingException {

        String username = user.getName();
        String password = user.getPassword();
        String email = user.getEmail();

        int mod = 1000000007;
        int base = 11;
        int cur = 1, hash = 0;
        for (int i = 0; i < password.length(); i++) {
            hash = (hash + cur * password.charAt(i));
            cur = (cur * base) % mod;
        }
        password = String.valueOf(hash);


        if (userService.signup(username, email, password)) {
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

//    @PostMapping("/signup")
//    public String signup(@RequestBody  UserModel user) throws JsonProcessingException {
//
//
//        String username=user.getName();
//        String password= user.getPassword();
//        String email= user.getEmail();
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
//
//        int ret=checkSignupCred(username, password, email);// passing signup values to database
//        return String.valueOf(ret);
//    }
//
//    public int checkSignupCred(String username,String password, String email)
//    {
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultSet = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krunch", "root", "Rubaiyat26");
//
//
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM user WHERE name = ?");
//
//            psCheckUserExists.setString(1, username);
//            resultSet = psCheckUserExists.executeQuery();
//
//            if (resultSet.isBeforeFirst()) {
//                System.out.println("user exists");
//                return 0;
//
//            }
//            else {
//                psInsert = connection.prepareStatement("INSERT INTO user(name,password,email) VALUES(?,?,?)");
//                psInsert.setString(1, username);
//                psInsert.setString(2, password);
//                psInsert.setString(3, email);
//                psInsert.executeUpdate();
//                System.out.println("user data saved");
//                return 1;
//            }
//        }
//        catch (Exception e) {
//            System.out.println(e);
//            System.out.println("Already exists error");
//        }
//        return 0;
//    }
}
