package api.resources.domain.service;

import api.resources.domain.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ClienteServicesTests {


    @Test
    void deve_retornar_dados_para_todos_os_get() {
        var cliente = new Cliente();
        cliente.setEmail("email@gmail.com");
        cliente.setNome("Maxwell");
        cliente.setTelefone("8155555555");

        var clientes = Arrays.asList(cliente);
        Assertions.assertEquals(clientes.get(0).getNome(), "Maxwell");
        Assertions.assertEquals(clientes.get(0).getEmail(), "email@gmail.com");
        Assertions.assertEquals(clientes.get(0).getTelefone(), "8155555555");
    }
}
