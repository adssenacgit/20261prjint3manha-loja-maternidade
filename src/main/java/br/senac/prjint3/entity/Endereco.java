package br.senac.prjint3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "endereco_cep", length = 8)
    private String cep;

    @Column(name = "endereco_logradouro", length = 100)
    private String logradouro;

    @Column(name = "endereco_numero")
    private Integer numero;

    @Column(name = "endereco_complemento", length = 100)
    private String complemento;

    @Column(name = "endereco_bairro", length = 100)
    private String bairro;

    @Column(name = "endereco_cidade", length = 100)
    private String cidade;

    @Column(name = "endereco_estado", length = 50)
    private String estado;

    @Column(name = "endereco_status")
    private Integer status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}
