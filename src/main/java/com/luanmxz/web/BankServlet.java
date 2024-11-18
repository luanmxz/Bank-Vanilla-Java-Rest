package com.luanmxz.web;

import java.io.IOException;
import java.util.List;

import com.luanmxz.application.ApplicationContext;
import com.luanmxz.domain.model.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BankServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getRequestURI().equalsIgnoreCase("/transaction")) {
      Integer amount = Integer.parseInt(req.getParameter("amount"));
      String reference = req.getParameter("reference");

      Transaction transaction = ApplicationContext.transactionService.create(amount, reference);

      resp.setContentType("application/json; charset=UTF-8");
      resp.getWriter().print(ApplicationContext.objMapper.writeValueAsString(transaction));
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    if (req.getRequestURI().equalsIgnoreCase("/transaction")) {

      List<Transaction> transactions = ApplicationContext.transactionService.findAll();

      resp.setContentType("application/json; charset=UTF-8");
      resp.getWriter().print(ApplicationContext.objMapper.writeValueAsString(transactions));
    }
  }
}
