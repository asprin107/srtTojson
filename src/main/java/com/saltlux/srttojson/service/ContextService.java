package com.saltlux.srttojson.service;

import java.io.File;

public interface ContextService {

    /*
    srt, json 파일 업로드
    context json 파일 다운로드
    String 의 srt, json 전달.
     */
    String uploadDataSet(File srtFile, File jsonFile);
}
