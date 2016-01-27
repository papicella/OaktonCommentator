package com.ibm.bluemix.ctp.oakton.cloudant;

/**
 * Created by pasapicella on 27/01/16.
 */
public class RiderInfoDataModel
{
    private String _id;
    private String _rev;
    private String data;

    public RiderInfoDataModel()
    {
    }

    public RiderInfoDataModel(String _id, String _rev, String data) {
        this._id = _id;
        this._rev = _rev;
        this.data = data;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_rev() {
        return _rev;
    }

    public void set_rev(String _rev) {
        this._rev = _rev;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
