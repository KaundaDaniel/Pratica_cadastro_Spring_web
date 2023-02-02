package com.estudante.gestao_estudante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudante.gestao_estudante.entities.Estudantes;

public interface EstudanteRepositories extends JpaRepository<Estudantes, Long>{
    
    
}
