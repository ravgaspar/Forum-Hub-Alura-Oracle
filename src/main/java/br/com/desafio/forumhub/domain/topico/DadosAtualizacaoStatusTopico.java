package br.com.desafio.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoStatusTopico(
        @NotNull Long id,
        @NotNull Status status
) {
}
