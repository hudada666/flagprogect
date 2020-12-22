package abc.httpposttool.entity;

public class ComponentDetails {
    //组件编码
    String componentCode;
    //交易状态
    String componentStuts;
    //组件耗时
    String componentUseTime;
    //交易码
    String transactionCode;
    //执行顺序编号
    int componentOrder;

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

    public int getComponentOrder() {
        return componentOrder;
    }

    public void setComponentOrder(int componentOrder) {
        this.componentOrder = componentOrder;
    }

    @Override
    public String toString() {
        return "ComponentDetails{" +
                "componentCode='" + componentCode + '\'' +
                ", componentStuts='" + componentStuts + '\'' +
                ", componentUseTime='" + componentUseTime + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                ", componentOrder=" + componentOrder +
                '}';
    }
}
