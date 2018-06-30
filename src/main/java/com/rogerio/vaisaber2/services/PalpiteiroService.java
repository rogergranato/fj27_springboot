package com.rogerio.vaisaber2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.vaisaber2.models.Palpite;
import com.rogerio.vaisaber2.repositories.PalpiteiroRepository;

@Service
public class PalpiteiroService {

	@Autowired
	private PalpiteiroRepository rep;
	@Autowired
	private ChecadorDoPalpiteiro chk;

	public Palpite criaPalpite(Palpite palpite) {
		// TODO Auto-generated method stub
		return rep.insert(palpite);
	}
	
	public void checaPalpites()
	{
		chk.checaOsPalpites();
	}

	public Palpite getPalpitePorId(String id) {
		// TODO Auto-generated method stub
		return rep.findOne(id);
	}
}
