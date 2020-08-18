package com.fanwenjie.api.controller;

import com.fanwenjie.api.model.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class API {
    @Value("${properties.path}")
    String DATA_PATH;
    @RequestMapping("/**")
    String router(HttpServletRequest request){
        Data data = new Data(DATA_PATH);
        String URI = request.getRequestURI();
        String msg = null;
        try {
            msg =  data.getData(URI);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
