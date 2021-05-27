package br.dev.diego.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.dev.diego.springmvc.domain.Departamento;

@Service
public interface DepartamentoService {
	
	void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();
	
	boolean departamentoTemCargos(Long id);

}
