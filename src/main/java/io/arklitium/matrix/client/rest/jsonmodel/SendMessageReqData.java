package io.arklitium.matrix.client.rest.jsonmodel;

public class SendMessageReqData {

    private String msgtype;
    private String body;
    private int txnId;

    public SendMessageReqData(String msgtype, String body, int txnId) {
        this.msgtype = msgtype;
        this.body = body;
        this.txnId = txnId;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getTxnId() {
        return txnId;
    }

    public void setTxnId(int txnId) {
        this.txnId = txnId;
    }

    @Override
    public String toString() {
        return "SendMessageReqData{" +
                "msgtype='" + msgtype + '\'' +
                ", body='" + body + '\'' +
                ", txnId=" + txnId +
                '}';
    }

}
