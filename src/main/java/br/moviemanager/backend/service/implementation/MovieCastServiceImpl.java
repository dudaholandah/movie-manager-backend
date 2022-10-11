package br.moviemanager.backend.service.implementation;

import br.moviemanager.backend.model.MovieCast;
import br.moviemanager.backend.repository.MovieCastRepository;
import br.moviemanager.backend.service.MovieCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCastServiceImpl implements MovieCastService {

    @Autowired
    private MovieCastRepository repository;

    @Override
    public MovieCast saveMovieCast(MovieCast movieCast) {
        return repository.save(movieCast);
    }

    @Override
    public List<MovieCast> findAllMovieCast() {
        return repository.findAll();
    }
}
