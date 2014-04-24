package com.bnj.indoortms.api.client.request;

import com.bnj.indoortms.api.client.model.Building;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.gson.GsonFactory;

/**
 * Created by wen55527 on 4/24/14.
 */
public class GetFloorsByBuildingIdRequest extends BaseRequest<Building> {

    private static final String url = "/api/buildings/%s/floors";
    private String buildingId;

    public GetFloorsByBuildingIdRequest(String buildingId) {
        super(Building.class);
        this.buildingId = buildingId;
    }

    @Override
    public String getCacheKey() {
        return "floors." + buildingId;
    }

    @Override
    public Building loadDataFromNetwork() throws Exception {
        HttpRequest request = getHttpRequestFactory().buildGetRequest(new GenericUrl(host +
                String.format(url, buildingId)));
        request.setParser(GsonFactory.getDefaultInstance().createJsonObjectParser());
        return request.execute().parseAs(getResultType());
    }
}
