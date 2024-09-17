package co.edu.unbosque.springdemo.service;

import co.edu.unbosque.springdemo.exception.EmployeeNotFoundException;
import co.edu.unbosque.springdemo.model.EmployeeDTO;
import co.edu.unbosque.springdemo.model.entities.Employee;
import co.edu.unbosque.springdemo.repository.EmployeeRepository;
import co.edu.unbosque.springdemo.repository.EmployerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmploymentService {
    private final EmployeeRepository employeeRepository;
    private final EmployerRepository employerRepository;

    public EmploymentService(EmployeeRepository employeeRepository,
                             EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Employee entity = employeeRepository.save(modelMapper.map(employeeDTO,Employee.class));
        return modelMapper.map(entity,EmployeeDTO.class);
    }

    public Set<EmployeeDTO> searchEmployees() {
        ModelMapper modelMapper = new ModelMapper();
        return employeeRepository.findAll().stream().map(entity -> modelMapper.map(entity,EmployeeDTO.class)).collect(Collectors.toSet());
    }

    public EmployeeDTO searchById(Integer id){
        ModelMapper modelMapper = new ModelMapper();
        return employeeRepository
                .findById(id)
                .map(entity -> modelMapper.map(entity,EmployeeDTO.class))
                .orElseThrow(() -> new EmployeeNotFoundException("Empleado no existe"));
    }
}
