package com.example.profile;

import javax.servlet.http.HttpServletRequest;
import static net.bytebuddy.asm.Advice.OnMethodEnter;
import static net.bytebuddy.asm.Advice.Origin;
import net.bytebuddy.implementation.bind.annotation.Argument;

public class AdviceInterceptor {
  @OnMethodEnter
  static void enter(
      @Origin String method,
      @Argument(0) HttpServletRequest request) {
    System.out.println("[Advice method] " + method);
    System.out.println("[Advice request] " + request.getMethod());
  }
}
