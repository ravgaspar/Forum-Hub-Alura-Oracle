package br.com.desafio.forumhub.domain.topico;

import br.com.desafio.forumhub.domain.curso.DadosListagemCurso;
import br.com.desafio.forumhub.domain.usuario.DadosListagemUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        Status status,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
        Instant dataCriacao,
        DadosListagemUsuario usuario,
        DadosListagemCurso curso
) {
    public DadosListagemTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getStatus(),
                topico.getDataCriacao(),
                new DadosListagemUsuario(topico.getUsuario()),
                new DadosListagemCurso(topico.getCurso()));
    }
}

