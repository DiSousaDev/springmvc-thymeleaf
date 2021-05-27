package br.dev.diego.springmvc.utils;

import java.util.List;

public class Paginacao<T> {
	
	private int tamanho;
	private int pagina;
	private Long totalDePaginas;
	private String direcao;
	private List<T> registros;
	
	public Paginacao(int tamanho, int pagina, Long totalDePaginas, String direcao, List<T> registros) {
		super();
		this.tamanho = tamanho;
		this.pagina = pagina;
		this.totalDePaginas = totalDePaginas;
		this.direcao = direcao;
		this.registros = registros;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getPagina() {
		return pagina;
	}

	public Long getTotalDePaginas() {
		return totalDePaginas;
	}

	public List<T> getRegistros() {
		return registros;
	}
	
	public String getDirecao() {
		return direcao;
	}
	
}
