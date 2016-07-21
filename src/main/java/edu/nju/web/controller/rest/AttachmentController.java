package edu.nju.web.controller.rest;

import edu.nju.web.util.PostObjectPolicy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dora on 2016/7/12.
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/rest")
public class AttachmentController {


    @RequestMapping(value="/form",method = RequestMethod.POST)
    void handleFormUpload(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("/form");

        Map<String,Object> result = new HashMap<>();


//        String guid = request.getParameter("guid");
//        System.out.println(guid);


        try {
            (new PostObjectPolicy()).doPost(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



//        try {
//            InputStream inputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // store bytes from uploaded file somewhere


//        result.put("success",1);
//        result.put("message","success");
//        result.put("url",guid);
//        return result;
    }




}
