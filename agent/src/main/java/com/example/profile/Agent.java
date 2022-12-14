package com.example.profile;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class Agent {

  public static void premain(String agentArgs, Instrumentation inst) {
    System.out.println("agentArgs : " + agentArgs);

    new AgentBuilder.Default()
        .with(AgentBuilder.Listener.StreamWriting.toSystemError().withErrorsOnly())
        .type(
            ElementMatchers.named(
                "org.springframework.web.servlet.DispatcherServlet"))
        .transform((builder, type, classLoader, module) -> builder
            .method(ElementMatchers.named("doDispatch"))
            .intercept(MethodDelegation.to(InstrumentInterceptor.class)))
        .installOn(inst);
    new AgentBuilder.Default()
        .type(
            ElementMatchers.named(
                "org.springframework.web.servlet.DispatcherServlet"))
        .transform((builder, type, classLoader, module) -> builder
            .method(ElementMatchers.named("doDispatch"))
            .intercept(MethodDelegation.to(ShowMethodInterceptor.class)))
        .installOn(inst);
  }
}
