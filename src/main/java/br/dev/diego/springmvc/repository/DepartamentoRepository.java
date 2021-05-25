package br.dev.diego.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.diego.springmvc.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}


