package in.rakesh.controller;

import java.util.List;

import in.rakesh.dto.EmployeeDTO;
import in.rakesh.vo.EmployeeVO;

public interface IEmployeeController {

	String save(EmployeeVO vo);

	List<EmployeeVO> findAllEmployees();

	EmployeeDTO findById(Integer eid);

	String updateById(Integer eid);

	String deleteById(Integer eid);

}
