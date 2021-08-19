package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    
}
