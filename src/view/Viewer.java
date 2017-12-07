package view;

import controller.*;
import data.DataHolder;
import model.*;
import model.exceptions.AddLotException;
import model.exceptions.BadBetException;
import model.exceptions.DoubleBetException;
import model.exceptions.LotIsClosedException;

import java.util.*;

/**
 * This class provides methods for processing users answers and show results of users answer
 */
public class Viewer {

    /**
     *
     */
    private User currentUser;

    /**
     * This variable for reading users answers for keyboard
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * This variable for calls some methods from UserController
     */
    private UserController userController;

    /**
     * This variable for calls some methods from BetController
     */
    private BetController betController;

    /**
     * This variable for calls some methods from CategoryController
     */
    private CategoryController categoryController;

    /**
     * This variable for calls some methods from LotController
     */
    private LotController lotController;

    /**
     * This variable for calls some methods from ItemController
     */
    private ItemController itemController;

    /**
     * Constructs new object with initialization of all controllers
     *
     * @param userController initialization of UserController
     */
    public Viewer(UserController userController, User currentUser) {
        this.currentUser = currentUser;
        this.userController = userController;
        betController = new BetController();
        categoryController = new CategoryController();
        lotController = new LotController();
        itemController = new ItemController();
    }

    public Viewer() {
    }

    /**
     * Show lots for current user
     */
    public void showUsersLots() {
        List<Lot> lots = userController.getUsersLots(currentUser);
        if (lots.size() > 0) {
            for (Lot lot : lots) {
                System.out.println(lot);
            }
        } else {
            System.out.println("У вас нет лотов");
        }
    }

    /**
     * Show lots of user by login
     *
     * @param login
     */
    public void showUsersLots(String login) {
        List<Lot> lots = userController.getUsersLots(userController.getUserByLogin(login));
        if (lots.size() > 0) {
            for (Lot lot : lots) {
                System.out.println(lot);
            }
        } else {
            System.out.println("Пользователь " + login + " ничего не продаёт");
        }
    }

    /**
     * Show count of bets for current user
     */
    public void showCountOfBets() {
        System.out.println("Количество ставок: " + userController.getCountOfBets(currentUser));
    }

    /**
     * Show bets for current user
     */
    public void showUsersBets() {
        List<Bet> bets = userController.getUsersBets(currentUser);
        if (bets.size() > 0) {
            for (Bet bet : bets)
                System.out.println(bets);
        } else {
            System.out.println("Вы не делали ставок");
        }
    }

    /**
     * Show all lots of certain category
     */
    public void showLotsByCategory() {
        String userAnswer = "";
        showAllCategories();
        System.out.println("Введите название категории");
        if (sc.hasNext()) {
            userAnswer = sc.next();
            if (!userAnswer.equals("")) {
                List<Lot> lots = lotController.getLotByCategory(categoryController.getCategoryByName(userAnswer));
                if (lots.size() > 0) {
                    for (Lot lot : lots)
                        System.out.println(lot);
                } else {
                    System.out.println("В данной категории нет продающихся товаров");
                }
            }
        } else {
            System.out.println("Введите название категории");
        }
    }

    /**
     * Show all categories
     */
    public void showAllCategories() {
        System.out.println("Список доступных категорий: ");
        List<Category> categories = DataHolder.getDataHolder().getCategories();
        for (Category category : categories)
            System.out.println(category.getName());
    }


