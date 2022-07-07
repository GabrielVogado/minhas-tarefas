package br.com.uniciv.minhastarefas.controller;

import br.com.uniciv.minhastarefas.entity.TarefaCategoria;
import br.com.uniciv.minhastarefas.repository.TarefaCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TarefaCategoriaController {

	@Autowired
	private TarefaCategoriaRepository repositorio;
	
	@GetMapping("/categoria")
	public List<TarefaCategoria> todasCategorias() {
		return repositorio.findAll();
	}
	
	@GetMapping("/categoria/{id}")
	public TarefaCategoria umaCategoria(@PathVariable Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	@PostMapping("/categoria")
	public TarefaCategoria salvarCategoria(@RequestBody TarefaCategoria categoria) {
		return repositorio.save(categoria);
	}
	
	@DeleteMapping("/categoria/{id}")
	public void excluirTarefa(@PathVariable Integer id) {
		repositorio.deleteById(id);
	}
	
}
