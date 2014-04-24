/**
 *
 */
package com.bnj.indoortms.api.client.model;

import com.google.api.client.util.Key;

import java.io.Serializable;

/**
 * @author simingweng
 */
public class GCP implements Serializable {

    @Key
    public double x;
    @Key
    public double y;
    @Key
    public double lng;
    @Key
    public double lat;

    /**
     *
     */
    public GCP() {
        // TODO Auto-generated constructor stub
    }

}
