package api.resources.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//TODO 0..* ocorrencias para Entrega
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ocorrencia {
    private String descricao;
    private LocalDateTime dataRegistro;
}
