package com.bnj.indoortms.api.client.request;

import com.bnj.indoortms.api.client.model.Floor;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.gson.GsonFactory;

/**
 * Created by wen55527 on 4/23/14.
 */
public class CreateFloorRequest extends BaseRequest<Floor> {

    private static final String url = "/api/buildings/%s/floors";
    private Floor floor;
    private String buildingId;

    public CreateFloorRequest(String buildingId, Floor floor) {
        super(Floor.class);
        this.buildingId = buildingId;
        this.floor = floor;
    }

    @Override
    public String getCacheKey() {
        return null;
    }

    @Override
    public Floor loadDataFromNetwork() throws Exception {
        HttpRequest request = getHttpRequestFactory().buildPostRequest(
                new GenericUrl(host + String.format(url, buildingId)),
                new JsonHttpContent(GsonFactory.getDefaultInstance(),
                        floor)
        );
        request.setParser(GsonFactory.getDefaultInstance()
                .createJsonObjectParser());
        return request.execute().parseAs(getResultType());
    }
}
