package br.senac.prjint3.repository;

import br.senac.prjint3.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    List<Pagamento> findByStatusNot(Integer status);
    Optional<Pagamento> findByIdAndStatusNot(Integer id, Integer status);
}
