/**
 *
 */
package com.bnj.indoortms.api.client.request;

import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;
import com.octo.android.robospice.retry.DefaultRetryPolicy;

/**
 * @param <T>
 * @author simingweng
 */
public abstract class BaseRequest<T> extends GoogleHttpClientSpiceRequest<T> {

    protected String host = "http://192.168.1.182:3000";

    public BaseRequest(Class<T> clazz) {
        super(clazz);
        setRetryPolicy(new DefaultRetryPolicy(0, 0, 0));
    }

    public abstract String getCacheKey();

}