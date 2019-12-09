package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping(value = "/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping(value = "/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", employee);
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /*@PutMapping(value = "/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }*/

    //员工删除
    @PostMapping(value = "/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
