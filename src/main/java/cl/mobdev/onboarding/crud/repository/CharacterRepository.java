package cl.mobdev.onboarding.crud.repository;

import cl.mobdev.onboarding.crud.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    Optional<Character> findById(Integer id);

    boolean existsByName(String name);

    boolean existsById(Integer id);
}
