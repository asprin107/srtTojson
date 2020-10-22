package com.saltlux.srttojson.module;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public interface ContextHandler {

    /**
     * srt 파일 read 해서 java에서 사용 가능한 변수화
     * @param file
     * @return
     */
    JSONArray getContextFromSrtFile(File file) throws IOException;

    /**
     * label 파일 (json) read 해서 java 사용가능한 변수화
     * @param file
     * @return
     */
    JSONObject getLabelingFile(File file) throws IOException;

    /**
     *
     * @param labelData
     * @param contextData
     * @return
     */
    JSONObject createContext(JSONObject labelData, JSONArray contextData);

    /**
     * context 파일 생성.
     * @param contextData
     * @return String으로 생성한 파일 이름을 return
     */
    String createContextFile(JSONObject contextData, File file);
}
