package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.util.OutputString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg(){
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(User user, Model model){
        if (userService.save(user)){
            return "redirect:/";
        }else model.addAttribute("message", "Its user has existed yet!!!");
        return "reg";
    }

    @GetMapping("/auth")
    public String auth(){
        return "auth";
    }

    @PostMapping("/auth")
    public String auth(User user, Model model, HttpSession httpSession){
        Optional<User> optionalUser = userService.findByUsername(user);
        if (optionalUser.isPresent()){
            User user1 = optionalUser.get();
            if (user1.getPassword().equals(user.getPassword())){
                httpSession.setAttribute("user", user1);
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password!");
            }
        } else {
            model.addAttribute("message", "User not found!");
        }
        return "auth";
    }

    @GetMapping("/logout")
    public String auth(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

    @GetMapping("/changePassword")
    public String changePassword(){
        return "changePassword";
    }



    @PostMapping ("/changePassword")
    public String changePassword(String newPassword, String oldPassword, Model model, HttpSession httpSession ){
        if(userService.updatePassword((User) httpSession.getAttribute("user"), newPassword, oldPassword )){
            model.addAttribute("message", OutputString.getString("Password successfully changed"));
        }else {
            model.addAttribute("message", OutputString.getString("Error in the changePassword!!!"));
        }
        return "changePassword";
    }

    @GetMapping("/changeName")
    public String changeName(){
        return "changeName";
    }



    @PostMapping ("/changeName")
    public String changeName(String newName, Model model, HttpSession httpSession ){
        if(userService.updateName((User) httpSession.getAttribute("user"), newName)){
            model.addAttribute("message", OutputString.getString("Name successfully changed"));
        }else {
            model.addAttribute("message", OutputString.getString("Error in the changeName!!!"));
        }
        return "changePassword";
    }


}
