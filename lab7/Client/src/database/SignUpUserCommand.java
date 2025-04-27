package database;

import interfaces.DataBaseCommand;

import java.util.Scanner;

public class SignUpUserCommand implements DataBaseCommand {
    Scanner scanner = new Scanner(System.in);
    private String username = null;
    private String password = null;
    private User user = new User();

    @Override
    public User execute() {
        while (true) {
            System.out.print("Введите ваш username (длина username не может превышать 15 символов): ");
            username = scanner.nextLine();
            if (username == null | username.trim().isEmpty() | username.length() > 15 | username.contains(" ")) {
                System.out.println("Неправильный формат username, введите еще раз.");
            } else {
                user.setUsername(username);
                break;
            }
        }
        while (true) {
            System.out.print("Введите ваш password (длина password не может превышать 15 символов): ");
            password = scanner.nextLine();
            if (password == null | password.trim().isEmpty() | password.length() > 15 | password.contains(" ")) {
                System.out.println("Неправильный формат password, введите еще раз.");
            } else {
                user.setPassword(password);
                break;
            }
        }
        user.setRegFlag(0);
        return user;
    }
}
