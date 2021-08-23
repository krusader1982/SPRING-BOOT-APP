package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Ingrediente;
import br.gov.sp.fatec.springbootapp.entity.Receita;
import br.gov.sp.fatec.springbootapp.repository.IngredienteRepository;
import br.gov.sp.fatec.springbootapp.repository.ReceitaRepository;
import br.gov.sp.fatec.springbootapp.service.ReceitaService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

	@Autowired
	private IngredienteRepository ingRepo;

	@Autowired
	private ReceitaRepository receitaRepo;

	@Autowired
	private ReceitaService receitaService;

	@Test
	void contextLoads() {
	}

	@Test
	void ingredienteRepositorySaveTestOK(){
		Ingrediente ing = new Ingrediente();
		ing.setNome("ROLE_TESTE");
		ingRepo.save(ing);
		assertNotNull(ing.getId());
	}

	@Test
	void receitaRepositorySaveTestOK(){
		Ingrediente ing = new Ingrediente();
		ing.setNome("ROLE_TESTE1");
		ingRepo.save(ing);
		Receita receita = new Receita();
		receita.setNome("TESTE");
		receita.setIngredientes(new HashSet<Ingrediente>());
		receita.getIngredientes().add(ing);
		receitaRepo.save(receita);
		assertNotNull(receita.getId());
	}

	@Test
	void ingredienteRepositoryFindByNomeTestOK(){
		Ingrediente ing = new Ingrediente();
		ing.setNome("ROLE_TESTE2");
		ingRepo.save(ing);
		assertNotNull(ingRepo.findByNome("ROLE_TESTE2"));
	}

	@Test
	void receitaServiceCadastrarReceitaTestOK(){
		receitaService.cadastrarReceita("teste", "TESTE1");

		List<Receita> receitas = receitaRepo.findByIngredientesNome("TESTE1");

		assertFalse(receitas.isEmpty());
	}
}
