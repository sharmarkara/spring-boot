package in.rakesh;

import in.rakesh.comp.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootProj03ConfigrationPropertiesAppApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootProj03ConfigrationPropertiesAppApplication.class, args);

		Employee employee=context.getBean(Employee.class);
		System.out.println(employee);

		((ConfigurableApplicationContext) context).close();
	}

}
