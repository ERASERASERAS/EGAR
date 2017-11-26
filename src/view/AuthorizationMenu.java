package view;

import controller.UserController;
import model.User;

import java.util.Scanner;

/**
 * Provids methods for authorization
 */
public class AuthorizationMenu {

    /**
     * This is variable for reading users ansers from keyboard
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     *
     */
    private UserController userController;

    /**
     *
     * @param userController
     */
    public AuthorizationMenu(UserController userController) {
        this.userController = userController;
    }

    /**
     * Show authorization steps and call meyhods from UserContoller for authorization
     * @return
     */
    public User authorizationMenu() {
        User currentUser = null;
        System.out.println("Для возвращения назад нажмите 0");
        System.out.println("Введите логин:  ");
        String login = sc.next();
        System.out.println("Введите пароль:  ");
        String password = sc.next();

        if ((userController.getUserByLogin(login) != null) && (userController.checkPassword(userController.getUserByLogin(login), password))) {
            currentUser = userController.getUserByLogin(login);
            System.out.println("Авторизация прошла успешно. Привет, " + login + ". Вы - " + currentUser.getAccessLevel());
        } else {
            System.out.println("Неверный логин или пароль...");
        }
        return currentUser;
    }

    /**
     * Gets userContoller
     * @return userContoller
     */
    public UserController getUserController() {
        return userController;
    }
}
