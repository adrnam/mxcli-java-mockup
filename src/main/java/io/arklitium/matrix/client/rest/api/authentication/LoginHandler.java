package io.arklitium.matrix.client.rest.api.authentication;

import io.arklitium.matrix.client.rest.api.Env;
import io.arklitium.matrix.client.rest.jsonmodel.*;

/**
 * Endpoints related to operate user authentication.
 *
 */
public interface LoginHandler extends Env {

    String LOGIN_PATH = MATRIX_CLIENT_ROOT_PATH + "/login";
    String LOGOUT_PATH = MATRIX_CLIENT_ROOT_PATH + "/logout";
    String WHOAMI_PATH = MATRIX_CLIENT_ROOT_PATH + "/account/whoami";

    /**
     * Authenticates the user, and issues an access token they can use to authorize themself in subsequent requests.
     *
     * @param loginReqData the JSON data required to log in
     * @return the information related to user session
     */
    LoginRespData login(LoginReqData loginReqData);

    /**
     * Invalidates an existing access token, so that it can no longer be used for authorization.
     *
     * @param logoutReqData the JSON data required to log out
     * @return the information related to ended user's session
     */
    LogoutRespData logout(LogoutReqData logoutReqData);

    /**
     * Gets information about the owner of a given access token.
     *
     * @return the information about the logged user.
     */
    WhoamiRespData whoami();

}
