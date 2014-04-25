package com.bnj.indoortms.api.client.request;

import com.bnj.indoortms.api.client.model.Floor;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.http.MultipartFormDataContent;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.gson.GsonFactory;

import java.io.File;

/**
 * Created by wen55527 on 4/23/14.
 */
public class CreateFloorRequest extends BaseRequest<Floor> {

    private static final String url = "/api/buildings/%s/floors";
    private Floor floor;
    private String buildingId;
    private File newFloorPlan;

    public CreateFloorRequest(String buildingId, Floor floor, String floorPlan) {
        super(Floor.class);
        this.buildingId = buildingId;
        this.floor = floor;
        this.newFloorPlan = new File(floorPlan);
    }

    @Override
    public String getCacheKey() {
        return null;
    }

    @Override
    public Floor loadDataFromNetwork() throws Exception {
        MultipartFormDataContent multipart = new MultipartFormDataContent();
        MultipartContent.Part filePart = new MultipartContent.Part(new FileContent("image/jpeg",
                newFloorPlan));
        multipart.addPart(filePart, "image", newFloorPlan.getName());
        MultipartContent.Part jsonPart = new MultipartContent.Part(new JsonHttpContent
                (GsonFactory.getDefaultInstance(), floor));
        multipart.addPart(jsonPart, "floor", null);
        HttpRequest request = getHttpRequestFactory().buildPostRequest(new GenericUrl(host +
                String.format(url, buildingId)), multipart);
        request.setParser(GsonFactory.getDefaultInstance().createJsonObjectParser());
        return request.execute().parseAs(getResultType());
    }
}
