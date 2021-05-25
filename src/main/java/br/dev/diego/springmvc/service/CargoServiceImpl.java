package br.dev.diego.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.diego.springmvc.domain.Cargo;
import br.dev.diego.springmvc.repository.CargoRepository;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Override
	public void salvar(Cargo cargo) {
		cargoRepository.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		cargoRepository.save(cargo);
	}

	@Override
	public void excluir(Long id) {
		cargoRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return cargoRepository.getOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return cargoRepository.findAll();
	}

}
