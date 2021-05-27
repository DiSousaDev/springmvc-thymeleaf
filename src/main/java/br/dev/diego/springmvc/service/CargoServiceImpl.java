package br.dev.diego.springmvc.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.diego.springmvc.domain.Cargo;
import br.dev.diego.springmvc.repository.CargoRepository;
import br.dev.diego.springmvc.utils.Paginacao;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	private EntityManager entityManager;
	
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
	
	@Override
	public Paginacao<Cargo> buscaPaginada(int pagina, String direcao) {
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho; // 0 * 5=0 1*5=5 2*5=10
		List<Cargo> cargos = entityManager.createQuery("select c from Cargo c order by c.nome " + direcao, Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		Long totalRegistros = count();
		Long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
		
		return new Paginacao<>(tamanho, pagina, totalDePaginas, direcao, cargos);
	}
	
	public Long count() {
		return entityManager.createQuery("select count(*) from Cargo", Long.class).getSingleResult();
	}

}
