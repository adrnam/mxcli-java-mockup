package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import io.arklitium.matrix.client.context.SessionCtxt;
import io.arklitium.matrix.client.rest.api.rooms.RoomAliasesHandler;
import io.arklitium.matrix.client.rest.jsonmodel.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoomAliasesHandlerImpl implements RoomAliasesHandler {

    private final static Logger log = LogManager.getLogger(RoomAliasesHandlerImpl.class);

    private SessionCtxt sessionCtxt;
    private RestController restController;


    public RoomAliasesHandlerImpl(SessionCtxt sessionCtxt, RestController restController) {
        this.sessionCtxt = sessionCtxt;
        this.restController = restController;
    }

    @Override
    public RoomAliasPutRespData putAlias(RoomAliasPutReqData roomAliasPutReqData) throws Exception {
        log.error("not yet implemented");
        return null;
    }

    @Override
    public RoomAliasGetRespData getAliases(RoomAliasGetReqData roomAliasGetReqData) throws Exception {
        RoomAliasGetRespData response = restController.doGET(
                sessionCtxt.getHomeServer(),
                RoomAliasesHandler.buildPath(roomAliasGetReqData.getRoomAlias()),
                null,
                RoomAliasGetRespData.class
        );
        return response;
    }

    @Override
    public RoomAliasDeleteRespData deleteAlias(RoomaliasDeleteReqData roomaliasDeleteReqData) throws Exception {
        log.error("not yet implemented");
        return null;
    }

}
