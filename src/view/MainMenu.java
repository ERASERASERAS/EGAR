package view;

import controller.*;
import model.User;
import model.exceptions.RegistrationException;
import model.exceptions.UserAlreadyExistException;

import java.util.Scanner;

/**
 * This is class show steps of main menu
 */
public class MainMenu {

    /**
     * This is variable for reading user's answers from keyboard
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * This is variable for call methods from UserController
     */
    private UserController userController;

    /**
     *
     */
    private User currentUser;

    /**
     * Constructs new object
     */
    public MainMenu() {
        userController = new UserController();
    }

    /**
     * Start for main menu
     */
    public void start() {
        startMenu();
    }

    /**
     * Start menu
     */
    private void startMenu() {
        boolean end = false;
        int userInput = 0;
        while (!end) {
            System.out.println("Привет!");
            System.out.println("1.Вход");
            System.out.println("2.Зайти как гость");
            System.out.println("3. Регистрация");
            System.out.println("0.Выход");

            if (sc.hasNextInt()) {
                userInput = sc.nextInt();
                if (userInput == 1) {
                    currentUser = new AuthorizationMenu(userController).authorizationMenu();
                    if (currentUser != null) {
                        chooseUsersMenuByStatus();
                    }
                } else if (userInput == 2) {
                    new GuestMenu(new Viewer(userController, currentUser)).guestMenu();
                } else if(userInput == 3) {
                    try {
                        new RegistrationMenu(userController).registration();
                    }
                    catch (UserAlreadyExistException ex){
                        System.out.println(ex.getMessage());
                    }
                    catch(RegistrationException ex){
                        System.out.println(ex.getMessage());
                    }
                }


                else if (userInput == 0)
                    end = true;
            } else {
                System.out.println("Введите число");
            }
        }
    }

    /**
     *Choose view of menu(for admin or for simple user)
     */
    private void chooseUsersMenuByStatus() {
        if (currentUser.getAccessLevel().toString().equals("USER"))
            new UserMenu(new Viewer(userController, currentUser)).simpleUserMenu();
        else if (currentUser.getAccessLevel().toString().equals("ADMIN"))
            new AdminMenu(new Viewer(userController, currentUser)).adminMenu();
    }




}
