package com.fatec.sigvs.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvs.model.IProdutoRepository;
import com.fatec.sigvs.model.Produto;

@SpringBootTest
public class Req01CadastrarProduto {
    @Autowired
    IProdutoRepository repository;
    @Test
    public void ct01_cadastrarProdutoComSucesso() {
        //Dado que as informações de produtos são validas
        Produto produto1 = new Produto("eletrobomba 110v", "máquina de lavar", "22.30", "10");
        //quando confirmo o cadastro
		repository.save(produto1);
        //então o produto fica disponivel para consulta
		assertEquals(1, repository.count());
    }

    @Test
    public void ct02_cadastrarProduto_DescricaoInvalida() {
        //Dado que as informações de produtos são invalidas
        try{
            //quando confirma o cadastro
            Produto produto1 = new Produto("","máquina de lavar", "22.30", "10");
        } catch(IllegalArgumentException e) {
            //então retorna uma mensagem descrição invalida
		    assertEquals("Descrição não pode ser nula ou vazia", e.getMessage());
        }
    }

    @Test
    public void ct03_cadastrarProduto_DescricaoInvalida() {
        //Dado que as informações de produtos são invalidas
        try{
            //quando confirma o cadastro
            Produto produto1 = new Produto(null,"máquina de lavar", "22.30", "10");
        } catch(IllegalArgumentException e) {
            //então retorna uma mensagem descrição invalida
		    assertEquals("Descrição não pode ser nula ou vazia", e.getMessage());
        }
    }

    @Test
    public void ct04_cadastrarProduto_CategoriaInvalida() {
        //Dado que as informações de produtos são invalidas
        try{
            //quando confirma o cadastro
            Produto produto1 = new Produto("eletrobomba 110v",null, "22.30", "10");
        } catch(IllegalArgumentException e) {
            //então retorna uma mensagem descrição invalida
		    assertEquals("Categoria não pode ser nula ou vazia", e.getMessage());
        }
    }
}
