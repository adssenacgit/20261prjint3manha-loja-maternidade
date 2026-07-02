package br.senac.prjint3.controller;

import br.senac.prjint3.entity.ItemPedido;
import br.senac.prjint3.service.ItemPedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-pedido")
@CrossOrigin("*")
@Tag(name = "Itens do Pedido", description = "CRUD de itens do pedido")
public class ItemPedidoController {
    private final ItemPedidoService service;

    public ItemPedidoController(ItemPedidoService service) { this.service = service; }

    @GetMapping
    public List<ItemPedido> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ItemPedido buscarPorId(@PathVariable Integer id) { return service.buscarPorId(id); }

    @PostMapping
    public ResponseEntity<ItemPedido> criar(@RequestBody ItemPedido itemPedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(itemPedido));
    }

    @PutMapping("/{id}")
    public ItemPedido atualizar(@PathVariable Integer id, @RequestBody ItemPedido itemPedido) {
        return service.atualizar(id, itemPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluirLogico(id);
        return ResponseEntity.noContent().build();
    }
}
