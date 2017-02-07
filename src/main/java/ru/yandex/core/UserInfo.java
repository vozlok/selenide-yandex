package ru.yandex.core;

/**
 * Created by kai on 12.01.2017.
 */
public class UserInfo {
    public String login;
    public String password;
    public String firstName;
    public String secondName;
    public String email;

    public UserInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserInfo(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

}
