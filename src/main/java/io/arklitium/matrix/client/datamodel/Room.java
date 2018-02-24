package io.arklitium.matrix.client.datamodel;

import java.util.List;

public class Room {

    private String roomId;
    private List<String> aliases;
    private String name;

    public Room(String roomId, List<String> aliases, String name) {
        this.roomId = roomId;
        this.aliases = aliases;
        this.name = name;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", aliases=" + aliases +
                ", name='" + name + '\'' +
                '}';
    }

}
