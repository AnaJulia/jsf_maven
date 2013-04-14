
package com.mycompany.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tipologradouro")
public class TipoLogradouro implements Serializable{
   private static final long serialVersionUID=1L;
   
   //no meu no canto de nome,no dele é descriçao
   
  @Id
  @GeneratedValue
  @Column(name="IdTipoLogradouro",nullable=false)
  private Integer idTipoLogradouro;
  @Column(name="nome",nullable=false,length=20)
  
   private String nome;
  
  @OneToMany(mappedBy="tipologradouro",fetch=FetchType.LAZY)
  @ForeignKey(name="EnderecoTipoLogradouro")
    private List<Endereco>enderecos;
  
    public TipoLogradouro() {
    }

    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.idTipoLogradouro != null ? this.idTipoLogradouro.hashCode() : 0);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idTipoLogradouro != other.idTipoLogradouro && (this.idTipoLogradouro == null || !this.idTipoLogradouro.equals(other.idTipoLogradouro))) {
            return false;
        }
        return true;
    }
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
