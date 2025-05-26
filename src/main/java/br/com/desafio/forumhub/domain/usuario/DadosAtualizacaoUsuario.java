package br.com.desafio.forumhub.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(

        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String email,

        String senha,

        @NotNull
        Boolean status
) {
}
