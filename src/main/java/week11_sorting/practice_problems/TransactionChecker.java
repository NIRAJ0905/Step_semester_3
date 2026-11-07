package data_structures;

import java.util.HashSet;

public class TransactionChecker {
    public static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] txns1 = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
        String[] txns2 = {"TXN2001", "TXN2002", "TXN2003"};
        System.out.println(hasDuplicate(txns1)); // true[cite: 31]
        System.out.println(hasDuplicate(txns2)); // false[cite: 31]
    }
}