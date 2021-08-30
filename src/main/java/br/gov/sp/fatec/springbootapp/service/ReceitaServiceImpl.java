package br.gov.sp.fatec.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import br.gov.sp.fatec.springbootapp.entity.Ingrediente;
import br.gov.sp.fatec.springbootapp.entity.Receita;
import br.gov.sp.fatec.springbootapp.repository.IngredienteRepository;
import br.gov.sp.fatec.springbootapp.repository.ReceitaRepository;

@Service
public class ReceitaServiceImpl {
    
    @Autowired
	private IngredienteRepository ingRepo;

	@Autowired
	private ReceitaRepository receitaRepo;

    @Transactional
    public Receita cadastrarReceita(String nome, String categoria, String ingrediente){
        Ingrediente ing = new Ingrediente();
		ing.setNome(ingrediente);
		ingRepo.save(ing);
		Receita receita = new Receita();
		receita.setNome(nome);
		receita.setCategoria(categoria);
		receita.setIngredientes(new HashSet<Ingrediente>());
		receita.getIngredientes().add(ing);
		receitaRepo.save(receita);
		
        return receita;

    }

}
