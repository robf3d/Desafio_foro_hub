package DesafioForoHub.robf3d.api.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        Long id,

        String titulo,

        String mensaje,

        LocalDateTime fecha,

        String status,

        String autor,

        String curso) {
}
