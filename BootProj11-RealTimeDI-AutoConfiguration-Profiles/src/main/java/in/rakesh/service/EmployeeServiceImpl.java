package in.rakesh.service;

import in.rakesh.bo.EmployeeBO;
import in.rakesh.dao.IEmployeeDao;
import in.rakesh.dto.EmployeeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("empService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao dao;

    @Override
    public List<EmployeeDTO> fetchEmpsByDesgs(String[] desgs) throws Exception {

        StringBuffer buffer = new StringBuffer(" (");

        for (int i = 0; i < desgs.length; ++i) {
            if (i == desgs.length - 1) //for the last element of the array
                buffer.append("'" + desgs[i] + "')");
            else
                buffer.append("'" + desgs[i] + "',");// for other than last element

        }
        //convert StringBuffer/StringBuilder object into String
        String cond = buffer.toString();

        //Use DAO
        List<EmployeeBO> listBO = dao.getEmpsByDesg(cond);

        // Convert ListBO to ListDTO
        List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();

        listBO.forEach(bo -> {
            EmployeeDTO dto = new EmployeeDTO();

            //Copy each Bo class object to each DTO class object
            BeanUtils.copyProperties(bo, dto); //property names and type must match in both java beans
            dto.setSrNo(listDTO.size() + 1);

            //add each object of DTO class to ListDTO
            listDTO.add(dto);

        });


        return listDTO;
    }
}
