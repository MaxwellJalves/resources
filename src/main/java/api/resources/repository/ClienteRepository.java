package api.resources.repository;

import api.resources.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    Cliente findByNome(String nome);
}
