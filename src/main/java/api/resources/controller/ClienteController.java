package api.resources.controller;

import api.resources.entity.Cliente;
import api.resources.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class ClienteController {
    private final ClienteService clienteService;
    private Logger log = Logger.getLogger("Controlador Inicializado");

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/clientes")
    public ResponseEntity listarClientes() {
        var response = clienteService.obterClientes();
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não foi localizado registros em nossa base de dados.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/cliente")
    public ResponseEntity obterCliente(@RequestParam(value = "nome") String nome) {
        var response = clienteService.findByNome(nome);
        log.info("PARAMETRO RECEBIDO PELO CONTROLADOR?Nome : " + nome);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não foi localizado registros em nossa base de dados.");
        }
        log.info("OBJETO OBTIDO ATRAVÉS DA REQUEST RECEBIDA:\t" + response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/cliente/{id}")
    public ResponseEntity<Cliente> obterClientePorId(@PathVariable("id") UUID id) {
        //TODO primeira forma - Funcional
        return  clienteService.findById(id)
                .map(ResponseEntity::ok)
                //.map(mapeamento -> ResponseEntity.ok(mapeamento))
                .orElse(ResponseEntity.notFound().build());
        //TODO segunda forma
        /*
        *
        *         var response = clienteService.findById(id);

        log.info("PARAMETRO RECEBIDO PELO CONTROLADOR_por_ID? : " + id);
        if (!response.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não foi localizado registros em nossa base de dados.");
        }
        log.info("OBJETO OBTIDO ATRAVÉS DA REQUEST{id} RECEBIDA:\t" + response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
        * */
    }

    @PostMapping(path = "/cliente")
    public ResponseEntity cadastrarCliente(@RequestBody @Valid Cliente cliente){
        var response = clienteService.save(cliente);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("não foi possivel salvar");
        }
        return ResponseEntity.created(URI.create("localhost:8080/cliente/"+response.getId())).body(response);
    }
    @PutMapping(path = "/cliente/{id}")
    public ResponseEntity atualizarCliente(@PathVariable("id")UUID id ,@RequestBody @Valid Cliente cliente){

        log.info("DEBUG"+cliente.toString());
        var validacao = clienteService.findById(id);
        if(!validacao.isPresent()){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        var response = clienteService.save(cliente);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(path = "/cliente/{id}")
    public String removerCliente(@PathVariable UUID id){
       return clienteService.delete(id);
    }
}
