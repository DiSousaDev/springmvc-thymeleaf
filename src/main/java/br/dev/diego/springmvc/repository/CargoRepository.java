package br.dev.diego.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.diego.springmvc.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}


