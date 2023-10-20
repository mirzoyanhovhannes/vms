package org.vms.transaction;

import org.vms.offer.Offer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionCatalog {
    private final List<Transaction> transactions;

    public TransactionCatalog() {
        this.transactions = new ArrayList<>();
    }

    public void makeTransaction(LocalDateTime time, Offer offer){
        this.transactions.add(new Transaction(time, offer));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
