package pl.dawid0604.yourpc;

import org.springframework.boot.SpringApplication;

public class TestYourPcApplication {

	public static void main(String[] args) {
		SpringApplication.from(YourPcApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
