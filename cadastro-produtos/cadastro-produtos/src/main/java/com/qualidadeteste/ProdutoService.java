package com.qualidadeteste;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(String entrada) {

        // Verifica se a entrada está vazia
        if (entrada == null || entrada.trim().isEmpty()) {
            throw new IllegalArgumentException("Entrada inválida.");
        }

        // Separa os dados pelo ;
        String[] dados = entrada.split(";");

        if (dados.length != 3) {
            throw new IllegalArgumentException(
                "Formato inválido. Use: CODIGO;NOME;PRECO"
            );
        }

        int codigo;
        double preco;

        try {
            codigo = Integer.parseInt(dados[0].trim());

            preco = Double.parseDouble(
                dados[2].trim().replace(",", ".")
            );

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Código ou preço inválido."
            );
        }

        String nome = dados[1].trim();

        // Nome não pode estar vazio
        if (nome.isEmpty()) {
            throw new IllegalArgumentException(
                "Nome do produto não pode estar vazio."
            );
        }

        // Preço deve ser maior que zero
        if (preco <= 0) {
            throw new IllegalArgumentException(
                "Preço do produto deve ser maior que zero."
            );
        }

        // Verifica se já existe produto com o mesmo código
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                throw new IllegalArgumentException(
                    "Já existe um produto com esse código."
                );
            }
        }

        // Salva o produto na memória
        produtos.add(new Produto(codigo, nome, preco));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String listarProdutos() {

        if (produtos.isEmpty()) {
            return "Nenhum produto cadastrado.";
        }

        StringBuilder resultado = new StringBuilder();

        for (Produto produto : produtos) {

            resultado.append("Código: ")
                    .append(produto.getCodigo())
                    .append("\n");

            resultado.append("Nome Produto: ")
                    .append(produto.getNome())
                    .append("\n");

            resultado.append(String.format(
                "Preço: R$ %.2f%n",
                produto.getPreco()
            ));

            resultado.append("\n");
        }

        return resultado.toString().trim();
    }
}
