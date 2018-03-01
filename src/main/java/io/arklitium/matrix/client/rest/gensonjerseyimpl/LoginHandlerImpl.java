package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import io.arklitium.matrix.client.rest.api.authentication.LoginHandler;
import io.arklitium.matrix.client.rest.context.SessionCtxt;
import io.arklitium.matrix.client.rest.jsonmodel.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Response;

public class LoginHandlerImpl implements LoginHandler {

    private SessionCtxt sessionCtxt;
    private RestController restController;


    public LoginHandlerImpl(SessionCtxt sessionCtxt, RestController restController) {
        this.sessionCtxt = sessionCtxt;
        this.restController = restController;
    }

    @Override
    public LoginRespData login(LoginReqData loginReqData) throws Exception {
        Response response = null;
        response = restController.doPOST(
                sessionCtxt.getHomeServer(),
                LoginHandler.LOGIN_PATH,
                null,
                loginReqData
        );
        LoginRespData loginRespData = response.readEntity(LoginRespData.class);
        return loginRespData;
    }

    @Override
    public LogoutRespData logout(LogoutReqData logoutReqData) throws Exception {
        Response response = restController.doPOST(
                sessionCtxt.getHomeServer(),
                LoginHandler.LOGOUT_PATH,
                null,
                logoutReqData
        );
        LogoutRespData logoutRespData = response.readEntity(LogoutRespData.class);
        return logoutRespData;
    }

    @Override
    public WhoamiRespData whoami() throws Exception {
        Response response = restController.doGET(
                sessionCtxt.getHomeServer(),
                LoginHandler.WHOAMI_PATH,
                null,
                sessionCtxt.getToken()
        );
        WhoamiRespData whoamiRespData = response.readEntity(WhoamiRespData.class);
        return whoamiRespData;
    }

}
