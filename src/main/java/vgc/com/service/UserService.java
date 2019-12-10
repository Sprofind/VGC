package vgc.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vgc.com.config.JwtToken;
import vgc.com.entities.User;
import vgc.com.model.ResponseData;
import vgc.com.model.UserNameProfile;
import vgc.com.repositories.iUserRepository;

@Service
public class UserService {

    @Autowired
    private iUserRepository userRepository;


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken token;

    @Autowired
    PasswordEncoder passwordEncoder;


    public ResponseEntity<?> getUser(){
        return ResponseEntity.ok( userRepository.findAll());
    }

    public ResponseEntity<?> getUserFullName(int id){
        return ResponseEntity.ok(userRepository.getOne(id).getFullname());
    }

    public ResponseEntity<?> getUserCity(int id){
        return ResponseEntity.ok(userRepository.getOne(id).getCity());
    }

    public ResponseEntity<?> getUserName(int id){
        return ResponseEntity.ok(userRepository.getOne(id).getUsername());
    }

    public ResponseEntity<?> getUserPhone(int id){
        return ResponseEntity.ok(userRepository.getOne(id).getPhone());
    }

    public ResponseEntity<?> getUserBirthDay(int id){
        return ResponseEntity.ok(userRepository.getOne(id).getBirthday());
    }
    public ResponseEntity<?> getUserEmail(int id){
        return ResponseEntity.ok(userRepository.getOne(id).getEmail());
    }

    public ResponseEntity<?> getUserPoint(int id){
        return ResponseEntity.ok(userRepository.getOne(id).getPoint());
    }


    public ResponseData<String> updateUser(Authentication authentication, UserNameProfile user){
        Integer userId = userRepository.findIdByUsername(authentication.getName());
        Integer rs = userRepository.updateUser(user.getUsername(), user.getUserFullname(), user.getUserBirthday(), user.getUserGender(), user.getUserEmail(), user.getUserCity(), user.getUserPhone(), userId);
        return new ResponseData(HttpStatus.OK, "success", rs);
    }

    public ResponseData<Integer> registerUser(User user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            return new ResponseData(HttpStatus.OK, "username exist", 0);
        }
        if(userRepository.findByEmail(user.getEmail()) != null){
            return new ResponseData(HttpStatus.OK, "email exist", 0);
        }
        if(userRepository.findByPhone(user.getPhone()) != null){
            return new ResponseData(HttpStatus.OK, "phone exist", 0);
        }

        String avt;
        if(user.getGender() == 1){
            avt = "http://lathanhhanh.tk/src/beta/img/trai.jpg";
        }else{
            avt = "http://lathanhhanh.tk/src/beta/img/gai.jpg";
        }
        return new ResponseData(HttpStatus.OK, "success", userRepository.registerUser(user.getUsername(), passwordEncoder.encode(user.getPassword()), avt, user.getFullname(), user.getBirthday(), user.getGender(), user.getEmail(), user.getCity(), user.getPhone()));
    }

    public ResponseData<String> loginUser(String username, String password){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username, password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = token.generateToken((UserDetails) authentication.getPrincipal());
        return new ResponseData(HttpStatus.OK, "success", jwt);
    }

    public ResponseData<User> getInfo(Authentication authentication){
        return new ResponseData(HttpStatus.OK, "success", userRepository.findByUsername(authentication.getName()));
    }
}
