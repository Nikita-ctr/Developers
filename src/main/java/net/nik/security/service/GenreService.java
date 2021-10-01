package net.nik.security.service;

import net.nik.security.domain.Genres;
import net.nik.security.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    public void save(Genres genres){
        genreRepository.save(genres);
    }
    public List<Genres> listAll(){
       return genreRepository.findAll();
    }
}
