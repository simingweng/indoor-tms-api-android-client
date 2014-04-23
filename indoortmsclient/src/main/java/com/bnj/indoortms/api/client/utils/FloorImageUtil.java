package com.bnj.indoortms.api.client.utils;

/**
 * Created by wen55527 on 4/22/14.
 */
public class FloorImageUtil {
    private static final String imageUrlTemplate = "http://192.168.1.182/%s/%s";
    private static FloorImageUtil ourInstance = new FloorImageUtil();

    private FloorImageUtil() {
    }

    public static FloorImageUtil getInstance() {
        return ourInstance;
    }

    public String getImageUrl(String buildingId, String image) {
        return String.format(imageUrlTemplate, buildingId, image);
    }
}
