package com.saltlux.srttojson.controller;

import com.saltlux.srttojson.module.ContextHandler;
import com.saltlux.srttojson.module.ContextHandlerImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class RestAPIController {

    @ResponseBody
    @RequestMapping(value = "uploadSRT",method = RequestMethod.POST)
    public String uploadSRTFile(@RequestParam("srtFile") MultipartFile srtfile) throws IOException {
        File file = new File(srtfile.getOriginalFilename());
        srtfile.transferTo(file);
        ContextHandler cxthandler = new ContextHandlerImpl();
        return cxthandler.getContextFromSrtFile(file).toString();
    }
}
