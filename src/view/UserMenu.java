package view;

import model.User;

import java.util.Scanner;

/**
 * This class provides methods for showing menu for simple user
 */
public class UserMenu {

    /**
     * the current user
     */
    private User currentUser;

    /**
     * This variable for reading users answers for keyboard
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * This variable for calls some methods for processing users answers
     */
    private Viewer viewer;

    public UserMenu(Viewer viewer){
        this.viewer = viewer;
    }

    /**
     * Shows menu for simple user
     */
    public void simpleUserMenu() {
        int userAnswer = 0;
        boolean end = false;
        while (!end) {
            System.out.println("1. Посмотреть список лотов по категории");
            System.out.println("2. Посмотреть список лотов по товару");
            System.out.println("3. Посмотреть  список ставок по лоту");
            System.out.println("4. Посмотреть свои ставки");
            System.out.println("5. Показать количество ставок");
            System.out.println("6. Посмотреть свои лоты");
            System.out.println("7. Показать лоты пользователя...");
            System.out.println("8. Показать купленные товары");
            System.out.println("9. Сделать ставку");
            System.out.println("10. Создать свой лот");
            System.out.println("0. Выход");
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                if (userAnswer == 1)
                    viewer.showLotsByCategory();
                if(userAnswer == 2)
                    viewer.showLotsByItem();
                else if (userAnswer == 3)
                    viewer.showBetsByLot();
                else if (userAnswer == 4)
                    viewer.showUsersBets();
                else if (userAnswer == 5)
                    viewer.showCountOfBets();
                else if (userAnswer == 6)
                    viewer.showUsersLots();
                else if (userAnswer == 7)
                    viewer.showUsersLots(new Viewer().inputLogin());
                else if (userAnswer == 8) {
                    viewer.showBoughtItems();
                    viewer.calculateUndeliveredItems();
                }
                else if (userAnswer == 9)
                    viewer.toBet();
                else if (userAnswer == 10)
                    viewer.createNewLot();
                else if (userAnswer == 0)
                    end = true;
            }
        }
    }


}
