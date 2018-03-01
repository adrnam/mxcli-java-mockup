package io.arklitium.matrix.client.context;

import io.arklitium.matrix.client.datamodel.Room;

import java.util.List;

public class SessionCtxt {

    private String homeServer;
    private String token;
    private List<Room> roomList;
    private Room currentRoom;
    private Integer txnId;

    public SessionCtxt(String homeServer, List<Room> roomList, Room currentRoom) {
        this.homeServer = homeServer;
        this.roomList = roomList;
        this.currentRoom = currentRoom;
        txnId = 0;
    }

    public String getHomeServer() {
        return homeServer;
    }

    public void setHomeServer(String homeServer) {
        this.homeServer = homeServer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Integer getTxnId() {
        return txnId;
    }

}
