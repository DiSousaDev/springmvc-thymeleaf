package br.dev.diego.springmvc.utils;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.dev.diego.springmvc.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Funcionario funcionario = (Funcionario) target;
		
		LocalDate entrada = funcionario.getDataEntrada();
		
		if (funcionario.getDataSaida() != null) {
			if (funcionario.getDataSaida().isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");	
			}
		}	
	}



}
