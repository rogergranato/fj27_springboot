package com.rogerio.vaisaber2.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rogerio.vaisaber2.models.Partida;

// eh o DAO
public interface PartidaRepository extends MongoRepository<Partida, String>{

	List<Partida> findByStatus(String status);
	Partida findByCodigoFifa(Long codigoFifa);
}
