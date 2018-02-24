package io.arklitium.matrix.client.rest.api;

public interface Env {

    // path without starting with "/", because jersey add it already
    String MATRIX_CLIENT_ROOT_PATH = "_matrix/client/r0";

    // event IDs
    String ROOM_MESSAGE_EVENT = "m.room.message";
    String ROOM_MEMBER_EVENT = "m.room.member";

}
