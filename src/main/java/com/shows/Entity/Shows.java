package com.shows.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "shows")

public class Shows {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O nome do artista deve ser preenchido")
	private String artistaNome;
	
	@NotNull(message = "O tempo do show deve ser informado")
	private String tempoShow;
	
	@NotNull(message = "O valor do ingresso deve ser informado")
	private double valorIng;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtistaNome() {
		return artistaNome;
	}

	public void setArtistaNome(String artistaNome) {
		this.artistaNome = artistaNome;
	}

	public String getTempoShow() {
		return tempoShow;
	}

	public void setTempoShow(String tempoShow) {
		this.tempoShow = tempoShow;
	}

	public double getValorIng() {
		return valorIng;
	}

	public void setValorIng(double valorIng) {
		this.valorIng = valorIng;
	}
	
	
	

	

}
