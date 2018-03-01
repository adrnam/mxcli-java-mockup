package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import io.arklitium.matrix.client.rest.api.rooms.ListingRoomsHandler;
import io.arklitium.matrix.client.rest.context.SessionCtxt;
import io.arklitium.matrix.client.rest.jsonmodel.GetPublicRoomsRespData;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Response;
import java.util.List;

public class ListingRoomsHandlerImpl implements ListingRoomsHandler {

    private final static Logger log = LogManager.getLogger(ListingRoomsHandlerImpl.class);

    private SessionCtxt sessionCtxt;
    private RestController restController;


    public ListingRoomsHandlerImpl(SessionCtxt sessionCtxt, RestController restController) {
        this.sessionCtxt = sessionCtxt;
        this.restController = restController;
    }

    @Override
    public GetPublicRoomsRespData getPublicRooms(Number limit, String since, String server) {
        List<Pair> queryParameters = new QueryParamatersBuilder()
                .addParameter("limit", (limit == null ? null : limit.toString()))
                .addParameter("since", since)
                .addParameter("server", server)
                .create();
        Response response = restController.doGET(
                sessionCtxt.getHomeServer(),
                ListingRoomsHandler.PUBLIC_ROOMS_PATH,
                queryParameters,
                sessionCtxt.getToken()
        );
        GetPublicRoomsRespData getPublicRoomsRespData = response.readEntity(GetPublicRoomsRespData.class);
        log.info("status=" + response.getStatus() + " response: " + getPublicRoomsRespData.toString());
        return getPublicRoomsRespData;
    }

    @Override
    public void postPublicRooms() {
        // todo
    }

}
