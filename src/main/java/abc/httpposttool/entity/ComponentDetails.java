package abc.httpposttool.entity;

import org.springframework.stereotype.Component;

@Component
public class ComponentDetails {
    //组件编码
    String componentCode;
    //交易状态
    String componentStuts;
    //组件耗时
    String componentUseTime;
    //交易码
    String transactionCode;
    //执行时间
    String componentTime;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getComponentStuts() {
        return componentStuts;
    }

    public void setComponentStuts(String componentStuts) {
        this.componentStuts = componentStuts;
    }

    public String getComponentUseTime() {
        return componentUseTime;
    }

    public void setComponentUseTime(String componentUseTime) {
        this.componentUseTime = componentUseTime;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getComponentTime() {
        return componentTime;
    }

    public void setComponentTime(String componentTime) {
        this.componentTime = componentTime;
    }

    @Override
    public String toString() {
        return "ComponentDetails{" +
                "componentCode='" + componentCode + '\'' +
                ", componentStuts='" + componentStuts + '\'' +
                ", componentUseTime='" + componentUseTime + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                ", componentTime='" + componentTime + '\'' +
                '}';
    }
}
