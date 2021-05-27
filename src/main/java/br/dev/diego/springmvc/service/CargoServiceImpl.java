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
		return cargoRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return cargoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean cargoTemFuncionarios(Long id) {
		Cargo cargo = cargoRepository.findById(id).get();
		if (cargo.getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}

}
