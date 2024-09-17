package co.edu.unbosque.springdemo.model;

import co.edu.unbosque.springdemo.model.entities.Employer;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {
    private int id;
    @NotBlank(message = "Campo Nombre Requerido")
    private String nombre;
    @NotBlank
    @Size(min = 10,max =25)
    private String email;
    private EmployerDTO employer;

    public EmployeeDTO() {}

    public EmployeeDTO(int id, String nombre, String email, EmployerDTO employer) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployerDTO getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerDTO employer) {
        this.employer = employer;
    }
}
