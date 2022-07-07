package br.com.uniciv.minhastarefas.config;


import br.com.uniciv.minhastarefas.entity.Tarefa;
import br.com.uniciv.minhastarefas.entity.TarefaCategoria;
import br.com.uniciv.minhastarefas.entity.Usuario;
import br.com.uniciv.minhastarefas.enums.TarefaStatus;
import br.com.uniciv.minhastarefas.repository.TarefaCategoriaRepository;
import br.com.uniciv.minhastarefas.repository.TarefaRepository;
import br.com.uniciv.minhastarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("dev")
public class CarregaBaseDeDados {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TarefaCategoriaRepository categoriaRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Bean
    CommandLineRunner executar() {
        return args -> {
            Usuario usuario = Usuario.builder()
                    .nome("Admin").senha("123")
                    .build();
            usuarioRepository.save(usuario);

            TarefaCategoria categoria = TarefaCategoria.builder()
                    .nome("Estudos")
                    .build();
            categoriaRepository.save(categoria);

            Tarefa tarefa = Tarefa.builder()
                    .descricao("Aprender Spring Boot")
                    .dataEntrega(LocalDate.now().plusDays(1))
                    .status(TarefaStatus.ABERTO)
                    .visivel(true)
                    .categoria(categoria)
                    .usuario(usuario)
                    .build();
            tarefaRepository.save(tarefa);

            Tarefa tarefa2 = Tarefa.builder()
                    .descricao("Aprender Spring Boot JPA")
                    .dataEntrega(LocalDate.now().plusDays(1))
                    .status(TarefaStatus.ABERTO)
                    .visivel(true)
                    .categoria(categoria)
                    .usuario(usuario)
                    .build();
            tarefaRepository.save(tarefa2);

        };
    }
}
