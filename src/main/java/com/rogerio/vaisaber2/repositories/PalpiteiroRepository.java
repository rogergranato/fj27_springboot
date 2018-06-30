package com.rogerio.vaisaber2.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rogerio.vaisaber2.models.Palpite;

@Repository
public interface PalpiteiroRepository extends MongoRepository<Palpite, String>{

	List<Palpite> findByCodigoPartida(Long codigoPartida);
}
