package net.nik.security.repository;

import net.nik.security.domain.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genres,Long> {
}
