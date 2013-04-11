
package com.mycompany.model.entities;




import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;



@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue
    @Column(name="Idpessoa",nullable=false)
private Integer idPessoa;
    @Column(name="Name",nullable=false,length=80)
private String nome;
     @Column(name="Email",nullable=false,length=80)
private String email;
      @Column(name="Telefone",nullable=false,length=15)
private String telefone;
       @Column(name="cpf",nullable=false,length=14)
private String cpf;
  
     @Column(name="DatadeNascimento",nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;   

    
    
    
    
    @Column(name="DatadeCadastro",nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro; 
    
    
    //criar construtor 
    //depois gera getter e setter
    
    //criar uma pessoa do tipo pessoa porque o manytoOne diz que muiitas pessoas
    //usam um  sexo.
    @ManyToOne(optional=false)
    @ForeignKey(name="PessoaSexo")
    private Pessoa pessoa; //agente sempre utilizava string agora vamos usar uma classe que agente mesmo criou
    
    
    public Pessoa() {
        
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }
//sobreescrevendo da classe object por isso o override
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
    
    }

