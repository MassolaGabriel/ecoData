package ecodata.repository;

import ecodata.model.Residuo;
import ecodata.model.enums.StatusResiduo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResiduoRepository extends JpaRepository<Residuo, Long> {
    List<Residuo> findByStatusResiduo(StatusResiduo statusResiduo);
}
