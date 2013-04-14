
package com.mycompany.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="endereço")
public class Endereco implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdEndereco",nullable=false)
    private  Integer idEndereco;
    @Column(name="Bairro",length=80)
    private String bairro;
    @Column(name="nomeLogradouro",length=80)
    private String nomeLogradouro;
    @Column(name="CEP",length=9)
    private String cep;
    @Column(name="Numero")
    private Integer numero;
    @Column(name="Complemento")
    private Integer complemento;
    
    //fazer commit e refatorar depois é que nao conectei a internet ai depois faco
    //cidade,tipologradouro,estado,tipoendereco depois endereco depois fui
    //ajeitar a classe pessoa
    
    @OneToOne(optional=true,fetch=FetchType.LAZY)
    @ForeignKey(name="EnderecoPessoa")
    @JoinColumn(name="IdPessoa",referencedColumnName="IdPessoa")
    private Pessoa pessoa;
    
    
    //ManyToOne = muito para um
    
    @ManyToOne(optional=false,fetch=FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoLogradouro")
    @JoinColumn(name="IdTipoLogradouro",referencedColumnName="IdTipoLogradouro")
    private TipoLogradouro tipoLogradouro;
    
    @ManyToOne(optional=false,fetch=FetchType.LAZY)
    @ForeignKey(name="EnderecoEstado")
    @JoinColumn(name="IdEstado",nullable=false)
    private Estado estado;
    
    @ManyToOne(optional=false,fetch=FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoEndereco")
    @JoinColumn(name="IdTipoEndereco",referencedColumnName="IdTipoEndereco")
    private TipoEndereco tipoendereco;
    
    
    @ManyToOne(optional=false,fetch=FetchType.LAZY)
    @ForeignKey(name="EnderecoCidade")
    @JoinColumn(name="IdCidade",referencedColumnName="IdCidade")
    private Cidade cidade;       //Atributo
    

    @ManyToOne(optional=false,fetch=FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoLogradouro")
    @JoinColumn(name="IdtipoLogradouro",referencedColumnName="IdTipoLogradouro")
    private TipoLogradouro tipoEndereco;     

    public TipoLogradouro getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoLogradouro tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
    
   // Depois tive que fazer o new porque senao iria dar erro ele fez nesse e nao fez no outro justamente
      //      para depois ver o erro
    public Endereco() {
        this.cidade=new Cidade();
        this.estado=new Estado();
        this.tipoLogradouro=new TipoLogradouro();
        this.tipoEndereco=new TipoLogradouro();
        this.pessoa=new Pessoa();
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getComplemento() {
        return complemento;
    }

    public void setComplemento(Integer complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoEndereco getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(TipoEndereco tipoendereco) {
        this.tipoendereco = tipoendereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }
    
    
    //ajeitar as outras de acordo com ate o tipo logradouro
    
    
    
    
    
    
    
    
}
