package abc.httpposttool.entity;

import org.springframework.stereotype.Component;

@Component
public class FlagDetails {

    String flagCode;
    String flagStuts;
    String flagMsg;
    String flagUseTime;
    String transactionCode;
    String componentCode;

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    public String getFlagStuts() {
        return flagStuts;
    }

    public void setFlagStuts(String flagStuts) {
        this.flagStuts = flagStuts;
    }

    public String getFlagMsg() {
        return flagMsg;
    }

    public void setFlagMsg(String flagMsg) {
        this.flagMsg = flagMsg;
    }

    public String getFlagUseTime() {
        return flagUseTime;
    }

    public void setFlagUseTime(String flagUseTime) {
        this.flagUseTime = flagUseTime;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    @Override
    public String toString() {
        return "FlagDetails{" +
                "flagCode='" + flagCode + '\'' +
                ", flagStuts='" + flagStuts + '\'' +
                ", flagMsg='" + flagMsg + '\'' +
                ", flagUseTime='" + flagUseTime + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                ", componentCode='" + componentCode + '\'' +
                '}';
    }
}
