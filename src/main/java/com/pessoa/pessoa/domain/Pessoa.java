package com.pessoa.pessoa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
	
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;	
	
   private String nome;
   
   private String cpf;
}
