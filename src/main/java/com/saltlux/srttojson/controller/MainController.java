package com.saltlux.srttojson.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    /**
     * data 로 처리하는 endpoint
     * input    srt     String
     *          json    JSONObject
     * output   json    JSONObject
     */
    @ResponseBody
    @RequestMapping(value = "/genJsonFile", method = RequestMethod.GET)
    public JSONObject finalJsonFromSerializedData() {
        JSONObject rslt = null;
        return rslt;
    }

    /**
     * file 로 처리하는 endpoint
     * input    srt     File
     *          json    File
     * output   filename    String
     */
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String createMetadataFromSerializedData() {
        return "test";
    }
}
