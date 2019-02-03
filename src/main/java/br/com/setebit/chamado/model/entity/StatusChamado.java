package br.com.setebit.chamado.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.setebit.chamado.enumerated.StatusEnum;

@Entity
@Table(name = "CHA_STATUS_CHAMADO")
public class StatusChamado implements Serializable {

	private static final long serialVersionUID = -3877556831749615969L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stat_cham_id_seq")
	@SequenceGenerator(name = "stat_cham_id_seq", sequenceName = "stat_cham_id_seq", allocationSize = 1)
	@Column(name = "stat_cham_id")
	private Long id;

	@Column(nullable = false)
	private Date inicio;

	@Column()
	private Date fim;

	@Column(name = "observacao")
	private String observacao;

	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;

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
		StatusChamado other = (StatusChamado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}