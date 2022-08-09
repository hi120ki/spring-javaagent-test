package com.example.profile;

import java.util.concurrent.Callable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

public class InstrumentInterceptor {

  @RuntimeType
  public static Object intercept(
      @Argument(0) HttpServletRequest request,
      @Argument(1) HttpServletResponse response,
      @SuperCall Callable<?> callable) {
    System.out.println("[1] request : " + request.getMethod());
    try {
      System.out.println("[2] request : " + request.getMethod());
      Object ret = callable.call();
      System.out.println("[3] request : " + request.getMethod());
      System.out.println("[1] response : " + response.getContentType());
      return ret;
    } catch (Exception e) {
      System.out.println("Exception :" + e.getMessage());
      return null;
    } finally {
      System.out.println("[4] request : " + request.getMethod());
    }
  }
}
