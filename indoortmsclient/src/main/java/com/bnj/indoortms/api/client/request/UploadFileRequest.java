package com.bnj.indoortms.api.client.request;

import com.bnj.indoortms.api.client.model.UploadedFile;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.http.MultipartFormDataContent;
import com.google.api.client.json.gson.GsonFactory;

import java.io.File;

/**
 * Created by wen55527 on 4/23/14.
 */
public class UploadFileRequest extends BaseRequest<UploadedFile> {

    private static final String url = "/api/upload";
    private File file;

    public UploadFileRequest(String file) {
        super(UploadedFile.class);
        this.file = new File(file);
    }

    @Override
    public String getCacheKey() {
        return null;
    }

    @Override
    public UploadedFile loadDataFromNetwork() throws Exception {

        MultipartFormDataContent multipart = new MultipartFormDataContent();
        MultipartContent.Part filePart = new MultipartContent.Part(new FileContent("image/jpeg",
                file));
        multipart.addPart(filePart, "image", file.getName());
        HttpRequest request = getHttpRequestFactory().buildPostRequest(
                new GenericUrl(host + url), multipart);
        request.setParser(GsonFactory.getDefaultInstance()
                .createJsonObjectParser());
        return request.execute().parseAs(getResultType());
    }
}
