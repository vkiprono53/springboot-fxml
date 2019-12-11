package com.kip.employee.controllers;

import com.kip.employee.models.Employee;
import com.kip.employee.services.EmployeeService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @FXML
    private TableView<Employee> tableView;

    @FXML
    TextField firstname;
    @FXML
    TextField lastname;
    @FXML
    TextField username;
    @FXML
    PasswordField password;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Iterable<Employee> findAllEmployees() {
        System.out.println("Fetching data from db****");
        return employeeService.findAll();
    }

    @PostMapping("/addEmployee")
    public Employee save(Employee employee) {
        System.out.println("Inside add employee");
        return employeeService.save(employee);
    }

    public void save(ActionEvent actionEvent) {
        System.out.println("******Beginning Save******");
        Employee employee = new Employee();
        employee.setFirst_name(firstname.getText());
        employee.setLast_name(lastname.getText());
        employee.setUsername(username.getText());
        employee.setPass(password.getText());
        System.out.println("Data received:" + firstname.getText() + " " + lastname.getText() + " " + username.getText() + " " + password.getText() + " " + username.getText());
        employeeService.save(employee);
        System.out.println("After save=====Reset fields=====");
        firstname.setText("");
        lastname.setText("");
        password.setText("");
        username.setText("");
    }

    public void getEmployees(ActionEvent actionEvent){
        System.out.println("*****Inside Void fetching data****");
    Iterable<Employee> employee =    employeeService.findAll();
        ObservableList<Employee> employees = tableView.getItems();
        employees.clear();
        employee.forEach(employee1 -> employees.add(employee1));
    }
}
