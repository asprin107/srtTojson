package com.saltlux.srttojson.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    /**
     * data 로 처리하는 endpoint
     * input    srt     String
     *          json    JSONObject
     * output   json    JSONObject
     */
    @ResponseBody
    public JSONObject finalJsonFromSerializedData() {
        JSONObject rslt = null;
        return rslt;
    }

    /**
     * file 로 처리하는 endpoint
     * input    srt     File
     *          json    File
     * output   json    File
     */
}
