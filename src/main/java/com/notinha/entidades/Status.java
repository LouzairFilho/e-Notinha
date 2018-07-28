package com.notinha.entidades;

public enum Status {
	ABERTA("Física"), PAGA("Jurídica");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
