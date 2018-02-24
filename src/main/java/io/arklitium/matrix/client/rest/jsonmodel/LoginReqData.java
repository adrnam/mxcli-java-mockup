package io.arklitium.matrix.client.rest.jsonmodel;

public class LoginReqData {
    private String type = "m.login.password";
    private String user;
    private String password;

    public LoginReqData(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "LoginData{" +
                "type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
