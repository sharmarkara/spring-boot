package in.rakesh;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.rakesh.comp.IEmployeeDAO;
import in.rakesh.dto.Employee;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj06ConfigurationPropertiesAppApplication.class, args);

		IEmployeeDAO dao = context.getBean(IEmployeeDAO.class);
		try {
			List<Employee> employees = dao.findAllEmployees();
			employees.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) context).close();
	}
}
