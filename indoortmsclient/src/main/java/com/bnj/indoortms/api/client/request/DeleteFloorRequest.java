package com.bnj.indoortms.api.client.request;

import com.bnj.indoortms.api.client.model.Floor;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.gson.GsonFactory;

/**
 * Created by simingweng on 26/4/14.
 */
public class DeleteFloorRequest extends BaseRequest<Floor> {

    private static final String url = "/api/buildings/%s/floors/%s";
    private String buildingId;
    private String floorId;

    public DeleteFloorRequest(String buildingId, String floorId) {
        super(Floor.class);
        this.buildingId = buildingId;
        this.floorId = floorId;
    }

    @Override
    public String getCacheKey() {
        return null;
    }

    @Override
    public Floor loadDataFromNetwork() throws Exception {
        HttpRequest request = getHttpRequestFactory().buildDeleteRequest(new GenericUrl(host +
                String
                        .format(url, buildingId, floorId)));
        request.setParser(GsonFactory.getDefaultInstance().createJsonObjectParser());
        return request.execute().parseAs(getResultType());
    }
}
