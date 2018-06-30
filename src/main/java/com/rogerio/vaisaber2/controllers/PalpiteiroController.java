package com.rogerio.vaisaber2.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogerio.vaisaber2.models.Palpite;
import com.rogerio.vaisaber2.services.PalpiteiroService;

@RestController
@RequestMapping("/palpites")
public class PalpiteiroController {
	
	@Autowired
	private PalpiteiroService serv;

	@PostMapping
	public ResponseEntity<Palpite> criaPalpite(@RequestBody Palpite palpite) throws URISyntaxException{
		Palpite palpiteCriado = serv.criaPalpite(palpite);
		return ResponseEntity.created(new URI("/palpites/" + palpite.getId())).body(palpiteCriado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscaPalpitePeloId(@PathVariable String  id)
	{
		Palpite palp = serv.getPalpitePorId(id);
		if (Objects.isNull(palp))
	    {
			return ResponseEntity.notFound().build();
	    }
		
		return ResponseEntity.ok(palp);
	}
	
	
	@PostMapping("/checapalpites")
	public ResponseEntity checaPalpites()
	{
		serv.checaPalpites();
		return ResponseEntity.accepted().build();
	}
}
