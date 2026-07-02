package br.senac.prjint3.controller;

import br.senac.prjint3.entity.Pagamento;
import br.senac.prjint3.service.PagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
@CrossOrigin("*")
@Tag(name = "Pagamentos", description = "CRUD de pagamentos")
public class PagamentoController {
    private final PagamentoService service;

    public PagamentoController(PagamentoService service) { this.service = service; }

    @GetMapping
    public List<Pagamento> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Pagamento buscarPorId(@PathVariable Integer id) { return service.buscarPorId(id); }

    @PostMapping
    public ResponseEntity<Pagamento> criar(@RequestBody Pagamento pagamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(pagamento));
    }

    @PutMapping("/{id}")
    public Pagamento atualizar(@PathVariable Integer id, @RequestBody Pagamento pagamento) {
        return service.atualizar(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluirLogico(id);
        return ResponseEntity.noContent().build();
    }
}
