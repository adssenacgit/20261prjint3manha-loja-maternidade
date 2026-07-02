package br.senac.prjint3.service;

import br.senac.prjint3.entity.Endereco;
import br.senac.prjint3.exception.ResourceNotFoundException;
import br.senac.prjint3.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private static final int STATUS_APAGADO = -1;
    private static final int STATUS_ATIVO = 1;

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) { this.repository = repository; }

    public List<Endereco> listar() { return repository.findByStatusNot(STATUS_APAGADO); }

    public Endereco buscarPorId(Integer id) {
        return repository.findByIdAndStatusNot(id, STATUS_APAGADO)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado: " + id));
    }

    public Endereco criar(Endereco endereco) {
        endereco.setId(null);
        if (endereco.getStatus() == null) endereco.setStatus(STATUS_ATIVO);
        return repository.save(endereco);
    }

    public Endereco atualizar(Integer id, Endereco endereco) {
        buscarPorId(id);
        endereco.setId(id);
        if (endereco.getStatus() == null) endereco.setStatus(STATUS_ATIVO);
        return repository.save(endereco);
    }

    public void excluirLogico(Integer id) {
        Endereco endereco = buscarPorId(id);
        endereco.setStatus(STATUS_APAGADO);
        repository.save(endereco);
    }
}
