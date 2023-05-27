package in.rakesh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakesh.bo.EmployeeBO;
import in.rakesh.dao.IEmployeeDao;
import in.rakesh.dto.EmployeeDTO;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {
	
	static {
		System.out.println("EmployeeServiceImpl.class file is loading...");
	}
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl object is instantiated:: Zero param constructor");
	}

	@Autowired
	private IEmployeeDao dao;

	@Override
	public String save(EmployeeDTO dto) {

		EmployeeBO bo = new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setEage(dto.getEage());
		bo.setEaddress(dto.getEaddress());

		return dao.save(bo);
	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		List<EmployeeBO> employeesBO = dao.findAllEmployees();
		List<EmployeeDTO> employeeDTO = new ArrayList<EmployeeDTO>();
		for (EmployeeBO bo : employeesBO) {

			EmployeeDTO dto = new EmployeeDTO();
			dto.setEid(bo.getEid());
			dto.setEname(bo.getEname());
			dto.setEage(bo.getEage());
			dto.setEaddress(bo.getEaddress());

			employeeDTO.add(dto);
		}
		return employeeDTO;
	}

	@Override
	public EmployeeDTO findById(Integer eid) {
		EmployeeBO employee = dao.findById(eid);
		EmployeeDTO employeeDto = new EmployeeDTO();
		employeeDto.setEid(employee.getEid());
		employeeDto.setEname(employee.getEname());
		employeeDto.setEage(employee.getEage());
		employeeDto.setEaddress(employee.getEaddress());		
		return employeeDto;
	}

	@Override
	public String updateById(Integer eid) {
		return "";
	}

	@Override
	public String deleteById(Integer eid) {
		// TODO Auto-generated method stub
		return dao.deleteById(eid);
	}

	@Override
	public String toString() {
		return "EmployeeServiceImpl [dao=" + dao + "]";
	}

}
