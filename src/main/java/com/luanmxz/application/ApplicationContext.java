package com.luanmxz.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.luanmxz.application.services.TransactionService;

public class ApplicationContext {

  public static final TransactionService transactionService = new TransactionService();
  public static final ObjectMapper objMapper = new ObjectMapper().registerModule(new JSR310Module())
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

}
