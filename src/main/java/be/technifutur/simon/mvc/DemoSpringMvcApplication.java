package be.technifutur.simon.mvc;

import be.technifutur.simon.mvc.utils.EMFSharer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringMvcApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoSpringMvcApplication.class, args);

		ApplicationContext ctxt = SpringApplication.run(DemoSpringMvcApplication.class, args);

		ctxt.getBean(EMFSharer.class).close();
	}

}
