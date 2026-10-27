package com.qualidadeteste;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoService service = new ProdutoService();

        int opcao = 0;

        while (opcao != 3) {

            System.out.println("\n=== CADASTRO DE PRODUTOS ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            try {

                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    case 1:
                        System.out.println(
                            "Digite no formato CODIGO;NOME;PRECO:"
                        );

                        String entrada = scanner.nextLine();

                        try {
                            service.cadastrarProduto(entrada);
                            System.out.println(
                                "Produto cadastrado com sucesso!"
                            );

                        } catch (IllegalArgumentException e) {
                            System.out.println(
                                "Erro: " + e.getMessage()
                            );
                        }

                        break;

                    case 2:
                        System.out.println();
                        System.out.println(service.listarProdutos());
                        break;

                    case 3:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida.");
            }
        }

        scanner.close();
    }
}
