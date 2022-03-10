package api.resources.service;

import api.resources.entity.Cliente;
import api.resources.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }


    public List<Cliente> obterClientes(){
        return  clienteRepository.findAll();
    }

    public Cliente findByNome(String nome) {
       var retorno =  clienteRepository.findByNome(nome);
       return retorno;
    }

    public Optional<Cliente> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public String delete(UUID id) {
        try{
            clienteRepository.delete(clienteRepository.findById(id).orElse(null));
            return "remoção realizada";
        }catch (Exception exception){
            return  "Ocorreu um erro ao remover o registro!";
        }
    }
}
