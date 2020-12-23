package abc.httpposttool.vo;

import org.springframework.stereotype.Component;

@Component
public class CreateList {
    //组件编码
    String componentCode;
    //交易码
    String transactionCode;
    //flag编码
    String flagCode;
    //flag信息
    String flagMsg;
    //返回嘛
    String responseCode;
    //交易时间
    String flagData;


    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    public String getFlagMsg() {
        return flagMsg;
    }

    public void setFlagMsg(String flagMsg) {
        this.flagMsg = flagMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getFlagData() {
        return flagData;
    }

    public void setFlagData(String flagData) {
        this.flagData = flagData;
    }

    @Override
    public String toString() {
        return "CreateList{" +
                "componentCode='" + componentCode + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                ", flagCode='" + flagCode + '\'' +
                ", flagMsg='" + flagMsg + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", flagData='" + flagData + '\'' +
                '}';
    }
}
