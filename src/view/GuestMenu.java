package view;

import java.util.Scanner;

/**
 * This is class provids methods for showingu menu for guests
 *
 */
public class GuestMenu {

    /**
     * This is variable for reading users ansers from keyboard
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * This is variable for calls methods for proccesing users answers
     */
    private Viewer viewer;

    /**
     * Create new object with initialization of viewer
     * @param viewer Object of Viewer for initialization
     */
    public GuestMenu(Viewer viewer){
        this.viewer = viewer;
    }

    /**
     *Shows menu for guest
     */
    public void guestMenu() {
        boolean end = false;
        int userAnswer = 0;
        while (!end) {
            System.out.println("1. Посмотреть список лотов по категории");
            System.out.println("2. Посмотреть список лотов по товару");
            System.out.println("3. Просмотреть список ставок по лоту");
            System.out.println("0. Выход");
            if (sc.hasNext()) {
                userAnswer = sc.nextInt();
                if (userAnswer == 1)
                    viewer.showLotsByCategory();
                if(userAnswer == 2)
                    viewer.showLotsByItem();
                else if (userAnswer == 3)
                    viewer.showBetsByLot();
                else if (userAnswer == 0)
                    end = true;
            } else {
                System.out.println("Введите что-нибудь");
            }
        }
    }


}


