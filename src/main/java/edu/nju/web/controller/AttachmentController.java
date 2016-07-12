package edu.nju.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dora on 2016/7/12.
 */
@Controller
public class AttachmentController {


    @RequestMapping(value="/form",method = RequestMethod.POST)
    @ResponseBody boolean handleFormUpload(@RequestParam("name") String name,
                                   @RequestParam("file") Part file) {
        System.out.println("name:"+name);
        System.out.println("part:"+file.getSubmittedFileName());
        try {
            InputStream inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // store bytes from uploaded file somewhere

        return true;
    }




}
