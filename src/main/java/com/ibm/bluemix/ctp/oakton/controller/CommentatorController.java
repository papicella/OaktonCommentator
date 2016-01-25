package com.ibm.bluemix.ctp.oakton.controller;

import com.ibm.bluemix.ctp.oakton.domain.Rider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CommentatorController implements ServletContextAware
{
    private static final Logger log = LoggerFactory.getLogger(CommentatorController.class);
    private static final JsonParser parser = JsonParserFactory.getJsonParser();

    private ServletContext context;

    public void setServletContext(ServletContext servletContext)
    {
        this.context = servletContext;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String listTeams (Model model)
    {
        String jsonString = (String) context.getAttribute("riderData");
        List<Rider> riders = new ArrayList<>();

        if (jsonString != null)
        {
            if (jsonString.trim().length() != 0)
            {
                Map<String, Object> jsonMap = parser.parseMap(jsonString);
                List<Object> riderList = (List<Object>) jsonMap.get("Riders");

                for (Object rider: riderList)
                {
                    Map m = (Map) rider;
                    log.info((String)m.get("RiderId"));
                    riders.add(
                            new Rider((String)m.get("RiderId"),
                                    (String)m.get("Cadence"),
                                    (String)m.get("Speed"),
                                    (String)m.get("HeartRate")));
                }

                log.info("Riders = " + riders.size());
                model.addAttribute("ridercount", riders.size());
            }
        }
        else
        {
            model.addAttribute("ridercount", 0);
        }

        model.addAttribute("riders", riders);

        return "commentator";

    }
}
