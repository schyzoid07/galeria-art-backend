package com.uneg.galeria.repositories;

import com.uneg.galeria.models.UserAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserAnswersRepository extends JpaRepository<UserAnswers, Long> {

    // 1. Obtener las 3 respuestas de un usuario específico
    List<UserAnswers> findByUsuarioId(Long usuarioId);

    // 2.  busqueda por el login del usuario
    List<UserAnswers> findByUsuarioLogin(String login);
}