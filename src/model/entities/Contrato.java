package model.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Contrato {
	private Integer numero;
	private Date data;
	private Double vlrTotal;
	
	List<Prestacao> prestacoes = new ArrayList<>();
	
	public Contrato() {}

	public Contrato(Integer numero, Date data, Double vlrTotal) {
		this.numero = numero;
		this.data = data;
		this.vlrTotal = vlrTotal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(Double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public List<Prestacao> getPrestacoes() {
		return prestacoes;
	}
	
	
}
