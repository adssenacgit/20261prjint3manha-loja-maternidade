package br.senac.prjint3.service;

import br.senac.prjint3.entity.Pagamento;
import br.senac.prjint3.exception.ResourceNotFoundException;
import br.senac.prjint3.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    private static final int STATUS_APAGADO = -1;
    private static final int STATUS_ATIVO = 1;

    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) { this.repository = repository; }

    public List<Pagamento> listar() { return repository.findByStatusNot(STATUS_APAGADO); }

    public Pagamento buscarPorId(Integer id) {
        return repository.findByIdAndStatusNot(id, STATUS_APAGADO)
                .orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado: " + id));
    }

    public Pagamento criar(Pagamento pagamento) {
        pagamento.setId(null);
        if (pagamento.getStatus() == null) pagamento.setStatus(STATUS_ATIVO);
        return repository.save(pagamento);
    }

    public Pagamento atualizar(Integer id, Pagamento pagamento) {
        buscarPorId(id);
        pagamento.setId(id);
        if (pagamento.getStatus() == null) pagamento.setStatus(STATUS_ATIVO);
        return repository.save(pagamento);
    }

    public void excluirLogico(Integer id) {
        Pagamento pagamento = buscarPorId(id);
        pagamento.setStatus(STATUS_APAGADO);
        repository.save(pagamento);
    }
}
