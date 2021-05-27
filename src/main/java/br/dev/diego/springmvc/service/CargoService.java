package br.dev.diego.springmvc.service;

import java.util.List;

import br.dev.diego.springmvc.domain.Cargo;
import br.dev.diego.springmvc.utils.Paginacao;

public interface CargoService {
	
	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();
	
	boolean cargoTemFuncionarios(Long id);
	
	public Paginacao<Cargo> buscaPaginada(int pagina, String direcao);

}
