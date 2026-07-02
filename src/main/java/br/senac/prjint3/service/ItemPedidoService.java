package br.senac.prjint3.service;

import br.senac.prjint3.entity.ItemPedido;
import br.senac.prjint3.exception.ResourceNotFoundException;
import br.senac.prjint3.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    private static final int STATUS_APAGADO = -1;
    private static final int STATUS_ATIVO = 1;

    private final ItemPedidoRepository repository;

    public ItemPedidoService(ItemPedidoRepository repository) { this.repository = repository; }

    public List<ItemPedido> listar() { return repository.findByStatusNot(STATUS_APAGADO); }

    public ItemPedido buscarPorId(Integer id) {
        return repository.findByIdAndStatusNot(id, STATUS_APAGADO)
                .orElseThrow(() -> new ResourceNotFoundException("Item do pedido não encontrado: " + id));
    }

    public ItemPedido criar(ItemPedido itemPedido) {
        itemPedido.setId(null);
        if (itemPedido.getStatus() == null) itemPedido.setStatus(STATUS_ATIVO);
        return repository.save(itemPedido);
    }

    public ItemPedido atualizar(Integer id, ItemPedido itemPedido) {
        buscarPorId(id);
        itemPedido.setId(id);
        if (itemPedido.getStatus() == null) itemPedido.setStatus(STATUS_ATIVO);
        return repository.save(itemPedido);
    }

    public void excluirLogico(Integer id) {
        ItemPedido itemPedido = buscarPorId(id);
        itemPedido.setStatus(STATUS_APAGADO);
        repository.save(itemPedido);
    }
}
