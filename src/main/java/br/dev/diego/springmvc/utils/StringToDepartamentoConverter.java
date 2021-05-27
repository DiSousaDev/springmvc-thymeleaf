package br.dev.diego.springmvc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.dev.diego.springmvc.domain.Departamento;
import br.dev.diego.springmvc.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento>{

	@Autowired
	private DepartamentoService departamentoService;
	
	@Override
	public Departamento convert(String value) {
		if (value.isEmpty()) {
			return null;
		}
		Long id = Long.parseLong(value);
		return departamentoService.buscarPorId(id);
	}

}
