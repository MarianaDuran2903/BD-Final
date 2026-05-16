package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Repositorio.ClaseRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ClaseScheduler {

    private final ClaseRepository claseRepository;

    public ClaseScheduler(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    @Scheduled(fixedDelay = 60000)
    @Transactional
    public void finalizarClasesVencidas() {
        claseRepository.finalizarClasesVencidas(LocalDate.now(), LocalTime.now());
    }
}
