package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping("/new")
    public String getFormNewUser(@ModelAttribute("user") User user) {
        return "userAdd";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String getFormEditUser(@RequestParam("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "userEdit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
