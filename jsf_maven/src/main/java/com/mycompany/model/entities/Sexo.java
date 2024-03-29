
package com.mycompany.model.entities;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="sexo")
public class Sexo implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdSexo",nullable=false)
    private Integer idSexo;
    @Column(name="Descricao",unique=true,nullable=false,length=9)
    private String descricao;
    
    //depois inserir o construtor vazio
    //depois o getter e setter
    //depois equals e hashcode
    //depois inserir get e set(padrao em todas entidade que for criada deve ser criado get e set)
    // e serializable é padrao nas entidades todos a cima tambem
    
    //forengnkey é a unica que se pode usar que é fora do jpa,quando estar fazendo mapeamento de dados
    //onetomay uma para muitos e é mapeado pela tabela de gente
    //inserir outro list 
    //muitos para um=manyToOne (pessoa para sexo)
    //sexo para pessoa oneToMany(um para muitos)
    //esse codigo abaixo faz parte do relacionamento
   @OneToMany(mappedBy="sexo",fetch= FetchType.LAZY)
    @ForeignKey(name="PessoaSexo")
   private List<Pessoa>pessoas;
   
   
    public Sexo() {
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
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
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }
    
}
