package com.metatech.JavaCat;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Testslf4j {
  private static final Logger logger = LoggerFactory.getLogger(Testslf4j.class);

  static {
    try {
      LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
      loggerContext.reset();

      JoranConfigurator configurator = new JoranConfigurator();
      configurator.setContext(loggerContext);

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
      LocalDate today = LocalDate.now();

      System.setProperty("date", today.format(formatter));
      configurator.doConfigure("./logback.xml");

      logger.info("Hello, World from born!");
    } catch ( JoranException e) {
      // Logger.info(e.toString());
      logger.error("Failed to load logback.xml file", e);
    }
  }

  public static Logger getLogger(Class<?> clazz){
    return LoggerFactory.getLogger(clazz);
  }
}
