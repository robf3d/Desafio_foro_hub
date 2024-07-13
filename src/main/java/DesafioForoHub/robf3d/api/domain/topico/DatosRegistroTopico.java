package DesafioForoHub.robf3d.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        @DateTimeFormat
        LocalDateTime fecha,

        @NotBlank
        String status,

        @NotBlank
        String autor,

        @NotBlank
        String curso) {
}
