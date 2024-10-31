package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Users;
import org.example.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JWTService service;
    private final UserRepo userRepo;
    private final AuthenticationManager manager;
    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    public Users register(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepo.save(users);
    }

    public String verify(Users users) {
        Authentication authentication= manager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
        if(authentication.isAuthenticated()){
            return service.generateToken(users.getUsername());
        }
        return "Fail";
    }
}
