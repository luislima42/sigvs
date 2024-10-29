package com.fatec.sigvs.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descricao;
	private String categoria;
	private String custo;
	private String quantidadeNoEstoque;
	public Produto(String descricao, String categoria, String custo, String quantidadeNoEstoque) {
		setDescricao(descricao);
        setCategoria(categoria);
        setCusto(custo);
        setQuantidadeNoEstoque(quantidadeNoEstoque);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
        if (descricao == null || descricao.length() == 0) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        } else {
            this.descricao = descricao;
        }
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
        if (categoria == null || categoria.length() == 0) {
            throw new IllegalArgumentException("Categoria não pode ser nula ou vazia");
        } else {
            this.categoria = categoria;
        }
	}
	public String getCusto() {
		return custo;
	}
	public void setCusto(String custo) {
		this.custo = custo;
	}
	public String getQuantidadeNoEstoque() {
		return quantidadeNoEstoque;
	}
	public void setQuantidadeNoEstoque(String quantidadeNoEstoque) {
		this.quantidadeNoEstoque = quantidadeNoEstoque;
	}

}