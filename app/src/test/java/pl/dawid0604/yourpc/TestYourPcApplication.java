/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc;

import org.springframework.boot.SpringApplication;

class TestYourPcApplication {

  public static void main(final String[] args) {
    SpringApplication.from(YourPcApplication::main)
        .with(TestcontainersConfiguration.class)
        .run(args);
  }
}
