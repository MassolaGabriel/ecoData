package ecodata.repository;

import ecodata.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResiduoRepository extends JpaRepository<Residuo, Long> {
    }
