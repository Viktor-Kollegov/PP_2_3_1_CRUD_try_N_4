import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.model.User;
import web.service.UserService;

import java.sql.SQLException;

// Tomcat запускается, Main - нет
// Потратил туеву хучу времени отлаживая проблему, которая в данной задаче даже роли не играет
// Хотя без отладки в Main не исправил бы все прочие ошибки с версиями зависимостей

// Exception in thread "main" org.springframework.beans.factory.BeanCreationException:
// Error creating bean with name 'resourceHandlerMapping' defined in class path resource
// [org/springframework/web/servlet/config/annotation/DelegatingWebMvcConfiguration.class]:
// Bean instantiation via factory method failed; nested exception is
// org.springframework.beans.BeanInstantiationException: Failed to instantiate
// [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping'
// threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set

// Main запускается, если закоментить WebConfig и AppInit. ПОЧЕМУ?????

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(web.config.AppConfig.class);
        //Запускается без вебконфиг и аппинит
        UserService userService = context.getBean(UserService.class);
        User user1 = new User("Name1", "LastName1", "dgshh@yandex.ru");
        User user2 = new User("Name2", "LastName2", "sdhsdhsdh@yandex.ru");
        User user3 = new User("Name3", "LastName3", "asgasdghsedh@yandex.ru");
        User user4 = new User("Name4", "LastName4", "dgasrewtewrgshh@yandex.ru");
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        System.out.println(userService.getAllUsers());
        //userService.cleanUsersTable();
    }
}