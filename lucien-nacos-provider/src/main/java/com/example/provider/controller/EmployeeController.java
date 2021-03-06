package com.example.provider.controller;

import com.example.consumer.feign.model.EmployeeDTO;
import com.example.provider.aop.annotation.OperationLog;
import com.example.provider.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName EmployeeController
 * @User zhang
 * @Description
 * @Author Lucien
 * @Date 2020/8/30 0:10
 * @Version 1.0
 */
@RestController
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @OperationLog(operEvent = "根据员工名字模糊查询员工信息", operType = 1)
    @GetMapping(value = "/emp/queryEmpListByFeignApi/{empName}")
    public List<EmployeeDTO> queryEmpListByFeignApi(@PathVariable("empName") String empName) {
        return employeeService.queryEmpListByFeignApi(empName);
    }
}
