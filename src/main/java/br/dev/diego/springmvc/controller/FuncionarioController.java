package br.dev.diego.springmvc.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.dev.diego.springmvc.domain.Cargo;
import br.dev.diego.springmvc.domain.Funcionario;
import br.dev.diego.springmvc.enums.UF;
import br.dev.diego.springmvc.service.CargoService;
import br.dev.diego.springmvc.service.FuncionarioService;
import br.dev.diego.springmvc.utils.FuncionarioValidator;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "funcionario/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/nome")
	public String buscarPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
		return "funcionario/lista";
	}

	@GetMapping("/buscar/cargo")
	public String buscarPorCargo(@RequestParam(name = "id", required = false) Long id, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/data")
	public String buscarPorDatas(@RequestParam(name = "dataEntrada", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEntrada,
								@RequestParam(name = "dataSaida", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataSaida,	
								ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorDatas(dataEntrada, dataSaida));
		return "funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "funcionario/cadastro";
		}
		
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionário incluido com sucesso!");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "funcionario/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "funcionario/cadastro";
		}
		
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionário alterado com sucesso!");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		funcionarioService.excluir(id);
		attr.addFlashAttribute("success", "Funcionário removido com sucesso!");
		return "redirect:/funcionarios/listar";
	}

	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();
	}

	@ModelAttribute("estados")
	public UF[] getEstados() {
		return UF.values();
	}

}
