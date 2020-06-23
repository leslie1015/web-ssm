package com.leslie.silk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

  private  Logger log = LoggerFactory.getLogger(getClass());


  public static void main(String[] args) {
    LogTest l = new LogTest();

    l.a();

  }

  public void a() {
//    log.info("平台传macid：" + data.getMesData().getDeviceMacId();
    log.trace("trace");
    log.debug("debug");
    log.warn("warn");
    log.info("info");
    log.error("error");
    System.out.println("aaaaaaaaaaaaaaaaabbbbbbbbbbbbbb");
  }
}
