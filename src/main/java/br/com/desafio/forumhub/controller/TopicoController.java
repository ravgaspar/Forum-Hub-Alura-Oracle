package br.com.desafio.forumhub.controller;

import br.com.desafio.forumhub.domain.topico.TopicoService;
import br.com.desafio.forumhub.domain.topico.DadosAtualizacaoStatusTopico;
import br.com.desafio.forumhub.domain.topico.DadosCadastroTopico;
import br.com.desafio.forumhub.domain.topico.DadosListagemTopico;
import br.com.desafio.forumhub.domain.topico.Topico;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<List<DadosListagemTopico>> listar() {
        List<DadosListagemTopico> topicos = topicoService.listar();
        return ResponseEntity.ok(topicos);
    }

    @PostMapping
    public ResponseEntity<Topico> criarTopico(@RequestBody @Valid DadosCadastroTopico dados) {
        Topico topico = topicoService.criarTopico(dados);
        return new ResponseEntity<>(topico, HttpStatus.CREATED);
    }

    @PutMapping("/status")
    public ResponseEntity<Topico> atualizarStatusTopico(@RequestBody @Validated DadosAtualizacaoStatusTopico dados) {
        Topico topico = topicoService.atualizarStatusTopico(dados);
        return ResponseEntity.ok(topico);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        topicoService.deletarTopico(id);
        return ResponseEntity.noContent().build();
    }

}