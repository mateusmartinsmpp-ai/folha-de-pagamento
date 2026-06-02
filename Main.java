import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Colaborador> colaboradores = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE FOLHA DE PAGAMENTO ===");
            System.out.println("1 - Cadastrar Funcionário Padrão");
            System.out.println("2 - Cadastrar Funcionário Comissionado");
            System.out.println("3 - Cadastrar Funcionário de Produção");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> cadastrarPadrao();
                case 2 -> cadastrarComissionado();
                case 3 -> cadastrarProducao();
                case 4 -> gerarFolha();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // ─── OPÇÃO 1: Funcionário Padrão ─────────────────────────────────────────
    static void cadastrarPadrao() {
        System.out.println("\n--- Cadastro: Funcionário Padrão ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        int matricula = lerInteiroPositivo("Matrícula: ");

        colaboradores.add(new Funcionariopadrao(matricula, nome));
        System.out.println("✔ Funcionário padrão cadastrado com sucesso!");
    }

    // ─── OPÇÃO 2: Funcionário Comissionado ───────────────────────────────────
    static void cadastrarComissionado() {
        System.out.println("\n--- Cadastro: Funcionário Comissionado ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        int matricula       = lerInteiroPositivo("Matrícula: ");
        double vendas       = lerDoublePositivo("Informe valor das vendas: ");
        double percentual   = lerDoublePositivo("Informe comissão percentual: ");

        colaboradores.add(new Funcionariocomissionado(matricula, nome, vendas, percentual));
        System.out.println("✔ Funcionário comissionado cadastrado com sucesso!");
    }

    // ─── OPÇÃO 3: Funcionário de Produção ────────────────────────────────────
    static void cadastrarProducao() {
        System.out.println("\n--- Cadastro: Funcionário de Produção ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        int matricula       = lerInteiroPositivo("Matrícula: ");
        double valorPorPeca = lerDoublePositivo("Informe valor por peça: ");
        int quantidade      = lerInteiroPositivo("Informe quantidade produzida: ");

        colaboradores.add(new Funcionarioproducao(matricula, nome, valorPorPeca, quantidade));
        System.out.println("✔ Funcionário de produção cadastrado com sucesso!");
    }

    // ─── OPÇÃO 4: Gerar Folha ────────────────────────────────────────────────
    static void gerarFolha() {
        System.out.println("\n=== FOLHA DE PAGAMENTO ===");

        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        System.out.println("Total de pessoas cadastradas: " + colaboradores.size());
        System.out.println();

        for (Colaborador c : colaboradores) {
            c.exibirDados();
            System.out.println("---------------------------");
        }
    }

    // ─── VALIDAÇÕES ──────────────────────────────────────────────────────────
    static int lerInteiroPositivo(String mensagem) {
        int valor;
        do {
            System.out.print(mensagem);
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                System.out.print(mensagem);
                scanner.next();
            }
            valor = scanner.nextInt();
            scanner.nextLine();
            if (valor < 0) {
                System.out.println("Valor não pode ser negativo. Tente novamente.");
            }
        } while (valor < 0);
        return valor;
    }

    static double lerDoublePositivo(String mensagem) {
        double valor;
        do {
            System.out.print(mensagem);
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Digite um número válido.");
                System.out.print(mensagem);
                scanner.next();
            }
            valor = scanner.nextDouble();
            scanner.nextLine();
            if (valor < 0) {
                System.out.println("Valor não pode ser negativo. Tente novamente.");
            }
        } while (valor < 0);
        return valor;
    }
}