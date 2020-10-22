package com.saltlux.srttojson.module;

import com.saltlux.srttojson.module.json.JSONParser;
import com.saltlux.srttojson.module.srt.SRTParser;
import com.saltlux.srttojson.module.srt.Subtitle;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContextHandlerImpl implements ContextHandler{

    public static final String MAIN_KEY = "context";

    public JSONArray getContextFromSrtFile(File file) throws IOException {
        return assembleCtx(SRTParser.getSubtitlesFromFile(file, false, false));
    }

    public JSONObject getLabelingFile(File file) throws IOException {
        return JSONParser.getJsonObjFromJsonFile(file);
    }

    public JSONObject createContext(JSONObject labelData, JSONArray contextData) {
        return labelData.put(MAIN_KEY, contextData);
    }

    public String createContextFile(JSONObject contextData, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contextData.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getName();
    }



    private JSONArray assembleCtx(ArrayList<Subtitle> records) {
        JSONArray ctx = new JSONArray();
        for(Subtitle st : records) {
            JSONObject temp = new JSONObject();
            temp.put("startTime", st.timeIn);
            temp.put("endTime", st.timeOut);
            temp.put("data", st.text);
            ctx.put(temp);
        }
        return ctx;
    }
}
