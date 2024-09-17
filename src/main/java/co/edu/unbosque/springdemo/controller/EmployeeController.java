package co.edu.unbosque.springdemo.controller;

import co.edu.unbosque.springdemo.model.EmployeeDTO;
import co.edu.unbosque.springdemo.service.EmploymentService;
import jakarta.validation.Valid;
import jdk.jfr.Registered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class EmployeeController implements EmploymentAPI {
    private final EmploymentService service;

    public EmployeeController(EmploymentService service){
        this.service = service;
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmployee(Integer id) {
        EmployeeDTO employee = service.searchById(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body(employee);
    }

    @Override
    public ResponseEntity<Set<EmployeeDTO>> getAllEmployees() {
        Set<EmployeeDTO> employees = service.searchEmployees();
        return ResponseEntity.status(HttpStatus.OK.value()).body(employees);
    }

    @Override
    public ResponseEntity<EmployeeDTO> createEmployee(EmployeeDTO employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(employee));
    }
}
