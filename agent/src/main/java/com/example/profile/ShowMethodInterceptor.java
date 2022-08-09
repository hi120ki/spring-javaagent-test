package com.example.profile;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

public class ShowMethodInterceptor {

  @RuntimeType
  public static Object intercept(
      @Origin Method method,
      @SuperCall Callable<?> callable) {
    System.out.println("[1] " + method.getName());
    try {
      System.out.println("[2] " + method.getName());
      return callable.call();
    } catch (Exception e) {
      System.out.println("Exception :" + e.getMessage());
      return null;
    } finally {
      System.out.println("[3] " + method.getName());
    }
  }
}
