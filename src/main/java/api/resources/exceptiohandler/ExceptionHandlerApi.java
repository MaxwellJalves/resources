package api.resources.exceptiohandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerApi extends ResponseEntityExceptionHandler {
    //TODO Pendente de implementar a otimização das exceptions para mandar uma mensagem com o erro especifico para o consumidor da api.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return super.handleExceptionInternal(ex, "Erro interno verificar a Exception Handler Api", headers, status, request);
    }
}
