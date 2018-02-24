package io.arklitium.matrix.client.rest.jsonmodel;

public class RoomAliasGetReqData {

    private String roomAlias;

    public RoomAliasGetReqData(String roomAlias) {
        this.roomAlias = roomAlias;
    }

    public String getRoomAlias() {
        return roomAlias;
    }

    public void setRoomAlias(String roomAlias) {
        this.roomAlias = roomAlias;
    }

    @Override
    public String toString() {
        return "RoomAliasGetReqData{" +
                "roomAlias='" + roomAlias + '\'' +
                '}';
    }

}
