package com.edu.poly.major.controller;

import com.edu.poly.major.dto.UserDTO;
import com.edu.poly.major.global.GlobalData;
import com.edu.poly.major.model.Role;
import com.edu.poly.major.model.User;
import com.edu.poly.major.repository.RoleRepository;
import com.edu.poly.major.repository.UserRepository;
import com.edu.poly.major.service.RoleService;
import com.edu.poly.major.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;



    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login( Model model){
        GlobalData.cart.clear();
        model.addAttribute("content1","login");
        return "Base";
    }//page login

    @GetMapping("/forgotpassword")
    public String forgotPass(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "forgotpassword";
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        model.addAttribute("content1","register");
        return "Base";
    } //page register

    @PostMapping("/register")
    public String registerPost(@ModelAttribute User userModel, HttpServletRequest request, RedirectAttributes redirectAttributes) throws ServletException{
        //chuyen password tu form dki thanh dang ma hoa
        String password = userModel.getPassword();
        userModel.setPassword(bCryptPasswordEncoder.encode(password));

       Optional<User> user= userService.getUserByEmail(userModel.getEmail());
        if (user.isPresent()){
            redirectAttributes.addFlashAttribute("notify", "Tài khoản đã tồn tại");
            return "redirect:/register";
        }
        //set mac dinh role user,admin
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findRoleById(1).get());
        roles.add(roleService.findRoleById(2).get());
        userModel.setRoles(roles);
        userService.saveUser(userModel);
        //login & chuyen den page home
        request.login(userModel.getEmail(), password);
        return "redirect:/";
    }//after register success
}
