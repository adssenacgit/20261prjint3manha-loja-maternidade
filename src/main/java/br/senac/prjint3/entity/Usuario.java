package br.senac.prjint3.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;

    @Column(name = "usuario_nome", length = 100)
    private String nome;

    @Column(name = "usuario_cpf", length = 11)
    private String cpf;

    @Column(name = "usuario_email", length = 100)
    private String email;

    @Column(name = "usuario_senha", length = 100)
    private String senha;

    @Column(name = "usuario_telefone", length = 11)
    private String telefone;

    @Column(name = "usuario_endereco", length = 200)
    private String endereco;

    @Column(name = "usuario_data_nascimento")
    private LocalDate dataNasc;

    @Column(name = "usuario_data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "usuario_numero_cartao", length = 50)
    private String numeroCartao;

    @Column(name = "usuario_admin")
    private Integer admin;

    @Column(name = "usuario_status")
    private Integer status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public LocalDate getDataNasc() { return dataNasc; }
    public void setDataNasc(LocalDate dataNasc) { this.dataNasc = dataNasc; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
    public String getNumeroCartao() { return numeroCartao; }
    public void setNumeroCartao(String numeroCartao) { this.numeroCartao = numeroCartao; }
    public Integer getAdmin() { return admin; }
    public void setAdmin(Integer admin) { this.admin = admin; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}
