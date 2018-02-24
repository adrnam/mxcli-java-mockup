package io.arklitium.matrix.client.rest.jsonmodel;

public class SendMessageRespData {

    private String event_id;


    public SendMessageRespData() {
    }

    public SendMessageRespData(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    @Override
    public String toString() {
        return "SendMessageRespData{" +
                "event_id='" + event_id + '\'' +
                '}';
    }

}
