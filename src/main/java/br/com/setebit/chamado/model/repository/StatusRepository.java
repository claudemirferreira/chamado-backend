package br.com.setebit.chamado.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.setebit.chamado.model.entity.Status;


@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
