package ecodata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeradorRepository extends JpaRepository<Repository, Long> {
}
