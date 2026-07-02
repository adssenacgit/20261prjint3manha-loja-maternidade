package br.senac.prjint3.repository;

import br.senac.prjint3.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByStatusNot(Integer status);
    Optional<Usuario> findByIdAndStatusNot(Integer id, Integer status);
}
