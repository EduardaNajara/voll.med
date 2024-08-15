package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHoraDeAtendimento implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDas7 = dataConsulta.getHour() < 7;
        var depoisDas18 = dataConsulta.getHour() > 18;
        if (domingo || antesDas7 || depoisDas18) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
