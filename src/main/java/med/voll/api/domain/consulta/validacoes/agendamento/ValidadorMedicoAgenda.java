package med.voll.api.domain.consulta.validacoes.agendamento;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAgenda implements ValidadorAgendamentoDeConsulta {

    private final ConsultaRepository repository;

    public ValidadorMedicoAgenda(ConsultaRepository repository) {
        this.repository = repository;
    }

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoJaPossuiConsulta = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoJaPossuiConsulta) {
            throw new ValidacaoException("Médico já possui consulta agendada para o horário informado");
        }
    }
}
