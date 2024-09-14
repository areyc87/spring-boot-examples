package co.edu.unbosque.programacion2.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.programacion2.examen.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer>{

}
