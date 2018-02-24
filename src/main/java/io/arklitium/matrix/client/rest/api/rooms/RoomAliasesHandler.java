package io.arklitium.matrix.client.rest.api.rooms;

import io.arklitium.matrix.client.rest.api.Env;
import io.arklitium.matrix.client.rest.jsonmodel.*;
import org.apache.commons.lang3.StringUtils;

public interface RoomAliasesHandler extends Env {

    String ROOMALIAS_PATTERN = "{roomAlias}";

    String ROOM_ALIAS_PATH = MATRIX_CLIENT_ROOT_PATH + "directory/room/" + ROOMALIAS_PATTERN;

    static String buildPath(String roomAlias) {
        String ret = StringUtils.replace(ROOM_ALIAS_PATH, ROOMALIAS_PATTERN, roomAlias);
        return ret;
    }

    RoomAliasPutRespData putAlias(RoomAliasPutReqData roomAliasPutReqData);

    RoomAliasGetRespData getAliases(RoomAliasGetReqData roomAliasGetReqData);

    RoomAliasDeleteRespData deleteAlias(RoomaliasDeleteReqData roomaliasDeleteReqData);

}
