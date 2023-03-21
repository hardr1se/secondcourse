package pro.sky.exceptionlesson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exceptionlesson.exceptions.WrongLoginException;
import pro.sky.exceptionlesson.exceptions.WrongPasswordException;
import pro.sky.exceptionlesson.service.LogService;

@RestController
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping(path = "/signup")
    public static boolean signUp(@RequestParam("login") String login,
                              @RequestParam("password") String password,
                              @RequestParam("confirmPassword") String confirmPassword) {
        try {
            return LogService.signUp(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return false;
        } catch (WrongPasswordException e) {
            return false;
        } finally {
            System.out.println("Метод signUp закончил работу");
        }
    }
}
