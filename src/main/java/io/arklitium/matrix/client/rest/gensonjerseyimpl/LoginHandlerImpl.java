package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import io.arklitium.matrix.client.rest.api.authentication.LoginHandler;
import io.arklitium.matrix.client.rest.context.SessionCtxt;
import io.arklitium.matrix.client.rest.jsonmodel.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Response;

public class LoginHandlerImpl implements LoginHandler {

    private final static Logger log = LogManager.getLogger(LoginHandlerImpl.class);

    private SessionCtxt sessionCtxt;
    private RestController restController;


    public LoginHandlerImpl(SessionCtxt sessionCtxt, RestController restController) {
        this.sessionCtxt = sessionCtxt;
        this.restController = restController;
    }

    @Override
    public LoginRespData login(LoginReqData loginReqData) {
        Response response = null;
        response = restController.doPOST(
                sessionCtxt.getHomeServer(),
                LoginHandler.LOGIN_PATH,
                loginReqData
        );
        LoginRespData loginRespData = response.readEntity(LoginRespData.class);
        log.info("status=" + response.getStatus() + " response: " + loginRespData.toString());
        return loginRespData;
    }

    @Override
    public LogoutRespData logout(LogoutReqData logoutReqData) {
        Response response = restController.doPOST(
                sessionCtxt.getHomeServer(),
                LoginHandler.LOGOUT_PATH,
                logoutReqData
        );
        LogoutRespData logoutRespData = response.readEntity(LogoutRespData.class);
        log.info("status=" + response.getStatus() + " response: " + logoutRespData.toString());
        return logoutRespData;
    }

    @Override
    public WhoamiRespData whoami() {
        Response response = restController.doGET(
                sessionCtxt.getHomeServer(),
                LoginHandler.WHOAMI_PATH,
                sessionCtxt.getToken()
        );
        WhoamiRespData whoamiRespData = response.readEntity(WhoamiRespData.class);
        log.info("status=" + response.getStatus() + " response: " + whoamiRespData.toString());
        return whoamiRespData;
    }

}
