package in.rakesh;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.rakesh.comp.IEmployeeDAO;
import in.rakesh.dto.Employee;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
public class BootProj09ConfigurationPropertiesAppApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj09ConfigurationPropertiesAppApplication.class, args);

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

