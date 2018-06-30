package com.rogerio.vaisaber2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.rogerio.vaisaber2.models.Partida;
import com.rogerio.vaisaber2.repositories.PartidaRepository;
import com.rogerio.vaisaber2.worldcupapi.WorldCupApiClient;
import com.rogerio.vaisaber2.worldcupapi.models.Match;

@SpringBootApplication
@EnableFeignClients
public class Vaisaber2Application {

	@Autowired
	private WorldCupApiClient client;
	@Autowired
	private PartidaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Vaisaber2Application.class, args);
	}
	
	@PostConstruct
	public void populateDatabase()
	{
		if (repository.count() <= 0)
		{
	    	List<Partida> partidas = client.buscaPartidasNaApi()
				                       .stream()
				                       .map(Match::toDomain).
				                       collect(Collectors.toList()); 
		    repository.save(partidas);
		}
	}
}
