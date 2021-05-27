package br.dev.diego.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.diego.springmvc.domain.Departamento;
import br.dev.diego.springmvc.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	@Transactional(readOnly = false) // False é padrão
	public void salvar(Departamento departamento) {
		departamentoRepository.save(departamento);
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Departamento departamento) {
		departamentoRepository.save(departamento);
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		departamentoRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		return departamentoRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		return departamentoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean departamentoTemCargos(Long id) {
		Departamento dep = departamentoRepository.findById(id).get();
		if (dep.getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

}
