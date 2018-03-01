package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import io.arklitium.matrix.client.rest.api.events.RoomSendingHandler;
import io.arklitium.matrix.client.context.SessionCtxt;
import io.arklitium.matrix.client.rest.jsonmodel.SendMessageReqData;
import io.arklitium.matrix.client.rest.jsonmodel.SendMessageRespData;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

import javax.ws.rs.core.Response;

public class RoomSendingHandlerImpl implements RoomSendingHandler {

    private SessionCtxt sessionCtxt;
    private RestController restController;


    public RoomSendingHandlerImpl(SessionCtxt sessionCtxt, RestController restController) {
        this.sessionCtxt = sessionCtxt;
        this.restController = restController;
    }

    @Override
    public SendMessageRespData sendMessage(SendMessageReqData sendMessageReqData) throws Exception {
        String roomIdInUrlForm = null;
        try {
            roomIdInUrlForm = new URLCodec().encode(sessionCtxt.getCurrentRoom().getRoomId());
        } catch (EncoderException e) {
            throw new RuntimeException(e);
        }
        Response response = null;
        response = restController.doPUT(
                sessionCtxt.getHomeServer(),
                RoomSendingHandler.buildPath(roomIdInUrlForm, sessionCtxt.getTxnId().toString()),
                null,
                sendMessageReqData,
                sessionCtxt.getToken());
        SendMessageRespData sendMessageRespData = response.readEntity(SendMessageRespData.class);
        return sendMessageRespData;
    }

}
