package com.luanmxz.application.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.luanmxz.domain.model.Transaction;

public class TransactionService {

  private List<Transaction> transactions = new CopyOnWriteArrayList<>();

  public Transaction create(Integer amount, String reference) {
    Transaction transaction = new Transaction(amount, reference);

    transactions.add(transaction);

    return transaction;
  }

  public List<Transaction> findAll() {
    return transactions;
  }
}
