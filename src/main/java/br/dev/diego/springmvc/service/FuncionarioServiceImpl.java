package br.dev.diego.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.diego.springmvc.domain.Funcionario;
import br.dev.diego.springmvc.repository.FuncionarioRepository;

@Service
@Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	@Transactional(readOnly = false)
	public void salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		funcionarioRepository.deleteById(id);
	}

	@Override
	public Funcionario buscarPorId(Long id) {
		return funcionarioRepository.getOne(id);
	}

	@Override
	public List<Funcionario> buscarTodos() {
		return funcionarioRepository.findAll();
	}

}
