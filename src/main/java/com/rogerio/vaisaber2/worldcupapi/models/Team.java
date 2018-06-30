package com.rogerio.vaisaber2.worldcupapi.models;

import com.rogerio.vaisaber2.models.Selecao;

public class Team {

	private String country;
	private String code;
	private Integer goals;
	private Integer penalties;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getGoals() {
		return goals;
	}
	public void setGoals(Integer goals) {
		this.goals = goals;
	}
	public Integer getPenalties() {
		return penalties;
	}
	public void setPenalties(Integer penalties) {
		this.penalties = penalties;
	}
	public Selecao toDomain()
	{
		Selecao sel = new Selecao();
		sel.setGols(goals);
		sel.setNome(country);
		sel.setSigla(code);
		
		return sel;
	}
}
