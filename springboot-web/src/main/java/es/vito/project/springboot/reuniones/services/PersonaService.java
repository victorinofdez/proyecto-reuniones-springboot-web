package es.vito.project.springboot.reuniones.services;

import es.vito.project.springboot.reuniones.data.PersonaRepository;
import es.vito.project.springboot.reuniones.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
}
