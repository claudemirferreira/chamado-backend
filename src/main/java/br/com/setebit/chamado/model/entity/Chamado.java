package br.com.setebit.chamado.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CHA_CHAMADO")
public class Chamado implements Serializable {

	private static final long serialVersionUID = -3877556831749615969L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamado_id_seq")
	@SequenceGenerator(name = "chamado_id_seq", sequenceName = "chamado_id_seq", allocationSize = 1)
	@Column(name = "chamado_id")
	private Long id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column()
	private Date dataFechamento;

	public Chamado(Long id, String descricao, Date dataCadastro, Date dataFechamento) {
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.dataFechamento = dataFechamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Chamado() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
