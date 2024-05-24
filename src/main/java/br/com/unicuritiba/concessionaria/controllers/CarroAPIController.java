package br.com.unicuritiba.concessionaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.concessionaria.models.Carro;
import br.com.unicuritiba.concessionaria.repositories.CarroRepository;

@RestController
public class CarroAPIController {

	@Autowired
	private CarroRepository repositorio;
	
	@GetMapping("/carros")
	public ResponseEntity<List<Carro>> getCarros() {
		List<Carro> carros = repositorio.findAll();
		return ResponseEntity.ok(carros);
	}
	
	
	@PostMapping("/carros")
	public ResponseEntity<Carro> salvarCarros(
			@RequestBody Carro carro){
		Carro carroSalvo = repositorio.save(carro);
		return new ResponseEntity<Carro>(
				carroSalvo,
				HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/carros/{id}")
	public ResponseEntity<Void> removerCarro(
			@PathVariable("id") long id){
		repositorio.deleteById(id);
		return new ResponseEntity<>(
				HttpStatus.OK
				);
	}
	
	@PutMapping("/carros/{id}")
	public ResponseEntity<Carro> atualizarCarro(
			@PathVariable("id") long id,
			@RequestBody Carro carro){
		carro.setId(id);
		repositorio.save(carro);
		return new ResponseEntity<Carro>(
				carro,
				HttpStatus.OK
				);
	}
	
}
