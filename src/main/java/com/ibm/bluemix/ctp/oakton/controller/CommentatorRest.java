package com.ibm.bluemix.ctp.oakton.controller;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.ibm.bluemix.ctp.oakton.cloudant.CloudantConfiguration;
import com.ibm.bluemix.ctp.oakton.cloudant.RiderInfoDataModel;
import com.ibm.bluemix.ctp.oakton.domain.Rider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
public class CommentatorRest implements ServletContextAware
{
    private static final Logger log = LoggerFactory.getLogger(CommentatorRest.class);

    private ServletContext context;

    public void setServletContext(ServletContext servletContext)
    {
        this.context = servletContext;
    }

    @RequestMapping(value = "/dummydata", method = RequestMethod.GET)
    public void loadDummyData()
    {
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

        addDataToCloudant(data);
        //context.setAttribute("riderData", data);
    }

    @RequestMapping(value = "/riderDataLoad", method=RequestMethod.POST)
    public String newDataLoad(@RequestBody String riderJson)
    {
        //log.info(riderJson);
        //context.setAttribute("riderData", riderJson);
        addDataToCloudant(riderJson);

        return "Data Loaded successfully...";
    }

    private void addDataToCloudant (String riderJson)
    {
        CloudantClient cc = CloudantConfiguration.getInstance();
        Database cd = cc.database("ridertemp", false);

        // Get current riderData for key = 1
        RiderInfoDataModel riderObjectInDb = cd.find(RiderInfoDataModel.class,"1");
        Response postResponse = null;

        // When the db already has the ID in it
        if(riderObjectInDb!=null)
        {
            riderObjectInDb.setData(riderJson);
            postResponse = cd.update(riderObjectInDb);
        }
        //new insert of the doc
        else
        {
            postResponse = cd.save(riderJson);
        }

    }
}
