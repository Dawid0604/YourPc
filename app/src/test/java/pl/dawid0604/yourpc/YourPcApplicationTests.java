/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class YourPcApplicationTests {

  @Test
  void contextLoads() {}
}
