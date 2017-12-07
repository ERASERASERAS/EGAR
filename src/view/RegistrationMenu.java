package view;

import controller.UserController;
import model.exceptions.RegistrationException;
import model.exceptions.UserAlreadyExistException;

import java.util.Scanner;

public class RegistrationMenu {

    private UserController userController;
    private static Scanner sc = new Scanner(System.in);

    public RegistrationMenu(UserController userController) {
        this.userController = userController;
    }

    public void registration() throws RegistrationException, UserAlreadyExistException {
        boolean end = false;
        while (!end) {
            System.out.println("Введите логин");
            if (sc.hasNext()) {
                String login = "";
                String password = "";
                try {
                    login = sc.next();
                    userController.checkDuplicateUsers(login);

//            catch(UserAlreadyExistException ex){
//                    System.out.println(ex.getMessage());
//                    System.out.println("Попробуйте ещё раз");
//            }
                    System.out.println("Введите пароль");
                    if (sc.hasNext()) {
                        //Проверка валидности пароля
                        password = sc.next();
                    }
                    if (!userController.addNewUser(login, password)) {
                        throw new RegistrationException("Какие-то проблемы с регистрацией. Попробуйте ещё раз.");
                    }
                    end = true;
                } catch (UserAlreadyExistException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Попробуйте ещё раз");
                }
            }
        }
    }
}
