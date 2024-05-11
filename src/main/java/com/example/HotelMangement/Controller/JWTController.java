package com.example.HotelMangement.Controller;

import com.example.HotelMangement.Exception.CustomException;
import com.example.HotelMangement.Service.CustomUserDetailService;
import com.example.HotelMangement.Util.JWTUtil;
import com.example.HotelMangement.model.JWTRequest;
import com.example.HotelMangement.model.JWTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody JWTRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
        } catch(UsernameNotFoundException ex) {
            ex.printStackTrace();
            throw new CustomException("Bad Credential");
        }

        UserDetails userDetails = customUserDetailService.loadUserByUsername(jwtRequest.getUserName());

        String token = jwtUtil.generateToken(userDetails);
        System.out.println("token: " + token);

        JWTResponse jwtResponse = new JWTResponse(token);

        return ResponseEntity.ok().body(jwtResponse);
    }
}
