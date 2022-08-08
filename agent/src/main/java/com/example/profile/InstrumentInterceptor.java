package com.example.profile;

import java.util.concurrent.Callable;
import javax.servlet.http.HttpServletRequest;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

public class InstrumentInterceptor {

  @RuntimeType
  public static Object intercept(
      @Argument(0) HttpServletRequest request,
      @SuperCall Callable<?> callable) {
    System.out.println(request.getMethod());
    try {
      return callable.call();
    } catch (Exception e) {
      System.out.println("Exception :" + e.getMessage());
      return null;
    } finally {
      System.out.println(request.getRequestURI());
    }
  }
}
