package api.resources.domain.service;

import api.resources.domain.model.Pedido;
import api.resources.domain.repository.ClienteRepository;
import api.resources.domain.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;

    public Pedido salvarPedido(Pedido pedido){
        var cliente = clienteRepository.findById(pedido.getCliente().getId());

        pedido.setCliente(cliente.orElseThrow(()-> new IllegalArgumentException("Usuario não localizado na base de dados")));

        return pedidoRepository.save(pedido);
    }


    public List<Pedido> obterPedidos(){
        return pedidoRepository.findAll();
    }

}



