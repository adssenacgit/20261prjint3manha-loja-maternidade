package br.senac.prjint3.repository;

import br.senac.prjint3.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    List<Endereco> findByStatusNot(Integer status);
    Optional<Endereco> findByIdAndStatusNot(Integer id, Integer status);
}
