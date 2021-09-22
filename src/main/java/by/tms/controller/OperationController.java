package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.OperationService;
import by.tms.util.OutputString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/calculator")
public class OperationController {

     @Autowired
    private OperationService operationService;

     @GetMapping("/count")
     public String calc(){
         return "calc";
     }

     @PostMapping("/count")
    public String calc(Operation operation, HttpSession httpSession, Model model){
         if(httpSession.getAttribute("user") != null){
             Operation operation1 = operationService.getResult(operation, (User)httpSession.getAttribute("user"));
             model.addAttribute("result", operation1.getResult());
         }else {
             model.addAttribute("message", OutputString.getString("You haven't authorized yet!!!"));
         }
         return "calc";
     }

}
