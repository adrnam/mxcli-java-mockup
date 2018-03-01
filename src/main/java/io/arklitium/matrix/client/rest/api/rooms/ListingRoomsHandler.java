package io.arklitium.matrix.client.rest.api.rooms;

import io.arklitium.matrix.client.rest.api.Env;
import io.arklitium.matrix.client.rest.jsonmodel.GetPublicRoomsRespData;

public interface ListingRoomsHandler extends Env {

    String PUBLIC_ROOMS_PATH = MATRIX_CLIENT_ROOT_PATH + "/publicRooms";

    /**
     * Lists the public rooms on the server.
     * This API returns paginated responses.
     * The rooms are ordered by the number of joined members, with the largest rooms first.
     *
     * @param limit  Limit the number of results returned.
     * @param server A pagination token from a previous request, allowing clients to get the
     *               next (or previous) batch of rooms. The direction of pagination is specified solely by which
     *               token is supplied, rather than via an explicit flag.
     * @param since  The server to fetch the public room lists from. Defaults to the local server.
     * @return the information related to requested list of public rooms
     */
    GetPublicRoomsRespData getPublicRooms(Number limit, String since, String server) throws Exception;

    void postPublicRooms() throws Exception;

}
