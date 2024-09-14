package co.edu.unbosque.programacion2.examen.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.edu.unbosque.programacion2.examen.exceptions.FacturaExisteException;
import co.edu.unbosque.programacion2.examen.exceptions.FacturaNoExisteException;
import co.edu.unbosque.programacion2.examen.model.Factura;
import co.edu.unbosque.programacion2.examen.model.FacturaDTO;
import co.edu.unbosque.programacion2.examen.repository.FacturaRepository;

@Service
public class FacturaService {
	private static Logger LOGGER = LoggerFactory.getLogger(FacturaService.class);
	private final FacturaRepository repository;
	private final ModelMapper mapper;
	
	public FacturaService(FacturaRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public List<FacturaDTO> consultarFacturas(){
		return repository.findAll()
				.stream()
				.map(factura -> mapper.map(factura,FacturaDTO.class))
				.toList();
	}
	
	public FacturaDTO buscarFactura(int identificacion) {
		Optional<Factura> facturaEncontrada = repository.findById(identificacion);
		if(facturaEncontrada.isPresent()) {
			return mapper.map(facturaEncontrada.get(), FacturaDTO.class);
		} else {
			throw new FacturaNoExisteException("Factura no existe.");
		}
	}
	
	public FacturaDTO crearFactura(FacturaDTO dto) throws FacturaExisteException {		
		if(repository.findById(dto.getIdFactura()).isPresent()) {
			throw new FacturaExisteException("Factura ya registrada.");
		} else {
			return mapper.map(repository.save(mapper.map(dto, Factura.class)),FacturaDTO.class);
		}
	}
}
