package api.resources.api.controller;

import api.resources.domain.model.Pedido;
import api.resources.domain.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("pedido")
@AllArgsConstructor
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody Pedido pedidoRequest){
        var log = Logger.getLogger(pedidoRequest.toString());
        log.info("Acessou o endpoint de pedido \n" + log);
        var response = pedidoService.salvarPedido(pedidoRequest);
        log.info("Recebeu o retorno do banco de dados , criando o response");
        return ResponseEntity.created(URI.create("pedido/".concat(""))).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> obterPedidos(){
        var response = pedidoService.obterPedidos();
        if(response != null){
            ResponseEntity.ok().body(response);
        }
        return ResponseEntity.ok().body(response);
    }
}
