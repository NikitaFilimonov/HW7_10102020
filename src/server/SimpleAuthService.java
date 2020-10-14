package server;

import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {
    private class UserData { //что мы закладываем в юсер дату: логин, пароль, на эти логин и пароль идет никнейм
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    public SimpleAuthService() { //можем добавить отдельных юзеров и через fori лоин1, логин2 и тд
        users = new ArrayList<>();
        users.add(new UserData("qwe", "qwe", "qwe"));
        users.add(new UserData("asd", "asd", "asd"));
        users.add(new UserData("zxc", "zxc", "zxc"));
        for (int i = 1; i < 10; i++) {
            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        for (UserData user : users) { //для всех юзеров из списка - при вводе определенных логинов и паролей - возвращает соотв
            //ующий никнейм
            if(user.login.equals(login) && user.password.equals(password)){
                return user.nickname;
            }
        }
        return null; //если не соответствуют логин и пароль друг другу - null
    }
}
