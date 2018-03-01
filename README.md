# mxcli-java-mockup
Matrix client in Java for testing (WIP)


### Example of sending message (using Java main method):
See below.

Required Values:
* your ```MATRIX_HS_SERVER``` in ```SessionCtxt``` object;
* your ```USERNAME``` and ```PASSWORD```  in ```LoginReqData``` object;
* your ```ROOM ID``` (e.g. "```!sKeLjnzKTXVithnjLF:example.org```") in  ```Room``` object

Note: 
* if your server is not configured to accept HTTPS, set ```RestController(false, false)```
* if your server uses HTTPS with auto signed certificate, set ```RestController(true, true)```
* if your server uses HTTPS and valid certificate, set ```RestController(true, false)```
```Java
public static void main(String[] args) throws Exception {
        // initialize the session context
        RestController restController = new RestController(true, false);
        SessionCtxt sessionCtxt = new SessionCtxt(<MATRIX_HS_SERVER>, null, null);

        // log in homeserver with your credentials and get the auth token
        LoginHandler loginHandler = new LoginHandlerImpl(sessionCtxt, restController);
        LoginReqData loginReqData = new LoginReqData(<USERNAME>, <PASSWORD>);
        LoginRespData loginRespData = loginHandler.login(loginReqData);
        sessionCtxt.setToken(loginRespData.getAccess_token());

        // optional, only to print in console your user info in order to check token is ok
        WhoamiRespData whoamiRespData = loginHandler.whoami();

        // set an existing room (name is optional)
        Room room = new Room(<ROOM-ID>, null, <ROOM-NAME>, 0);
        sessionCtxt.setCurrentRoom(room);

        // send message to above room
        String messageBody = "test -- [" + (new Date().toString()) + "] --";
        RoomSendingHandler roomSendingHandler = new RoomSendingHandlerImpl(sessionCtxt, restController);
        SendMessageReqData sendMessageReqData = new SendMessageReqData(RoomSendingHandler.MSGTYPE_TEXT_TYPE,
                messageBody, sessionCtxt.getCurrentRoom().getTxnId());
        SendMessageRespData sendMessageRespData = roomSendingHandler.sendMessage(sendMessageReqData);

        /// log out, nothing is displayed
        LogoutRespData logoutRespData = loginHandler.logout(new LogoutReqData());
    }
```
