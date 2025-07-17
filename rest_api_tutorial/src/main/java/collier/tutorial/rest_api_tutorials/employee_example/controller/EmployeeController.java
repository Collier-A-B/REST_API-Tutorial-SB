package collier.tutorial.rest_api_tutorials.employee_example.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import collier.tutorial.rest_api_tutorials.employee_example.dao.EmployeeDAO;
import collier.tutorial.rest_api_tutorials.employee_example.model.Employee;
import collier.tutorial.rest_api_tutorials.employee_example.model.Employees;

// REST Controller for managing employees
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    // GET endpoint to fetch all employees
    @GetMapping("/")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }

    // POST endpoint to add a new employee
    @PostMapping("/")
    public ResponseEntity<Object> 
      addEmployee(@RequestBody Employee employee) {
      
        // Generate ID for the new employee
        Integer id = employeeDao.getAllEmployees()
          .getEmployeeList().size() + 1;
        employee.setId(id);

        // Add employee to the list
        employeeDao.addEmployee(employee);

        // Build location URI for the new employee
        URI location = ServletUriComponentsBuilder
          .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
