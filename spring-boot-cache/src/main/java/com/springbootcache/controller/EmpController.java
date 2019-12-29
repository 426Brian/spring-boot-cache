package com.springbootcache.controller;

import com.springbootcache.bean.Employee;
import com.springbootcache.mapper.EmployeeMapper;
import com.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/get/{id}")
    public Employee get(@PathVariable("id") Integer id) {

        return employeeService.getEmp(id);
    }

    @RequestMapping("/get/lastName/{lastName}")
    public Employee get(@PathVariable("lastName") String lastName) {

        return employeeService.getEmpbyLastName(lastName);
    }

    @RequestMapping("/post/emp")
    public Employee update() {
        Employee employee = new Employee(1, "John", "rtjrt@ga.com", 1, 2);

        return employeeService.updateEmp(employee);
    }

    @RequestMapping("/put/emp/{id}")
    public Employee insert(@PathVariable("id") Integer id) {
        Employee employee = new Employee(id + 1, "Jobs", "jawet@.com", 1, 2);
        return employeeService.insertEmp(employee);
    }


    @RequestMapping("/delete/emp/{id}")
    public String delete(@PathVariable("id") Integer id) {
         employeeService.delete(id);
         return "success";
    }

    @RequestMapping("/demo")
    public String demo() {
        return "hello demo";
    }
}
