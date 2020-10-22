package com.saltlux.srttojson.module.json;

import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;

public class JSONParser {

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public static JSONObject getJsonObjFromJsonFile(File file) throws IOException {

        StringBuilder fileContents = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), DEFAULT_CHARSET));

        while (br.ready()) {
            fileContents.append(br.readLine());
        }
        br.close();

        return new JSONObject(fileContents.toString());
    }
}
