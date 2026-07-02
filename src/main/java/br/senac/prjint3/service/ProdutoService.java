package br.senac.prjint3.service;

import br.senac.prjint3.entity.Produto;
import br.senac.prjint3.exception.ResourceNotFoundException;
import br.senac.prjint3.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private static final int STATUS_APAGADO = -1;
    private static final int STATUS_ATIVO = 1;

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() { return repository.findByStatusNot(STATUS_APAGADO); }

    public Produto buscarPorId(Integer id) {
        return repository.findByIdAndStatusNot(id, STATUS_APAGADO)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + id));
    }

    public Produto criar(Produto produto) {
        produto.setId(null);
        if (produto.getStatus() == null) produto.setStatus(STATUS_ATIVO);
        return repository.save(produto);
    }

    public Produto atualizar(Integer id, Produto produto) {
        buscarPorId(id);
        produto.setId(id);
        if (produto.getStatus() == null) produto.setStatus(STATUS_ATIVO);
        return repository.save(produto);
    }

    public void excluirLogico(Integer id) {
        Produto produto = buscarPorId(id);
        produto.setStatus(STATUS_APAGADO);
        repository.save(produto);
    }
}
