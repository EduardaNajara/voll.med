package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {

    public enum MotivoCancelamento {

        PACIENTE_DESISTIU,
        MEDICO_CANCELOU,
        OUTROS;

    }
}
