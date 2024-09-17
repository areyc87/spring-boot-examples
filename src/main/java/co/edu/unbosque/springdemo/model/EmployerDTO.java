package co.edu.unbosque.springdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class EmployerDTO {
    private int id;
    private String nombre;
    @JsonIgnore
    private Set<EmployeeDTO> employees;

    public EmployerDTO() {}

    public EmployerDTO(int id, String nombre, Set<EmployeeDTO> employees) {
        this.id = id;
        this.nombre = nombre;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
