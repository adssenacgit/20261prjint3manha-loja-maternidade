package br.senac.prjint3.service;

import br.senac.prjint3.entity.Pedido;
import br.senac.prjint3.exception.ResourceNotFoundException;
import br.senac.prjint3.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private static final int STATUS_APAGADO = -1;
    private static final int STATUS_ATIVO = 1;

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) { this.repository = repository; }

    public List<Pedido> listar() { return repository.findByStatusNot(STATUS_APAGADO); }

    public Pedido buscarPorId(Integer id) {
        return repository.findByIdAndStatusNot(id, STATUS_APAGADO)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado: " + id));
    }

    public Pedido criar(Pedido pedido) {
        pedido.setId(null);
        if (pedido.getStatus() == null) pedido.setStatus(STATUS_ATIVO);
        return repository.save(pedido);
    }

    public Pedido atualizar(Integer id, Pedido pedido) {
        buscarPorId(id);
        pedido.setId(id);
        if (pedido.getStatus() == null) pedido.setStatus(STATUS_ATIVO);
        return repository.save(pedido);
    }

    public void excluirLogico(Integer id) {
        Pedido pedido = buscarPorId(id);
        pedido.setStatus(STATUS_APAGADO);
        repository.save(pedido);
    }
}
