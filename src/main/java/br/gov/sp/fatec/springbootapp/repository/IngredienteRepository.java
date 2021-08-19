package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
    
    public Ingrediente findByNome(String nome);
}
