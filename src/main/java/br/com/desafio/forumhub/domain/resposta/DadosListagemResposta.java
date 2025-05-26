package br.com.desafio.forumhub.domain.resposta;

import br.com.desafio.forumhub.domain.usuario.DadosListagemUsuario;
import br.com.desafio.forumhub.domain.topico.DadosListagemTopico;

import java.time.Instant;

public record DadosListagemResposta(
        Long id,
        String mensagem,
        Instant dataCriacao,
        Boolean solucao,
        DadosListagemUsuario autor,
        DadosListagemTopico topico
) {
    public DadosListagemResposta(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getSolucao(),
                new DadosListagemUsuario(resposta.getAutor()),
                new DadosListagemTopico(resposta.getTopico())
        );
    }
}
