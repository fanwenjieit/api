package com.fanwenjie.api.model;

import java.io.*;
import java.util.Properties;

public class Data {
    String DATA_PATH;
    public Data(String path) {
        if(null!=path){
            DATA_PATH = path;
        }else {
            DATA_PATH = "D:"+File.pathSeparator+"data"+File.pathSeparator+"mydata.properties";
        }
    }

    public String getData(String URI) throws IOException {
        String data=null;
        if(null==URI){
            return null;
        }else {

            if((""+URI.charAt(0)).equals("/")){
                URI = URI.substring(1);
            }
            String propName = URI.replaceAll("/",".");
            Properties prop = new Properties();
            InputStream inputStream = new FileInputStream(DATA_PATH);
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            prop.load(bf);
            data = prop.getProperty(propName,"null");
        }
        return data;
    }
}
