package br.dev.diego.springmvc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.dev.diego.springmvc.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Query("select f from Funcionario f where f.nome like concat('%',?1,'%')")
	List<Funcionario> findByNome(String nome);

	@Query("select f from Funcionario f where f.cargo.id = ?1")
	List<Funcionario> findByCargo(Long id);

	@Query("select f from Funcionario f "
			+ "where f.dataEntrada >= ?1 and f.dataSaida <= ?2 "
			+ "order by f.dataEntrada asc")
	List<Funcionario> findByDataEntradaAndDataSaida(LocalDate dataEntrada, LocalDate dataSaida);

	@Query("select f from Funcionario f where f.dataEntrada = ?1 order by f.dataEntrada asc")
	List<Funcionario> findByDataEntrada(LocalDate dataEntrada);

	@Query("select f from Funcionario f where f.dataSaida = ?1 order by f.dataEntrada asc")
	List<Funcionario> findByDataSaida(LocalDate dataSaida);

}