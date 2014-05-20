package autocomp.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 31032109
 */
@Entity
public class Usuario implements DomainObject, Serializable {
    
    @Id
    @GeneratedValue
    private int userId;
    
    @Column(unique = true, length = 8, nullable = false)
    private String tia;
    
    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Grupo grupo;

    public Usuario() {
    }

    public Usuario(String tia, String senha, String nome, Grupo grupo) {
        this.tia = tia;
        this.senha = senha;
        this.nome = nome;
        this.grupo = grupo;
    }

    public int getUserId(){
        return userId;
    }
    
    public String getTia() {
        return tia;
    }

    public void setTia(String tia) {
        this.tia = tia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Grupo getGrupo(){
        return this.grupo;
    }
}
