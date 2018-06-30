package com.rogerio.vaisaber2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="partidas") // equivalente ao Entity do Hibernate, mas estamos usando mongo
public class Partida {

	@Id
	private String id;
	private String estadio;
	private String codigoVencedor;
	private Long codigoFifa;
	private Selecao mandante;
	private Selecao visitante;
	
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getCodigoVencedor() {
		return codigoVencedor;
	}
	public void setCodigoVencedor(String codigoVencedor) {
		this.codigoVencedor = codigoVencedor;
	}
	public Long getCodigoFifa() {
		return codigoFifa;
	}
	public void setCodigoFifa(Long codigoFifa) {
		this.codigoFifa = codigoFifa;
	}
	public Selecao getMandante() {
		return mandante;
	}
	public void setMandante(Selecao mandante) {
		this.mandante = mandante;
	}
	public Selecao getVisitante() {
		return visitante;
	}
	public void setVisitante(Selecao visitante) {
		this.visitante = visitante;
	}
}
