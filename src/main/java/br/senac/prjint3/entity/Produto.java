package br.senac.prjint3.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Integer id;

    @Column(name = "produto_preco_unitario", precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Column(name = "produto_nome_produto", length = 100)
    private String nomeProduto;

    @Lob
    @Column(name = "produto_descricao")
    private String descricao;

    @Column(name = "produto_estoque")
    private Integer estoque;

    @Column(name = "produto_categoria", length = 100)
    private String categoria;

    @Column(name = "produto_imagem", length = 255)
    private String imagem;

    @Column(name = "produto_status")
    private Integer status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}
