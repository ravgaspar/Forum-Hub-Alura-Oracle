package br.com.desafio.forumhub.domain.topico;

import br.com.desafio.forumhub.domain.curso.Curso;
import br.com.desafio.forumhub.domain.curso.CursoRepository;
import br.com.desafio.forumhub.domain.usuario.Usuario;
import br.com.desafio.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional(readOnly = true)
    public List<DadosListagemTopico> listar() {
        return topicoRepository.findAll().stream()
                .map(DadosListagemTopico::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Topico criarTopico(DadosCadastroTopico dados) {
        Usuario usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        Curso curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        Topico topico = new Topico(dados, usuario, curso);
        return topicoRepository.save(topico);
    }

    @Transactional
    public Topico atualizarStatusTopico(DadosAtualizacaoStatusTopico dados) {
        Topico topico = topicoRepository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topico.setStatus(dados.status());
        return topicoRepository.save(topico);


    }

    @Transactional
    public void deletarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico não encontrado");
        }
        topicoRepository.deleteById(id);
    }

}
