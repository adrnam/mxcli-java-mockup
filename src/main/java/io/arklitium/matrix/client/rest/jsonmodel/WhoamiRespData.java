package io.arklitium.matrix.client.rest.jsonmodel;

public class WhoamiRespData {

    private String user_id;


    public WhoamiRespData() {
    }

    public WhoamiRespData(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "WhoamiRespData{" +
                "user_id='" + user_id + '\'' +
                '}';
    }

}
