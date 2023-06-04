package in.rakesh.dao;

import in.rakesh.bo.EmployeeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAOImpl implements IEmployeeDao{

    private static final String GET_EMPS_BY_DEGS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP  WHERE JOB IN";

    @Autowired
    private DataSource dataSource;
    @Override
    public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception {

        List<EmployeeBO> listBO=null;
        System.out.println("DataSource obj class name is ::"+dataSource.getClass());
        try(Connection con=dataSource.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(GET_EMPS_BY_DEGS+cond +"ORDER BY JOB");)
        {
            //Convert RS object records to  list of BO class object
            listBO = new ArrayList<>();
            EmployeeBO bo=null;
            while (rs.next())
            {
                //Copy each record of RS to a object of EmployeeBo class
                bo=new EmployeeBO();
                bo.setEmpNo(rs.getInt(1));
                bo.setEmpName(rs.getString(2));
                bo.setJob(rs.getString(3));
                bo.setSal(rs.getDouble(4));
                bo.setDeptNo(rs.getInt(5));
                bo.setMgrNo(rs.getInt(6));

                //add each object of EmployeeBO to List Collection
                listBO.add(bo);
            }
        }catch (SQLException se)
        {
            se.printStackTrace();
            throw se; //for exception propagation
        }catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        return listBO;
    }
}
