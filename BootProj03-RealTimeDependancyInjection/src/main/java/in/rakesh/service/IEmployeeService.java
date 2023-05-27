package in.rakesh.service;

import java.util.List;

import in.rakesh.dto.EmployeeDTO;

public interface IEmployeeService {
	String save(EmployeeDTO vo);

	List<EmployeeDTO> findAllEmployees();

	EmployeeDTO findById(Integer eid);

	String updateById(Integer eid);

	String deleteById(Integer eid);
}
