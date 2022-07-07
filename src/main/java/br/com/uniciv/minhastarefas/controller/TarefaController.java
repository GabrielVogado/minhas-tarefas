package br.com.uniciv.minhastarefas.controller;

import java.util.List;
import java.util.Map;

import br.com.uniciv.minhastarefas.entity.Tarefa;
import br.com.uniciv.minhastarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TarefaController {

	@Autowired
	private TarefaRepository repositorio;
	
	@GetMapping("/tarefa")
	public List<Tarefa> todasTarefas(@RequestParam Map<String, String> parametros) {
		if (parametros.isEmpty())
			return repositorio.findAll();
		
		String descricao = parametros.get("descricao");
		return repositorio.findByDescricaoLike("%" + descricao + "%" );
	}
	
	@GetMapping("/tarefa/{id}")
	public Tarefa umaTarefa(@PathVariable Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	@PostMapping("/tarefa")
	public Tarefa salvarTarefa(@RequestBody Tarefa tarefa) {
		return repositorio.save(tarefa);
	}
	
	@DeleteMapping("/tarefa/{id}")
	public void excluirTarefa(@PathVariable Integer id) {
		repositorio.deleteById(id);
	}
	
}
