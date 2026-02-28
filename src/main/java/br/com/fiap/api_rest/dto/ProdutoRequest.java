package br.com.fiap.api_rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProdutoRequest(

        @NotBlank(message = "O nome é obigatório")
        @Size(min = 2, max = 150, message = "O nome deve ter entre 2 a 150 caracteres")
        String nome,
        @NotNull(message = "O preço é obigatório")
        @DecimalMin(value = "0.99", message = "O valor mínimo deve ser 0.99")
        BigDecimal preco,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate expiracao
) {
}
