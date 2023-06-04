package in.rakesh;

import in.rakesh.comp.Company1;
import in.rakesh.comp.Company2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootProj03ConfigrationPropertiesAppApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootProj03ConfigrationPropertiesAppApplication.class, args);

		Company1 company1 = context.getBean("comp1",Company1.class);
		System.out.println(company1);

		Company2 company2 = context.getBean("comp2", Company2.class);
		System.out.println(company2);

		((ConfigurableApplicationContext) context).close();
	}

}
