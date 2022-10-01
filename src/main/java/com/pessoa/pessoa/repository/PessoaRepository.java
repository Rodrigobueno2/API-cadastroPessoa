package com.pessoa.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pessoa.pessoa.domain.Pessoa;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long>{

}
