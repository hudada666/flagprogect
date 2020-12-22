package abc.httpposttool.entity;

public class TransactionDetails {
    //交易码
    String transactionCode;
    //交易状态
    String transactionStuts;
    //时间
    String transactionTime;

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getTransactionStuts() {
        return transactionStuts;
    }

    public void setTransactionStuts(String transactionStuts) {
        this.transactionStuts = transactionStuts;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "transactionCode='" + transactionCode + '\'' +
                ", transactionStuts='" + transactionStuts + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                '}';
    }
}
