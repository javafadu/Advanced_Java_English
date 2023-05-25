package EnumType;

public class MainTest {

    public static void main(String[] args) {
/*        useConstantMethod(1);
        useConstantMethod(2);
        useConstantMethod(3);
        useConstantMethod(4);
        useConstantMethod(100);
        useConstantMethod(5); // NO CTE*/


        useEnumMethod(TransactionType.DEPOSIT);
        useEnumMethod(TransactionType.PAYMENT);
        useEnumMethod(TransactionType.WITHDRAW);
        useEnumMethod(TransactionType.TRANSFER);
        // useEnumMethod(TransactionType.A); CTE Warning

    }

    // old version - classic way
    private static void useConstantMethod(int i) {
        if(i==TransactionTypeConstant.DEPOSIT) {
            System.out.println("Money is depositing");
        } else if(i==TransactionTypeConstant.WITHDRAW) {
            System.out.println("Money is withdrawing");
        } else if(i==TransactionTypeConstant.TRANSFER) {
            System.out.println("Money is transferring");
        } else if(i==TransactionTypeConstant.PAYMENT) {
            System.out.println("Money is in payment");
        } else if(i==TransactionTypeConstant.OTHER) {
            System.out.println("Other");
        }
    }

    // new Enum type
    private static void useEnumMethod(TransactionType transactionType) {
        if(transactionType==TransactionType.DEPOSIT) {
            System.out.println("Money is depositing");
        } else if (transactionType==TransactionType.WITHDRAW) {
            System.out.println("Money is withdrawing");
        } else if (transactionType==TransactionType.TRANSFER) {
            System.out.println("Money is transferring");
        } else if (transactionType==TransactionType.PAYMENT) {
            System.out.println("Money is in payment");
        } else if (transactionType==TransactionType.OTHER) {
            System.out.println("Other");
        }

        // Enum type Methods
        System.out.println("Enum Type: "+transactionType.name());  // Enum name
        System.out.println("Enum Code Value : "+transactionType.getTransactionCode()); // Enum code
        System.out.println("Enum Ordinal : "+transactionType.ordinal()); // Enum ordinal
        System.out.println();


    }






}
