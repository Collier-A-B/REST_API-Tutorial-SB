package collier.tutorial.rest_api_tutorials.employee_example.model;

import java.util.ArrayList;
import java.util.List;

// Storage class for employees
public class Employees {

    private List<Employee> employeeList;

    // Get the employee list (initialize if null)
    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
