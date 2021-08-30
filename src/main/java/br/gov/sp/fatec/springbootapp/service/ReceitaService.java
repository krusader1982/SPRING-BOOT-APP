package br.gov.sp.fatec.springbootapp.service;

import br.gov.sp.fatec.springbootapp.entity.Receita;

public interface ReceitaService {

    public Receita cadastrarReceita(String nome, String categoria, String ingrediente);
    
} 
