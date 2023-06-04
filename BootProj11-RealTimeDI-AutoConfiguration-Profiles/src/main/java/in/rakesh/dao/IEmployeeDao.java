package in.rakesh.dao;

import in.rakesh.bo.EmployeeBO;

import java.util.List;

public interface IEmployeeDao {

    public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception;
}
