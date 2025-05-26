package br.com.desafio.forumhub.domain.usuario;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email,
        Boolean status
) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getStatus());
    }
}
