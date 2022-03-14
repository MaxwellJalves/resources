package api.resources.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private int quantidade;

    private int senha;

    public  Pedido(Long id , int quantidade, int senha , UUID clienteId){
        this.id = id;
        this.quantidade = quantidade;
        this.senha = senha;
        this.cliente.setId(clienteId);
    }




}
//TODO  @Embeddable na classe   -  @Embedded no atributo

/*
* a anotação @Embedded é utilizada para abstratir a criação de uma nova tabela.
* Ex:
*   No java tenho duas classes uma do cliente e outra com o endereço do cliente
* e eu não quero que o jpa crie duas tabelas junte tudo em uma única tabela.
* Solução.
*
* Crio a entidade que irá armazenar os dois valores
* na entidade que não terá mapeamento utilizamos a anotação.
*
*
* */

//STOP EM 30 MINUTOS DO MODULO 3