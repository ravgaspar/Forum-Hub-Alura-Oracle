package br.com.desafio.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(

        @NotBlank
        String nome,

        @NotBlank
        String categoria) {
}
