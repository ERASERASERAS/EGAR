package model;

/**
 * This is class represents users
 */
public class User {
    /**
     * Id for user
     */
    private final int id;

    /**
     * User's login
     */
    private String login;

    /**
     * User's password
     */
    private String password;

    /**
     * User's acces level
     */
    private AccessLevel accessLevel;

    /**
     * Create object with all parameters
     * @param id User's id
     * @param login User's login
     * @param password User's password
     * @param accessLevel User's access level
     */
    public User(int id, String login, String password, AccessLevel accessLevel) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    /**
     * Get user's id
     * @return User's id
     */
    public int getId() {
        return id;
    }

    /**
     * Get user's login
     * @return User's login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set user's login
     * @param login New user's login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Get user's password
     * @return User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set user's password
     * @param password New user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get user's access level
     * @return User's access level
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * Set user's access level
     * @param accessLevel New access level
     */
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    /**
     * Returns string represent of object fot this class
     * @return String represent of object
     */
    public String toString() {
        return "Id:  " + id + "  Логин:  " + login + "  Пароль:  " + password + "  Роль: " + accessLevel;
    }

}
