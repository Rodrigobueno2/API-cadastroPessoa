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
public class Endereco {
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String rua;
   private String numero;
   private String bairro;
}