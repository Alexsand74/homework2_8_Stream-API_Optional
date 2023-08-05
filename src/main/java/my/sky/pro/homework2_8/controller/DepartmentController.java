package my.sky.pro.homework2_8.controller;

import my.sky.pro.homework2_8.model.Employee;
import my.sky.pro.homework2_8.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMaxSalaryFromDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMinSalaryFromDepartment(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public  List <Employee> findEmployeesFromDepartment(@RequestParam("departmentId") int department){
        return departmentService.findEmployeesFromDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, java.util.List<Employee>> findEmployees() {
        return departmentService.findEmployees();
    }

}
