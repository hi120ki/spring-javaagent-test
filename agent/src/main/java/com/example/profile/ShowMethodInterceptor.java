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
    System.out.println("[ShowMethod method1] " + method);
    try {
      System.out.println("[ShowMethod method2] " + method);
      return callable.call();
    } catch (Exception e) {
      System.out.println("[ShowMethod Exception] " + e.getMessage());
      return null;
    } finally {
      System.out.println("[ShowMethod method3] " + method);
    }
  }
}
