package br.senac.prjint3.controller;

import br.senac.prjint3.entity.Pedido;
import br.senac.prjint3.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("*")
@Tag(name = "Pedidos", description = "CRUD de pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) { this.service = service; }

    @GetMapping
    public List<Pedido> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Integer id) { return service.buscarPorId(id); }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(pedido));
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        return service.atualizar(id, pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluirLogico(id);
        return ResponseEntity.noContent().build();
    }
}
