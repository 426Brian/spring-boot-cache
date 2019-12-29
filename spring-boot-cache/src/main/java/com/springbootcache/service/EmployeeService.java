package com.springbootcache.service;

import com.springbootcache.bean.Employee;
import com.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的返回结果缓存
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"} /**, keyGenerator = "keyGenerator_my" */)
    public Employee getEmp(Integer id) {
        return employeeMapper.getEmpById(id);
    }


    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key="#root.args[0]")
            },
            put = {
                    @CachePut(value = "emp", key="#result.id"),
                    @CachePut(value = "emp", key="#result.email")
            }
    )
    public Employee getEmpbyLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }


    @CachePut(cacheNames = {"emp"}, key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("employee ** == "+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(cacheNames = {"emp"}, key = "#root.args[0]")
    public void delete(Integer id) {
         employeeMapper.deleteEmp(id);
    }

    public Employee insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee;
    }
}
