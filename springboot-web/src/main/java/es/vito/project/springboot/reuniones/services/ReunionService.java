package es.vito.project.springboot.reuniones.services;

import es.vito.project.springboot.reuniones.data.ReunionRepository;

import es.vito.project.springboot.reuniones.models.Reunion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReunionService {

    private final ReunionRepository reunionRepository;

    public ReunionService(ReunionRepository reunionRepository) {
        this.reunionRepository = reunionRepository;
    }

    public List<Reunion> getAllReuniones() {
        return reunionRepository.findAll();
    }
}