package test.kneteng.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("test.kneteng.testapp") // Required to indicate Spring where to look for beans
public class TestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestappApplication.class, args);
	}

}
