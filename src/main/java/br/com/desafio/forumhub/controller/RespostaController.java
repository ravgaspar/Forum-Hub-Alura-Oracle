package br.com.desafio.forumhub.controller;

import br.com.desafio.forumhub.domain.resposta.DadosCadastroResposta;
import br.com.desafio.forumhub.domain.resposta.DadosListagemResposta;
import br.com.desafio.forumhub.domain.resposta.Resposta;
import br.com.desafio.forumhub.domain.resposta.RespostaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resposta")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public ResponseEntity<DadosListagemResposta> cadastrar(@RequestBody @Valid DadosCadastroResposta dados) {
        Resposta resposta = respostaService.cadastrar(dados);
        return ResponseEntity.ok(new DadosListagemResposta(resposta));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemResposta>> listar() {
        List<DadosListagemResposta> respostas = respostaService.listar();
        return ResponseEntity.ok(respostas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        respostaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
