package br.com.desafio.forumhub.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<DadosListagemUsuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(DadosListagemUsuario::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Usuario cadastrar(DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario atualizarUsuario(DadosAtualizacaoUsuario dados) {
        Usuario usuario = usuarioRepository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.atualizar(dados);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }


}
