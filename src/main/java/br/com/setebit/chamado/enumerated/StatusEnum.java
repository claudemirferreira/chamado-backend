package br.com.setebit.chamado.enumerated;

public enum StatusEnum {

	APROVADO(1, "APROVADO"), REPROVADO(2, "REPROVADO"), PENDENTE(3, "PENDENTE"), CANCELADO(4, "CANCELADO");

	private Integer id;

	private String descricao;

	private StatusEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}