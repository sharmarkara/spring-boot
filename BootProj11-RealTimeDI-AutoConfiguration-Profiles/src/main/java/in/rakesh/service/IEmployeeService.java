package in.rakesh.service;

import in.rakesh.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    public List<EmployeeDTO> fetchEmpsByDesgs(String desgs[]) throws  Exception;
}
