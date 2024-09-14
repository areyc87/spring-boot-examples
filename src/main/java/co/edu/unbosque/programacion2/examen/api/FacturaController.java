package co.edu.unbosque.programacion2.examen.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.programacion2.examen.model.FacturaDTO;
import co.edu.unbosque.programacion2.examen.service.FacturaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController("/facturas")
public class FacturaController {
	private static Logger LOGGER = LoggerFactory.getLogger(FacturaController.class);
	@Autowired
	private FacturaService service;

	@Operation(
            summary = "Consultar Facturas",
            description = "Retorna la lista de todas las facturas registradas.")
	@GetMapping("/")
	public List<FacturaDTO> listarFacturas(){
		return service.consultarFacturas();
	}
	
	@Operation(
            summary = "Consultar Factura",
            description = "Busca una factura en el sistema con el ID dado.")
	@GetMapping("/{facturaId}")
	public FacturaDTO consultarFactura(@PathVariable Integer facturaId) {
		return service.buscarFactura(facturaId);
	}
	
	@Operation(
            summary = "Registrar Factura",
            description = "Crea una factura en el sistema",
            responses = {
            		@ApiResponse(
            				responseCode = "201",
            				description = "Factura Creada.",
            				content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = FacturaDTO.class))
                            )
                    }),
            		@ApiResponse(
                            responseCode = "208",
                            description = "Factura ya fue procesada.",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = FacturaDTO.class))
                                    )
                    }),
            		@ApiResponse(
                            responseCode = "400",
                            description = "Datos o request invalido.",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = FacturaDTO.class))
                                    )
                    }),
            }
    )	
	@PostMapping("/")
	public ResponseEntity<FacturaDTO> registrarFactura(@RequestBody FacturaDTO estudiante) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body((service.crearFactura(estudiante)));
	}
	
}
