package by.tms.controller;

import by.tms.dto.UserAllFields;
import by.tms.dto.UserDTOByLogin;
import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.util.ConsoleMessageManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String reg(@ModelAttribute("newUser") UserAllFields userDTO){
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@Valid @ModelAttribute("newUser") UserAllFields userDTO, BindingResult bindingResult, Model model){
        if (!bindingResult.hasErrors()) {
            if (userService.save(userDTO.getUser(userDTO))){
                model.addAttribute("message", ConsoleMessageManager.REG_SUCCESSFULLY);
            }else model.addAttribute("message", ConsoleMessageManager.REG_FAIL);
        }
        return "reg";
    }

    @GetMapping("/auth")
    public String auth(@ModelAttribute("existingUser")UserDTOByLogin userDTOByLogin){ return "auth";
    }

    @PostMapping("/auth")
    public String auth(@Valid @ModelAttribute("existingUser") UserDTOByLogin userDTO, BindingResult bindingResult, Model model, HttpSession httpSession){
        if(!bindingResult.hasErrors()) {
            Optional<User> optionalUser = userService.findByUsername(userDTO.getUser(userDTO));
            if (optionalUser.isPresent()) {
                User user1 = optionalUser.get();
                if (user1.getPassword().equals(userDTO.getUser(userDTO).getPassword())) {
                    httpSession.setAttribute("user", user1);
                    model.addAttribute("message", ConsoleMessageManager.AUTH_SUCCESSFULLY);
                } else {
                    model.addAttribute("message", ConsoleMessageManager.INCORRECTLY_PASSWORD);
                }
            } else {
                model.addAttribute("message", ConsoleMessageManager.AUTH_FAIL);
            }
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
            model.addAttribute("message", ConsoleMessageManager.CHANGE_PASSWORD_SUCCESSFULLY);
        }else {
            model.addAttribute("message", ConsoleMessageManager.CHANGE_PASSWORD_FAILED);
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
            model.addAttribute("message", ConsoleMessageManager.CHANGE_NAME_SUCCESSFULLY);
        }else {
            model.addAttribute("message", ConsoleMessageManager.CHANGE_NAME_FAILED);
        }
        return "changeName";
    }


}
