package com.rogerio.vaisaber2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="palpites")
public class Palpite {

	@Id
	private String id;
	private Selecao mandante;
	private Selecao visitante;
	private Long codigoPartida;
	private String palpiteiro;
	private boolean acertou = false;
	private boolean verificado = false;
	
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
	public Long getCodigoPartida() {
		return codigoPartida;
	}
	public void setCodigoPartida(Long codigoPartida) {
		this.codigoPartida = codigoPartida;
	}
	public String getPalpiteiro() {
		return palpiteiro;
	}
	public void setPalpiteiro(String palpiteiro) {
		this.palpiteiro = palpiteiro;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isAcertou() {
		return acertou;
	}
	public void setAcertou(boolean acertou) {
		this.acertou = acertou;
	}
	public boolean isVerificado() {
		return verificado;
	}
	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}
}
