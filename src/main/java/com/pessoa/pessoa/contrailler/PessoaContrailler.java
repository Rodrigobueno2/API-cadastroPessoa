package com.pessoa.pessoa.contrailler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoa.pessoa.domain.Pessoa;
import com.pessoa.pessoa.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaContrailler {
    @Autowired
    private PessoaService pessoaService;
    
    @PostMapping()
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
    	
    	return pessoaService.salvarPessoa(pessoa);
    }
    
    @GetMapping("/{id}")
    public Pessoa listarPessoaPorId(@PathVariable Long id) {
    	
    	return pessoaService.listarPessoaPorId(id);
    }
    
    @GetMapping()
    public Page<Pessoa> listarPessoasPaginadas(Pageable pageable){
    	return pessoaService.listarPessoasPaginadas(pageable);
    }
    
    @GetMapping("/list")
    public List<Pessoa> listarPessoas(){
    	return pessoaService.listarPessoas();
    }
    
    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
    	if(!pessoa.getId().equals(id)) {
    		throw new RuntimeException("O id da URL não é a mesma da pessoa no corpo da requisição");
    	}
    	
    	return pessoaService.atualizarPessoa(pessoa);
    }
    
    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
    	pessoaService.deletarPessoa(id);
    }
    
    
}
