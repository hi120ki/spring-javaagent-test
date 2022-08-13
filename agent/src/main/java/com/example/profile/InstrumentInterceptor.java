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
    System.out.println("[ShowMethod method1] " + request.getMethod());
    try {
      System.out.println("[ShowMethod method1] " + request.getMethod());
      Object ret = callable.call();
      System.out.println("[ShowMethod method1] " + request.getMethod());
      return ret;
    } catch (Exception e) {
      System.out.println("[ShowMethod Exception] " + e.getMessage());
      return null;
    } finally {
      System.out.println("[ShowMethod method1] " + request.getMethod());
    }
  }
}
