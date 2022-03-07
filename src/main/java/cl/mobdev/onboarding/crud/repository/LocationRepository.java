package cl.mobdev.onboarding.crud.repository;

import cl.mobdev.onboarding.crud.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    Optional<Location> findById(Integer id);

    boolean existsByName(String name);

    boolean existsById(Integer id);

}
