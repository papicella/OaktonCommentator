package com.ibm.bluemix.ctp.oakton.cloudant;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ibm.bluemix.ctp.oakton.domain.Rider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pasapicella on 27/01/16.
 */
public class CloudantConfiguration
{
    private static CloudantClient cloudantClient = null;
    private static boolean isCreated = false;
    private static CloudantConfiguration instance = null;

    private CloudantConfiguration()
    {
    }

    public static CloudantClient getInstance()
    {
        if (cloudantClient == null)
        {
            cloudantClient = new CloudantClient("bb6d86e3-85fc-412e-b4b1-ae68c819e55b-bluemix",
                                                "bb6d86e3-85fc-412e-b4b1-ae68c819e55b-bluemix",
                                                "3abafade309ce8a6b460bcef7999f04e5039e3c1f9eb2ba3b49a46046adcffe4");
            isCreated = true;
            return cloudantClient;
        }
        else
        {
            return cloudantClient;
        }

    }

    /*
    public static void main(String[] args) throws Exception
    {

        //testing
        CloudantClient cc = CloudantConfiguration.getInstance();

        Database cd = cc.database("ridertemp", false);

        String data = "{\n" +
                "  \"Timestamp\": \"1437736287\",\n" +
                "  \"Riders\": [\n" +
                "    {\n" +
                "      \"RiderId\": \"1\",\n" +
                "      \"Cadence\": \"90\",\n" +
                "      \"Speed\": \"23\",\n" +
                "      \"HeartRate\": \"176\"\n" +
                "    },\n" +
                "\t{\n" +
                "\t  \"RiderId\": \"2\",\n" +
                "      \"Cadence\": \"80\",\n" +
                "      \"Speed\": \"27\",\n" +
                "      \"HeartRate\": \"160\"\n" +
                "\n" +
                "\t},\n" +
                "\t{\n" +
                "\t  \"RiderId\": \"4\",\n" +
                "      \"Cadence\": \"80\",\n" +
                "      \"Speed\": \"22\",\n" +
                "      \"HeartRate\": \"170\"\n" +
                "\n" +
                "\t}\n" +
                "  ]\n" +
                "}";

        RiderInfoDataModel riderData = new RiderInfoDataModel("1", data, null);
        RiderInfoDataModel riderObjectInDb = cd.find(RiderInfoDataModel.class,"1");

        Response postResponse = null;

        // When the db already has the ID in it
        if(riderObjectInDb!=null)
        {
            riderObjectInDb.setData(data);
            postResponse = cd.update(riderObjectInDb);
        }
        //new insert of the doc
        else
        {
            postResponse = cd.save(riderData);
        }

        String id = postResponse.getId();
        System.out.println("ID : " + id);


    }

    */

}
