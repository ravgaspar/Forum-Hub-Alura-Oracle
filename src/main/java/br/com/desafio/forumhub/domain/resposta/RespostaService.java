package br.com.desafio.forumhub.domain.resposta;

import br.com.desafio.forumhub.domain.topico.Topico;
import br.com.desafio.forumhub.domain.topico.TopicoRepository;
import br.com.desafio.forumhub.domain.usuario.Usuario;
import br.com.desafio.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Resposta cadastrar(DadosCadastroResposta dados) {
        Optional<Usuario> autorOpt = usuarioRepository.findById(dados.autorId());
        Optional<Topico> topicoOpt = topicoRepository.findById(dados.topicoId());

        if (autorOpt.isPresent() && topicoOpt.isPresent()) {
            Usuario autor = autorOpt.get();
            Topico topico = topicoOpt.get();
            Resposta resposta = new Resposta(dados, autor, topico);
            return respostaRepository.save(resposta);
        }

        throw new IllegalArgumentException("Autor ou Tópico não encontrado");
    }

    public List<DadosListagemResposta> listar() {
        return respostaRepository.findAll().stream().map(DadosListagemResposta::new).toList();
    }

    public void deletar(Long id) {
        respostaRepository.deleteById(id);
    }
}
