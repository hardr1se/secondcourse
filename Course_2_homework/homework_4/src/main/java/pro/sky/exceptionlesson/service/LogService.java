package pro.sky.exceptionlesson.service;

import org.springframework.stereotype.Service;
import pro.sky.exceptionlesson.exceptions.WrongLoginException;
import pro.sky.exceptionlesson.exceptions.WrongPasswordException;

@Service
public class LogService {
    public static boolean signUp(String login, String password, String confirmPassword) {
        if (!login.matches("^[a-zA-Z0-9_]{20}+$")) {
            throw new WrongLoginException("Ошибка из-за того, что параметр Login должен содержать в себе " +
                    "только латинские буквы, цифры, знак подчеркивания и не превышать длину в 20 знаков");
        } else if (!password.matches("^[a-zA-Z0-9_]{19}+$") || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ошибка из-за того, что параметр Password должен содержать в себе" +
                    "только латинские буквы, цифры, знак подчеркивания и не превышать длину в 19 знаков");
        }
        return true;
    }
}
