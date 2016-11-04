/**
 * Created by Dany on 04/09/2016.
 *
 */

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;


import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/form", (request, response) -> {
            HashMap model = new HashMap();

            model.put("template", "/templates/form.html");
            return new ModelAndView(model, "/templates/greeting.html");// ese layout que pone no se donde lo encuentra
        }, new VelocityTemplateEngine());


        get("/greeting", (request, response) -> {
            HashMap model = new HashMap();

            model.put("template", "templates/greeting.html");
            return new ModelAndView(model, "/templates/layout.vtl"); // ese layout que pone no se donde lo encuentra
        }, new VelocityTemplateEngine());

    }

}

