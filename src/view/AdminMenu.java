package view;

import java.util.Scanner;

/**
 * This is class provids methods for showing menu for admnistrator
 */
public class AdminMenu {

    /**
     * This is variable is reading user answers from keyboard
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * This is variable for call certain methods
     */
    private Viewer viewer;

    /**
     * Construct new object with initialization of viewer
     * @param viewer Object of Viewer for initialization
     */
    public AdminMenu(Viewer viewer){
        this.viewer = viewer;
    }

    /**
     * Show nemu for administrator
     */
    public void adminMenu() {
        int userAnswer = 0;
        boolean end = false;
        while (!end) {
            System.out.println("1. Посмотреть список лотов по категории");
            System.out.println("2. Посмотреть  список ставок по лоту");
            System.out.println("3. Посмотреть свои ставки");
            System.out.println("4. Показать количество ставок");
            System.out.println("5. Посмотреть статистику пользователя");
            System.out.println("0. Выход");
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                if (userAnswer == 1)
                    viewer.showLotsByCategory();
                else if (userAnswer == 2)
                    viewer.showBetsByLot();
                else if (userAnswer == 3)
                    viewer.showUsersBets();
                else if (userAnswer == 4)
                    viewer.showCountOfBets();
                else if (userAnswer == 5)
                    viewer.usersStatisctics();
                else if (userAnswer == 0)
                    end = true;
            }
        }
    }
}
