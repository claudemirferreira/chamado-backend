package br.com.setebit.chamado.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Status implements Serializable {

	private static final long serialVersionUID = -3877556831749615969L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_id_seq")
	@SequenceGenerator(name = "status_id_seq", sequenceName = "status_id_seq", allocationSize = 1)
	@Column(name = "status_id")
	@Getter
	@Setter
	private Long id;

	@Column(name = "nome", nullable = false, length = 30)
	@Getter
	@Setter
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Status() {
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
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
