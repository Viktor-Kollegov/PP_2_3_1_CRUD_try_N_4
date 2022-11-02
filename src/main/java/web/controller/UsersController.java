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
    public String printWelcome(ModelMap modelMap) throws SQLException {
        modelMap.addAttribute("users", userService.getAllUsers());
        //Создаём атрибут users для работы с ним на странице users.html
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        //@ModelAttribute даёт доступ к экземпляру на странице создания
        return "create_users";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        //Здесь же @ModelAttribute возвращает доступ обратно в контроллер
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model) {
        model.addAttribute("userToUpdate", userService.findUserById(id));
        //С заданным атрибутом работаем на странице edit_users.html
        return "edit_users";
    }

    @PostMapping("/update/{id}")
    public String updateUser(User UpdatedUser) {
        //Получаем объект через действие в форме методом POST
        //Имя переменной задаём здесь произвольно
        //И хотя в методах id не нужен, без него у нас каждый раз просто
        //создается новый объект, почему - пока непонятно
        userService.updateUser(UpdatedUser);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(User userToDelete) { //Убираем @PathVariable int id,
        // и достаём через действие методом POST самого юзера
        //Имя переменной задаём здесь произвольно
        userService.removeUser(userToDelete);
        return "redirect:/users";
    }

    @GetMapping("/clear")
    public String ClearTheTable() throws SQLException {
        userService.cleanUsersTable();
        return "redirect:/users";
    }
// post: The POST method ; form data sent as the request body .
// get: The GET method ; form data appended to the action URL with a ? separator.
// Use this method when the form has no side-effects .
// dialog: When the form is inside a <dialog>, closes the dialog on submission
}

