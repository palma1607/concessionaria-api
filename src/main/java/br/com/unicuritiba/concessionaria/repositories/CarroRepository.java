package br.com.unicuritiba.concessionaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.concessionaria.models.Carro;

public interface CarroRepository 
	extends JpaRepository<Carro, Long>{

}
