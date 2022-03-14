package api.resources.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DestinatarioTests {


    @Mock
    private Destinatario destinatario;

    @Test
    public void deve_criar_um_objeto_destinatario_com_todos_os_parametros() {
        destinatario = new Destinatario();
        destinatario.setNome("Max");
        destinatario.setBairro("Centro");
        destinatario.setComplemento("Apartamento");
        destinatario.setNumero("100");
        destinatario.setLogradouro("Primeira travessa 18 de março");

        Assertions.assertEquals("Max",destinatario.getNome());
        Assertions.assertEquals("Centro",destinatario.getBairro());
        Assertions.assertEquals("Apartamento",destinatario.getComplemento());
        Assertions.assertEquals("100",destinatario.getNumero());
        Assertions.assertEquals("Primeira travessa 18 de março",destinatario.getLogradouro());
    }

}
