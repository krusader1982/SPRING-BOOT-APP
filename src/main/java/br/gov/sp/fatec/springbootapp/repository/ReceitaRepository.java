package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{

    public Receita findByNome(String nome);
    
    public Receita findByNomeAndCategoria(String nome, String categoria);

    List<Receita> findByIngredientesNome(String string);

    @Query("select r from Receita r inner join r.ingredientes i where i.nome = ?1")
    public List<Receita> findByIngredientesNomeQuery(String ingrediente);

    
}
