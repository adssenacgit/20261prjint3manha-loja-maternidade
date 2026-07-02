package br.senac.prjint3.repository;

import br.senac.prjint3.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByStatusNot(Integer status);
    Optional<Produto> findByIdAndStatusNot(Integer id, Integer status);
}
