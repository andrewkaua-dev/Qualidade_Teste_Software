package com.qualidadeteste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoServiceTest {

    private ProdutoService service;

    @BeforeEach
    public void iniciar() {
        service = new ProdutoService();
    }

    @Test
    public void deveCadastrarProduto() {

        service.cadastrarProduto("1;Tv Samsung;1250");

        assertEquals(1, service.getProdutos().size());
        assertEquals(1, service.getProdutos().get(0).getCodigo());
        assertEquals("Tv Samsung", service.getProdutos().get(0).getNome());
        assertEquals(1250.0, service.getProdutos().get(0).getPreco());
    }

    @Test
    public void naoDeveCadastrarCodigoRepetido() {

        service.cadastrarProduto("1;Tv Samsung;1250");

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarProduto("1;Notebook;3000");
        });
    }

    @Test
    public void naoDeveCadastrarNomeVazio() {

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarProduto("1;;1250");
        });
    }

    @Test
    public void naoDeveCadastrarPrecoZero() {

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarProduto("1;Tv Samsung;0");
        });
    }

    @Test
    public void naoDeveCadastrarPrecoNegativo() {

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarProduto("1;Tv Samsung;-100");
        });
    }

    @Test
    public void naoDeveAceitarFormatoInvalido() {

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarProduto("1;Tv Samsung");
        });
    }

    @Test
    public void deveMostrarMensagemQuandoNaoTemProdutos() {

        String resultado = service.listarProdutos();

        assertEquals(
            "Nenhum produto cadastrado.",
            resultado
        );
    }

    @Test
    public void deveListarProdutoCorretamente() {

        service.cadastrarProduto("1;Tv Samsung;1250");

        String resultado = service.listarProdutos();

        assertTrue(resultado.contains("Código: 1"));
        assertTrue(resultado.contains("Nome Produto: Tv Samsung"));
        assertTrue(resultado.contains("Preço: R$ 1250,00"));
    }

    @Test
    public void deveCadastrarMaisDeUmProduto() {

        service.cadastrarProduto("1;Tv Samsung;1250");
        service.cadastrarProduto("2;Som;500");

        assertEquals(2, service.getProdutos().size());
    }
}