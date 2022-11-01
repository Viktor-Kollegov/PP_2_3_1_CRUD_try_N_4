package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.sql.SQLException;


@Controller
@RequestMapping(value = "/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String printWelcome(ModelMap model) throws SQLException {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "create_users";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model) {
        model.addAttribute("userToUpdate", userService.show(id));
        return "edit_users";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id,
                                @ModelAttribute("UpdatedUser") User UpdatedUser) {
        userService.updateUserById(id, UpdatedUser);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

}

