package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("SELECT m FROM Medico m WHERE m.ativo = true AND m.especialidade = :especialidade AND m.id not in( SELECT c.medico.id FROM Consulta c WHERE c.data = :data) order by random() limit 1")
    Medico escolherMedico(@Param("especialidade") Especialidade especialidade, @Param("data") LocalDateTime data);

    @Query("SELECT m.ativo FROM Medico m WHERE m.id = :id")
    Boolean findAtivoById(Long id);
}
