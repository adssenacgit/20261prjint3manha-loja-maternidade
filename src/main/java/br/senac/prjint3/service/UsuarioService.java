package br.senac.prjint3.service;

import br.senac.prjint3.entity.Usuario;
import br.senac.prjint3.exception.ResourceNotFoundException;
import br.senac.prjint3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private static final int STATUS_APAGADO = -1;
    private static final int STATUS_ATIVO = 1;

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findByStatusNot(STATUS_APAGADO);
    }

    public Usuario buscarPorId(Integer id) {
        return repository.findByIdAndStatusNot(id, STATUS_APAGADO)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado: " + id));
    }

    public Usuario criar(Usuario usuario) {
        usuario.setId(null);
        if (usuario.getStatus() == null) usuario.setStatus(STATUS_ATIVO);
        return repository.save(usuario);
    }

    public Usuario atualizar(Integer id, Usuario usuario) {
        buscarPorId(id);
        usuario.setId(id);
        if (usuario.getStatus() == null) usuario.setStatus(STATUS_ATIVO);
        return repository.save(usuario);
    }

    public void excluirLogico(Integer id) {
        Usuario usuario = buscarPorId(id);
        usuario.setStatus(STATUS_APAGADO);
        repository.save(usuario);
    }
}
