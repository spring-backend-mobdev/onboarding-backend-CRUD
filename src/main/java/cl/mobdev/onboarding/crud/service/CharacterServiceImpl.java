package cl.mobdev.onboarding.crud.service;

import cl.mobdev.onboarding.crud.entity.Character;
import cl.mobdev.onboarding.crud.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl  {

    @Autowired
    private CharacterRepository characterRepository;

    public String createCharacter(Character character) {
        try {
            if (!characterRepository.existsByName(character.getName())) {
                characterRepository.save(character);
                return "Character record created successfully!!!";
            } else {
                return "Character already exists in the database";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Character> readCharacter() {
        return characterRepository.findAll();
    }

    @Transactional
    public String updateCharacter(Character character) {
        if (characterRepository.existsById(character.getId())) {
            try {
                Optional<Character> characters = characterRepository.findById(character.getId());
                characters.stream().forEach(c -> {
                    Character characterToBeUpdate = characterRepository.findById(c.getId()).get();
                    characterToBeUpdate.setId(character.getId());
                    characterToBeUpdate.setName(character.getName());
                    characterToBeUpdate.setGender(character.getGender());
                    characterToBeUpdate.setType(character.getType());
                    characterToBeUpdate.setSpecies(character.getSpecies());
                    characterToBeUpdate.setStatus(character.getStatus());
                    //characterToBeUpdate.setEpisode(character.getEpisode());
                    //characterToBeUpdate.setLocation(character.getLocation().getName());
                    //characterToBeUpdate.setLocation(character.getLocation().getUrl());
                    //characterToBeUpdate.setLocation(character.getLocation());
                    characterToBeUpdate.setUrl(character.getUrl());
                    characterToBeUpdate.setImage(character.getImage());
                    characterToBeUpdate.setCreated(character.getCreated());
                    characterRepository.save(characterToBeUpdate);
                });
                return "Character record update";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Character does not exists in the database";
        }
    }

    @Transactional
    public String deleteCharacter(Character character) {
        if (characterRepository.existsById(character.getId())) {
            try {
                Optional<Character> characters = characterRepository.findById(character.getId());
                characters.stream().forEach(c -> {
                    System.out.println(c.toString());
                    characterRepository.delete(c);
                });
                return "Character record deleted successfully";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Character Id does Not exist";
        }
    }
}