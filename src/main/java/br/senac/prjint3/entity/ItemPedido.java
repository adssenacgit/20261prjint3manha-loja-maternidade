package br.senac.prjint3.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itempedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itempedido_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "itempedido_quantidade")
    private Integer quantidade;

    @Column(name = "itempedido_valor_unitario", precision = 10, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "itempedido_status")
    private Integer status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}
