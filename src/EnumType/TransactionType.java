package EnumType;

public enum TransactionType {
    DEPOSIT(10),
    WITHDRAW(20),
    TRANSFER(30),
    PAYMENT(40),
    OTHER(100);

    private final int transactionCode;

    public int getTransactionCode() {
        return transactionCode;
    }

    private TransactionType(int code) {
        this.transactionCode =code;
    }




}
