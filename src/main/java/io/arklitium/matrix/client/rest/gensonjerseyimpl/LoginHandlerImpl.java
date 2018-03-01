package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import io.arklitium.matrix.client.context.SessionCtxt;
import io.arklitium.matrix.client.rest.api.authentication.LoginHandler;
import io.arklitium.matrix.client.rest.jsonmodel.*;

public class LoginHandlerImpl implements LoginHandler {

    private SessionCtxt sessionCtxt;
    private RestController restController;


    public LoginHandlerImpl(SessionCtxt sessionCtxt, RestController restController) {
        this.sessionCtxt = sessionCtxt;
        this.restController = restController;
    }

    @Override
    public LoginRespData login(LoginReqData loginReqData) throws Exception {
        LoginRespData response = restController.doPOST(
                sessionCtxt.getHomeServer(),
                LoginHandler.LOGIN_PATH,
                null,
                loginReqData,
                LoginRespData.class
        );
        return response;
    }

    @Override
    public LogoutRespData logout(LogoutReqData logoutReqData) throws Exception {
        LogoutRespData response = restController.doPOST(
                sessionCtxt.getHomeServer(),
                LoginHandler.LOGOUT_PATH,
                null,
                logoutReqData,
                LogoutRespData.class
        );
        return response;
    }

    @Override
    public WhoamiRespData whoami() throws Exception {
        WhoamiRespData response = restController.doGET(
                sessionCtxt.getHomeServer(),
                LoginHandler.WHOAMI_PATH,
                null,
                sessionCtxt.getToken(),
                WhoamiRespData.class
        );
        return response;
    }

}
