package br.dev.diego.springmvc.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer>{

	@Override
	public Integer convert(String value) {
		
		value.trim();
		
		if (value.matches("[0-9]+")) {
			return Integer.parseInt(value);
		}
		return null;
	}

}
