/**
 *
 */
package com.bnj.indoortms.api.client.model;

import com.google.api.client.util.Key;

import java.io.Serializable;

/**
 * @author simingweng
 */
public class Location implements Serializable {

    @Key
    public double lng;
    @Key
    public double lat;

    /**
     *
     */
    public Location() {
        // TODO Auto-generated constructor stub
    }

}
