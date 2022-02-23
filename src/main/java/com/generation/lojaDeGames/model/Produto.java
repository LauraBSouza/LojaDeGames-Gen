package com.generation.lojaDeGames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	@Entity
	@Table(name = "tb_produtos")
	public class Produto {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "O nome do jogo é obrigatório!")
		@Size(min = 5, max = 100, message = "O nome do produto deve ter no mínimo 5 e no máximo 100 caracteres")
		private String nome;
		
		@NotBlank(message = "A descrição do jogo é obrigatório!")
		@Size(min = 5, max = 1000, message = "A descrição deve ter no mínimo 10 e no máximo 1000 caracteres")
		private String descricao;
		
		
		@NotNull
		private int quantidade;
		
        @NotNull
		private BigDecimal preco;
		
		
		@NotBlank(message = "Atributo obrigatório")
		private String console;
		
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;

		
		

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getDescricao() {
			return descricao;
		}


		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}


		public int getQuantidade() {
			return quantidade;
		}


		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}


		public BigDecimal getPreco() {
			return preco;
		}


		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}


		public String getConsole() {
			return console;
		}


		public void setConsole(String console) {
			this.console = console;
		}


		public Categoria getCategoria() {
			return categoria;
		}


		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		
		
}
