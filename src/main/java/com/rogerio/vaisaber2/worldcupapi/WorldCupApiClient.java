package com.rogerio.vaisaber2.worldcupapi;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.rogerio.vaisaber2.worldcupapi.models.Match;


@FeignClient(name="world-cup", url="${worldcup.api}")
public interface WorldCupApiClient {
	
	@GetMapping(value="/matches") // == @RequestMapping
	public List<Match> buscaPartidasNaApi();
}
