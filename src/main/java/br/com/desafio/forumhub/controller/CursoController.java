package br.com.desafio.forumhub.controller;

import br.com.desafio.forumhub.domain.curso.Curso;
import br.com.desafio.forumhub.domain.curso.DadosCadastroCurso;
import br.com.desafio.forumhub.domain.curso.CursoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@RequestBody @Validated DadosCadastroCurso dados) {
        Curso curso = cursoService.criarCurso(dados);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }

}
