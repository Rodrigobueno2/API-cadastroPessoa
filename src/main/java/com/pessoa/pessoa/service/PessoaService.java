package com.pessoa.pessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pessoa.pessoa.domain.Pessoa;
import com.pessoa.pessoa.repository.PessoaRepository;

@Service
public class PessoaService {
   
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa listarPessoaPorId(Long id) {
		if(pessoaRepository.findById(id).isEmpty()) {
			throw new RuntimeException("Não existe pessoa com esse id cadastrado");
		}
		
		return pessoaRepository.findById(id).get();
	}
	
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}
	
	public Page<Pessoa> listarPessoasPaginadas(Pageable page){
		return pessoaRepository.findAll(page);
	}
	
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		if(pessoaRepository.findById(pessoa.getId()).isEmpty()) {
			throw new RuntimeException("Faça um post no lugar de um put, pois essa pessoa não existe");
		}
		
		return pessoaRepository.save(pessoa);
	}
	
	public void deletarPessoa(Long id) {
		if(pessoaRepository.findById(id).isEmpty()) {
			throw new RuntimeException("Não tem deletar essa pessoa, pois não tem pessoa cadastrada com este id");
		}
		
		 pessoaRepository.deleteById(id);
	}
}
