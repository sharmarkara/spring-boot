package in.rakesh.controller;

import in.rakesh.dto.EmployeeDTO;
import in.rakesh.service.IEmployeeService;
import in.rakesh.vo.EmployeeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("empController")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    public List<EmployeeVO> showEmpsByDesgs(String degs[]) throws Exception
    {
        //Use Service
        List<EmployeeDTO> listDTO = service.fetchEmpsByDesgs(degs);

        //Convert ListDTO to ListVO
        ArrayList<EmployeeVO> listVO = new ArrayList<>();
        listDTO.forEach(dto->
        {
            EmployeeVO vo = new EmployeeVO();
            BeanUtils.copyProperties(dto,vo);
            vo.setSrNo(String.valueOf(dto.getSrNo()));
            vo.setEmpName(String.valueOf(dto.getEmpName()));
            vo.setEmpNo(String.valueOf(dto.getEmpNo()));
            vo.setSal(String.valueOf(dto.getSal()));
            vo.setDeptNo(String.valueOf(dto.getDeptNo()));
            vo.setMgrNo(String.valueOf(dto.getMgrNo()));
            listVO.add(vo);
        });
        return listVO;
    }
}
