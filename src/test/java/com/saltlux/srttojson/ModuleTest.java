package com.saltlux.srttojson;

import com.saltlux.srttojson.module.ContextHandler;
import com.saltlux.srttojson.module.ContextHandlerImpl;
import com.saltlux.srttojson.module.json.JSONParser;
import com.saltlux.srttojson.module.srt.SRTParser;
import com.saltlux.srttojson.module.srt.Subtitle;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ModuleTest {

    static File srtFile = new File("C:\\Users\\khlee\\Documents\\workspace\\ai-learning-data\\srtToJson\\src\\main\\resources\\sample\\VCR_cut8__30_0FPS.srt");
    static File jsonFile = new File("C:\\Users\\khlee\\Documents\\workspace\\ai-learning-data\\srtToJson\\src\\main\\resources\\sample\\VCR.cut8__30.0FPS.json");
    static File rsltFile = new File("C:\\Users\\khlee\\Documents\\workspace\\ai-learning-data\\srtToJson\\src\\main\\resources\\sample\\RSLT_VCR.cut8__30.0FPS.json");
    static ContextHandler ctxHandler = new ContextHandlerImpl();

    @Test
    void testSRTParser() throws IOException {
        for(Subtitle st : SRTParser.getSubtitlesFromFile(srtFile, false, false)) {
            System.out.println(st);
        }
    }

    @Test
    void testGetContextFromSrtFile() throws IOException {
        System.out.println(ctxHandler.getContextFromSrtFile(srtFile));
    }

    @Test
    void testGetContentFromJsonFile() throws IOException {
        System.out.println(JSONParser.getJsonObjFromJsonFile(jsonFile));
    }

    @Test
    void testGetLabelingFile() throws IOException {
        System.out.println(ctxHandler.getLabelingFile(jsonFile));
    }

    @Test
    void testCreateFinalJson() throws IOException {
        System.out.println(ctxHandler.createContext(ctxHandler.getLabelingFile(jsonFile), ctxHandler.getContextFromSrtFile(srtFile)));
    }

    @Test
    void testCreateContextFile() throws IOException {
        System.out.println(ctxHandler.createContextFile(ctxHandler.createContext(ctxHandler.getLabelingFile(jsonFile), ctxHandler.getContextFromSrtFile(srtFile)), rsltFile));
    }
}
