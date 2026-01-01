import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static List<Produto> produtos = new ArrayList<>();

    static void main() {
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Editar produto");
            System.out.println("4 - Deletar produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = teclado.nextInt();
            teclado.nextLine();//limpa buffer

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    editar();
                    break;
                case 4:
                    deletar();
                    break;
                case 0:
                    sair();
                    break;
                default:
                    System.out.println("Erro, escolha uma opção válida!");
            }

        } while (opcao != 0);
    }

    static void cadastrar() {
        System.out.println("Nome do Produto: ");
        String nome = teclado.nextLine();

        System.out.println("Preço do Produto: ");
        double preco = teclado.nextDouble();

        produtos.add(new Produto(nome, preco));
        System.out.println("Produto Cadastrado com sucesso!");
    }

    static void listar() {
        System.out.println("Listando");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrato.");
            return;
        }
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            System.out.println(i + " - " + p.nome + " | R$" + p.preco);
        }
    }

    static void editar() {
        System.out.println("Editando");
        listar();

        System.out.println("Digite o índice do produto: ");
        int i = teclado.nextInt();
        teclado.nextLine();

        if (i >= 0 && i < produtos.size()) {
            System.out.println("Novo nome: ");
            produtos.get(i).nome = teclado.nextLine();

            System.out.println("Novo preço: ");
            produtos.get(i).preco = teclado.nextDouble();

            System.out.println("Produto atualizado");
        } else {
            System.out.println("ìndice inválido");
        }

    }

    static void deletar() {
        System.out.println("Deletando");
    }

    static void sair() {
        System.out.println("Saindo");
    }
}