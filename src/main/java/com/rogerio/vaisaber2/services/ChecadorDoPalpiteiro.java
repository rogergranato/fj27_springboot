package com.rogerio.vaisaber2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.rogerio.vaisaber2.models.Palpite;
import com.rogerio.vaisaber2.models.Partida;
import com.rogerio.vaisaber2.repositories.PalpiteiroRepository;
import com.rogerio.vaisaber2.repositories.PartidaRepository;

@Service
public class ChecadorDoPalpiteiro {

	@Autowired
	private PalpiteiroRepository palpRep;
	@Autowired
	private PartidaRepository partRep;
	
	@Scheduled(fixedRate=120000)
	public void checaOsPalpites()
	{
		List<Palpite> vencedores = new ArrayList<>();
		partRep.findByStatus("completed").forEach(partida -> {
			List<Palpite> palpites = palpRep.findByCodigoPartida(partida.getCodigoFifa());
			palpites.forEach(palpite -> {
			   boolean acertou = verificaSeGanhou(partida, palpite);
			   palpite.setAcertou(acertou);
			   if (acertou)
			   {
				   vencedores.add(palpite);
			   }
			   palpite.setVerificado(true);
			});
		});
		
		if (!vencedores.isEmpty())
		{
			palpRep.save(vencedores);
		}
	}
	
	private boolean verificaSeGanhou(Partida partida, Palpite palpite)
	{
		boolean result = partida.getMandante().getGols().equals(palpite.getMandante().getGols()) &&
						 partida.getVisitante().getGols().equals(palpite.getVisitante().getGols()) &&
						 !palpite.isVerificado();
		return result;
	}
}
