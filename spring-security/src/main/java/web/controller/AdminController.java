package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class AdminController {

    private UserService service;

    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping("admin/panel")
    public String getUsersTable(Model model) {
        model.addAttribute("userList", service.getAllUser());
        return "admin-panel";
    }

    @PostMapping("admin/panel")
    public String addUser(User user) {
        service.addUser(user);
        return "redirect:/admin/panel";
    }

    @PostMapping("admin/delete")
    public String deleteUser(User user) {
        service.deleteUser(user);
        return "redirect:/admin/panel";
    }

    @GetMapping("admin/update")
    public String getUpdatePage(ModelMap model, User user) {
        model.addAttribute("id", user.getId())
                .addAttribute("name", user.getName())
                .addAttribute("surName", user.getSurName())
                .addAttribute("password", user.getPassword());
        return "update-user";
    }

    @PostMapping("admin/update")
    public String updateUser(User user) {
        service.updateUser(user.getId(), user.getName(), user.getSurName(), user.getPassword());
        return "redirect:/admin/panel";
    }
}
