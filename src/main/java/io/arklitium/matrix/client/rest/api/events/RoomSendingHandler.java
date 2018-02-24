package io.arklitium.matrix.client.rest.api.events;

import io.arklitium.matrix.client.rest.api.Env;
import io.arklitium.matrix.client.rest.jsonmodel.SendMessageReqData;
import io.arklitium.matrix.client.rest.jsonmodel.SendMessageRespData;
import org.apache.commons.lang3.StringUtils;


/**
 * This exposes APIs provided to GET events for a room:
 */
public interface RoomSendingHandler extends Env {

    String MSGTYPE_TEXT_TYPE = "m.text";
    String ROOMID_PATTERN = "{roomId}";
    String TXNID_PATTERN = "{txnId}";
    String ROOM_SEND_PATH = MATRIX_CLIENT_ROOT_PATH + "/rooms/" + ROOMID_PATTERN + "/send/" + ROOM_MESSAGE_EVENT + "/" + TXNID_PATTERN;

    /**
     * Builds the REST path to request a send-message event.
     *
     * @param roomId the Matrix room ID where to send
     * @param txnId the transaction ID for this event
     * @return the full REST path
     */
    static String buildPath(String roomId, String txnId) {
        String ret = StringUtils.replace(ROOM_SEND_PATH, ROOMID_PATTERN, roomId);
        ret = StringUtils.replace(ret, TXNID_PATTERN, txnId);
        return ret;
    }

    /**
     * Sends a message event to a room.
     *
     * @param sendMessageReqData the JSON data containing the message to send.
     * @return the information related to the event sent.
     */
    SendMessageRespData sendMessage(SendMessageReqData sendMessageReqData);

}
