package io.arklitium.matrix.client.rest.jsonmodel;

public class LoginRespData {
    private String access_token;

    public LoginRespData() {
    }

    public LoginRespData(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "LoginRespData{" +
                "access_token='" + access_token + '\'' +
                '}';
    }

}
