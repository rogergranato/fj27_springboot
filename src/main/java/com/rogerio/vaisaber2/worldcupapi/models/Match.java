package com.rogerio.vaisaber2.worldcupapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rogerio.vaisaber2.models.Partida;

public class Match {

	// casa com o nome da api (Jackson parseia)
	private String location;
	
	//nao casa com o nome da api
	@JsonProperty(value="fifa_id")
	private Long fifaId;
	
	private String winner;
	@JsonProperty(value="winner_code")
	private String winnerCode;
	@JsonProperty(value="home_team")
	private Team homeTeam;
	@JsonProperty(value="away_team")
	private Team awayTeam;
	private String status;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getFifaId() {
		return fifaId;
	}
	public void setFifaId(Long fifaId) {
		this.fifaId = fifaId;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getWinnerCode() {
		return winnerCode;
	}
	public void setWinnerCode(String winnerCode) {
		this.winnerCode = winnerCode;
	}
	public Team getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public Team getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return location + " - " + winner + " - " + homeTeam.getCountry() + " - " + awayTeam.getCountry();
	}
	
	public Partida toDomain()
	{
		Partida partida = new Partida();
		partida.setCodigoFifa(fifaId);
		partida.setEstadio(location);
		partida.setMandante(homeTeam.toDomain());
		partida.setVisitante(awayTeam.toDomain());
		partida.setStatus(status);
		return partida;

	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
