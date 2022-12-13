package br.moviemanager.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BackendMovieManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendMovieManagerApplication.class, args);
	}

}
