package in.rakesh;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.rakesh.comp.BillGenerator;

@SpringBootApplication
public class BootProj10DependancyInjectionJavaConfigurationApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication
				.run(BootProj10DependancyInjectionJavaConfigurationApplication.class, args);

		System.out.println("Beans info are :: " + Arrays.toString(context.getBeanDefinitionNames()));
		System.out.println();

		BillGenerator billGenerator = context.getBean(BillGenerator.class);
		System.out.println(billGenerator);

		((ConfigurableApplicationContext) context).close();
	}
}
