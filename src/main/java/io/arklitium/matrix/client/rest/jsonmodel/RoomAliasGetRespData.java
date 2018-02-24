package io.arklitium.matrix.client.rest.jsonmodel;

import java.util.List;

public class RoomAliasGetRespData {

    private String room_id;
    private List<String> servers;


    public RoomAliasGetRespData() {
    }

    public RoomAliasGetRespData(String room_id, List<String> servers) {
        this.room_id = room_id;
        this.servers = servers;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        return "RoomAliasGetRespData{" +
                "room_id='" + room_id + '\'' +
                ", servers=" + servers +
                '}';
    }

}
