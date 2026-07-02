package br.senac.prjint3.controller;

import br.senac.prjint3.entity.Endereco;
import br.senac.prjint3.service.EnderecoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@CrossOrigin("*")
@Tag(name = "Endereços", description = "CRUD de endereços")
public class EnderecoController {
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) { this.service = service; }

    @GetMapping
    public List<Endereco> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Integer id) { return service.buscarPorId(id); }

    @PostMapping
    public ResponseEntity<Endereco> criar(@RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(endereco));
    }

    @PutMapping("/{id}")
    public Endereco atualizar(@PathVariable Integer id, @RequestBody Endereco endereco) {
        return service.atualizar(id, endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluirLogico(id);
        return ResponseEntity.noContent().build();
    }
}
