package com.example.test.controllers;

import com.example.test.models.User;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @Autowired
    private UserService userService;

    @GetMapping("/getUserByID/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @GetMapping("/getUserByEmail/{email}")
    public User getUser(@PathVariable String email){
        return userService.findUserByLogin(email);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody String email, String password, String fullName, String position,
                        String phone) throws ParseException {
        phone = phone.substring(4).replaceAll(" ", "");
        Integer phoneNumber = Integer.parseInt(phone);
        email = email.substring(6, email.indexOf("&")).replace("%40", "@");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        date1 = formatter.parse(formatter.format(date1));
        User user = new User(email, passwordEncoder.encode(password), fullName, position, phoneNumber, date1);
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(@RequestBody String email){
        email = email.substring(6).replace("%40", "@");
        User user = userService.findUserByLogin(email);
        boolean flag = userService.deleteUser(user);
        if(flag){
            return "Пользователь был успешно удалён";
        }else {
            return "Такой пользователь не найден";
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public User updateUser(@RequestBody String email, String password, String fullName, String position, String phone){
        User user = userService.findUserByLogin(email);
        if(user != null) {
            user.setPassword(passwordEncoder.encode(password));
            user.setFullName(fullName);
            user.setPosition(position);
            user.setPhone(Integer.parseInt(phone.substring(3).replaceAll(" ", "")));
            return userService.saveUser(user);
        }else {
            return null;
        }
    }

}
