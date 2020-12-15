package abc.httpposttool.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelEntity {
    public String sheetName;
    public long sheetNum;
    public String url;
    public Map<String, String> pubInfoPre = new LinkedHashMap<String, String>();
    public Map<String, String> pubInfoAft = new LinkedHashMap<String, String>();
    public Map<String, String> prvInfo = new LinkedHashMap<String, String>();
    public String reqTxt;
    public String respTxt;
    public String respCodeVal;
    public String respCode;
    public String expRespCode;
    public long useTime;
    public long beginTime;
    public long endTime;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public long getSheetNum() {
        return sheetNum;
    }

    public void setSheetNum(long sheetNum) {
        this.sheetNum = sheetNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getPubInfoPre() {
        return pubInfoPre;
    }

    public void setPubInfoPre(Map<String, String> pubInfoPre) {
        this.pubInfoPre = pubInfoPre;
    }

    public Map<String, String> getPubInfoAft() {
        return pubInfoAft;
    }

    public void setPubInfoAft(Map<String, String> pubInfoAft) {
        this.pubInfoAft = pubInfoAft;
    }

    public Map<String, String> getPrvInfo() {
        return prvInfo;
    }

    public void setPrvInfo(Map<String, String> prvInfo) {
        this.prvInfo = prvInfo;
    }

    public String getReqTxt() {
        return reqTxt;
    }

    public void setReqTxt(String reqTxt) {
        this.reqTxt = reqTxt;
    }

    public String getRespTxt() {
        return respTxt;
    }

    public void setRespTxt(String respTxt) {
        this.respTxt = respTxt;
    }

    public String getRespCodeVal() {
        return respCodeVal;
    }

    public void setRespCodeVal(String respCodeVal) {
        this.respCodeVal = respCodeVal;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getExpRespCode() {
        return expRespCode;
    }

    public void setExpRespCode(String expRespCode) {
        this.expRespCode = expRespCode;
    }

    public long getUseTime() {
        return useTime;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

}
