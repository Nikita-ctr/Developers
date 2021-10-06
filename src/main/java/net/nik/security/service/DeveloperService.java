package net.nik.security.service;

import net.nik.security.domain.Developer;
import net.nik.security.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public void save(Developer developer){
        developerRepository.save(developer);
    }
    public List<Developer> listAll(){
       return developerRepository.findAll();
    }
    public Developer get(Long id){
        return developerRepository.getById(id);
    }
    public void delete(Long id){
        developerRepository.deleteById(id);
    }

}
