package com.rogerio.vaisaber2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.vaisaber2.models.Partida;
import com.rogerio.vaisaber2.repositories.PartidaRepository;

@Service //equivalente ao @Component
public class PartidasService {

	@Autowired
	private PartidaRepository rep;
	
	public List<Partida> listaPartidas()
	{
		return rep.findAll();
	}
}
