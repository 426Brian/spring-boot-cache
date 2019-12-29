package com.springbootcache.mapper;

//import com.springbootcache.bean.Employee;
import com.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;


public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Insert("insert into employee(id, last_name, email, gender, d_id)values(#{id}, #{lastName}, #{email}, #{gender}, #{dId})")
    void insertEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteEmp(Integer id);

    @Update("update employee set last_name = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id}")
    void updateEmp(Employee employee);

    @Select("select * from employee where last_name = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
