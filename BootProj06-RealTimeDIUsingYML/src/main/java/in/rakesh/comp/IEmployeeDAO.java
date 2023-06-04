package in.rakesh.comp;

import java.util.List;

import in.rakesh.dto.Employee;

public interface IEmployeeDAO {
	public List<Employee> findAllEmployees() throws Exception;
}
