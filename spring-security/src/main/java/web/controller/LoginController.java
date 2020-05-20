package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

    private UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "login")
    public String loginPage() {
        service.addAdminAndUser();
        return "login";
    }
}
