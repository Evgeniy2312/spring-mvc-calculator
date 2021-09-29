package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.OperationService;
import by.tms.util.OutputString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/calculator")
public class OperationController {

    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/count")
     public String calc(@ModelAttribute("newOperation") Operation operation, Model model){
         model.addAttribute("listOperations", operationService.getOperationManager().getNameOperations());
         return "calc";
     }

     @PostMapping("/count")
    public String calc(@Valid @ModelAttribute("newOperation") Operation operation, BindingResult bindingResult, HttpSession httpSession, Model model) {
         if (!bindingResult.hasErrors()) {
             if (httpSession.getAttribute("user") != null) {
                 Operation operation1 = operationService.getResult(operation, (User) httpSession.getAttribute("user"));
                 model.addAttribute("listOperations", operationService.getOperationManager().getNameOperations());
                 model.addAttribute("result", operation1.getResult());
             } else {
                 model.addAttribute("message", OutputString.getString("You haven't authorized yet!!!"));
             }
         }
         return "calc";
     }

     @GetMapping("/history")
    public String history(Model model, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        model.addAttribute("currentList", operationService.getOperationsByUser(user));
        return "history";   
     }

    @PostMapping("/history")
    public String history(String type, Model model, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        model.addAttribute("currentList" , operationService.getOperationsByOperation(user,type));
        return "history";
    }
}