    public void showBetsByLot() {
        System.out.println("Выберите лот");
        System.out.println("1. По категории");
        System.out.println("2. По товару");
        if (sc.hasNextInt()) {
            System.out.println("Для выхода нажмите 0");
            int userAnswer = 0;
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                if (userAnswer > 0) {
                    List<Bet> bets = betController.getBetsByLot(lotController.getLotById(userAnswer));
                    if (bets.size() > 0) {
                        for (Bet bet : bets)
                            System.out.println(bet);
                    } else {
                        System.out.println("По данному лоту ещё не делали ставок");
                    }
                }
            } else {
                System.out.println("Введите число");
            }
        }
    }

    /**
     * Show menu for choose of view of user statistics
     */
    public void usersStatisctics() {
        int userAnswer;
        showAllUsers();
        System.out.println("Введите логин пользователя:");
        if (sc.hasNext()) {
            String login = sc.next();
            System.out.println("1. Просмотр ставок пользователя");
            System.out.println("2. Просмотр лотов пользователя");

            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                if (userAnswer == 1)
                    showUsersBets(login);
                else if (userAnswer == 2)
                    showUsersLots(login);
            } else
                System.out.println("Введите число");
        } else
            System.out.println("Введите имя пользователя");
    }

    /**
     * Show bets for user by login
     *
     * @param login
     */
    public void showUsersBets(String login) {
        List<Bet> bets = userController.getUsersBets(userController.getUserByLogin(login));
        if (bets.size() > 0) {
            for (Bet bet : bets)
                System.out.println(bets);
        } else {
            System.out.println("Данный пользователь не делал ставок");
        }
    }

    /**
     * Show list of all users.
     */
    public void showAllUsers() {
        List<User> users = DataHolder.getDataHolder().getUsers();
        for (User user : users)
            System.out.println(user);
    }

    /**
     * Show all items which user is bought
     */
    public void showBoughtItems() {
        Map<Bet,Item> boughtItems = userController.getBoughtItems(currentUser);
        for(Map.Entry entry : boughtItems.entrySet()){
            Bet bet = (Bet) entry.getKey();
            System.out.println(entry.getValue() + "за " + bet.getPrice());
        }
    }

    public void calculateUndeliveredItems() {

    }

    public void toBet() {
        showLotsByCategory();
        boolean end = false;
        System.out.println("Введите id лота, по котрому вы хотите сделать ставку");
        int userAnswer = 0;
        while (!end) {
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                Lot lot = lotController.getLotById(userAnswer);
                System.out.println("Лот:  " + lot);
                System.out.println("Введите вашу цену: ");
                if (sc.hasNextInt()) {
                    try {
                        userAnswer = sc.nextInt();
                        betController.addNewBet(currentUser.getId(), lot.getId(), userAnswer);
                        end = true;
                    } catch (DoubleBetException ex) {
                        System.out.println(ex.getMessage());
                    } catch (BadBetException ex) {
                        System.out.println(ex.getMessage());
                    } catch (LotIsClosedException ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("Ставка успешно сделана!");
                }

            }
        }
    }

    public void createNewLot() {
        showAllCategories();
        boolean end = false;
        while (!end) {
            System.out.println("Введите название категории: ");
            if (sc.hasNext()) {
                Category category = categoryController.getCategoryByName(sc.next());
                System.out.println("Введите название товара: ");
                if (sc.hasNext()) {
                    String itemsName = sc.next();
                    if (!itemController.checkExistenceOfItem(itemsName)) {
                        itemController.addNewItem(category.getID(), itemsName);
                    }
                    Item item = itemController.getItemByName(itemsName);
                    System.out.println("Введите стартовую цену: ");
                    int price;
                    if (sc.hasNextInt()) {
                        price = sc.nextInt();
                        System.out.println("Введите дату окончания лота(год, номер месяца, число");
                        System.out.println("Год/месяц/день: ");
                        Calendar date = new GregorianCalendar(sc.nextInt(), sc.nextInt() - 1, sc.nextInt());
                        try {
                            lotController.addNewLot(item.getId(), price, currentUser.getId(), date, category.getID(), 1);
                            end = true;
                        }
                        catch (AddLotException ex){
                            System.out.println(ex.getMessage());
                            System.out.println("Попробуйие ещё раз");
                        }
                        end = true;
                        System.out.println("Лот успешно добавлен");
                    }
                }
            }
        }
    }

    public void showLotsByItem() {
        System.out.println("Введите название товара: ");
        if (sc.hasNext()) {
            Item item = itemController.getItemByName(sc.next());
            if (item != null) {
                List<Lot> lots = lotController.getLotsByItem(item);
                for (Lot lot : lots) {
                    System.out.println(lot);
                }
            } else {
                System.out.println("Данный товар не продаюют в настоящий момент");
            }
        }
    }


    /**
     * Show total price of undelivered items(price + delivery)
     */
    public void showTotalPriceOfUndeliveredItems() {

    }

    public String inputLogin() {
        System.out.println("Введите логин");
        String userAnswer = "";
        if (sc.hasNext()) {
            userAnswer = sc.next();
        } else {
            System.out.println("Введите логин");
        }
        return userAnswer;
    }


}
