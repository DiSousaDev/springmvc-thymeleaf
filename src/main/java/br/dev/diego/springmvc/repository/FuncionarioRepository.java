package br.dev.diego.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.diego.springmvc.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}


