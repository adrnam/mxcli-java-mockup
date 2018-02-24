package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import io.arklitium.matrix.client.rest.api.events.RoomSendingHandler;
import io.arklitium.matrix.client.rest.context.SessionCtxt;
import io.arklitium.matrix.client.rest.jsonmodel.SendMessageReqData;
import io.arklitium.matrix.client.rest.jsonmodel.SendMessageRespData;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Response;

public class RoomSendingHandlerImpl implements RoomSendingHandler {

    private final static Logger log = LogManager.getLogger(RoomSendingHandlerImpl.class);

    private SessionCtxt sessionCtxt;
    private RestController restController;


    public RoomSendingHandlerImpl(SessionCtxt sessionCtxt, RestController restController) {
        this.sessionCtxt = sessionCtxt;
        this.restController = restController;
    }

    @Override
    public SendMessageRespData sendMessage(SendMessageReqData sendMessageReqData) {
        String roomIdInUrlForm = null;
        try {
            roomIdInUrlForm = new URLCodec().encode(sessionCtxt.getCurrentRoom().getRoomId());
        } catch (EncoderException e) {
            log.error(e.getMessage());
            return null;
        }
        Response response = null;
        response = restController.doPUT(
                sessionCtxt.getHomeServer(),
                RoomSendingHandler.buildPath(roomIdInUrlForm, sessionCtxt.getTxnId().toString()),
                sessionCtxt.getToken(),
                sendMessageReqData);
        SendMessageRespData sendMessageRespData = response.readEntity(SendMessageRespData.class);
        log.info("status=" + response.getStatus() + " response: " + sendMessageRespData.toString());
        return sendMessageRespData;
    }

}
