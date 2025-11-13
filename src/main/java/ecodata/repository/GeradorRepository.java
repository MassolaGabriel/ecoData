package ecodata.repository;

import ecodata.model.Gerador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeradorRepository extends JpaRepository<Gerador, Long> {
}
