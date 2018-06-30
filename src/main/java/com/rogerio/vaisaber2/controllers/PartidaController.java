package com.rogerio.vaisaber2.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogerio.vaisaber2.models.Partida;
import com.rogerio.vaisaber2.services.PartidasService;
import com.rogerio.vaisaber2.worldcupapi.WorldCupApiClient;
import com.rogerio.vaisaber2.worldcupapi.models.Match;

@RestController
@RequestMapping("partidas")
public class PartidaController {

	//private WorldCupApiClient client;
	private PartidasService serv;
	//public PartidaController(WorldCupApiClient client) {
	public PartidaController(PartidasService serv) {
		this.serv = serv;
	}
	
//  para pegar direto
//  @GetMapping
//	// funcionaria tb
//	// public List<Match> buscaPartidas(){
//    public ResponseEntity<List<Match>> buscaPartidas(){
//		return ResponseEntity.ok().body(client.buscaPartidasNaApi());
//	}

    @GetMapping
	// funcionaria tb
	// public List<Match> buscaPartidas(){
    //public ResponseEntity<List<Match>> buscaPartidas(){
    public ResponseEntity<List<Partida>> buscaPartidas(){
		//return ResponseEntity.ok().body(client.buscaPartidasNaApi());
    	return ResponseEntity.ok().body(serv.listaPartidas());
	}
	
}
