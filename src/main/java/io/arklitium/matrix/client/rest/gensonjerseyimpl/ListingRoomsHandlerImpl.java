package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import io.arklitium.matrix.client.context.SessionCtxt;
import io.arklitium.matrix.client.rest.api.rooms.ListingRoomsHandler;
import io.arklitium.matrix.client.rest.jsonmodel.GetPublicRoomsRespData;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class ListingRoomsHandlerImpl implements ListingRoomsHandler {

    private SessionCtxt sessionCtxt;
    private RestController restController;


    public ListingRoomsHandlerImpl(SessionCtxt sessionCtxt, RestController restController) {
        this.sessionCtxt = sessionCtxt;
        this.restController = restController;
    }

    @Override
    public GetPublicRoomsRespData getPublicRooms(Number limit, String since, String server) throws Exception {
        List<Pair> queryParameters = new QueryParametersBuilder()
                .addParameter("limit", (limit == null ? null : limit.toString()))
                .addParameter("since", since)
                .addParameter("server", server)
                .create();
        GetPublicRoomsRespData response = restController.doGET(
                sessionCtxt.getHomeServer(),
                ListingRoomsHandler.PUBLIC_ROOMS_PATH,
                queryParameters,
                null,
                GetPublicRoomsRespData.class
        );
        return response;
    }

    @Override
    public void postPublicRooms() throws Exception {
        // todo
    }

}
