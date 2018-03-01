package io.arklitium.matrix.client.rest.jsonmodel;

public class LoginReqData {
    private String type = "m.login.password";
    private String user;
    private String medium;
    private String address;
    private String password;

    public LoginReqData(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public LoginReqData(String medium, String address, String password) {
        this.medium = medium;
        this.address = address;
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getMedium() {
        return medium;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginReqData{" +
                "type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", medium='" + medium + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
