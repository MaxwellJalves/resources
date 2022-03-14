package api.resources.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table( name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome",length = 150 ,nullable = false)
    @NotBlank(message = "E obrigatorio informar o nome do cliente")
    private String nome;

    @Column(name = "telefone" , length = 15)
    private String telefone;

    @Column(name = "email" , length = 150)
    private String email;

    public UUID getId() {
        return id;
    }
    public Cliente(){}

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
