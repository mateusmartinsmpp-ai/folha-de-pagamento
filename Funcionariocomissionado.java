public class Funcionariocomissionado extends Colaborador {

    private double totalVendas;
    private double percentualComissao;

    public Funcionariocomissionado(int matricula, String nome, double totalVendas, double percentualComissao) {
        super(matricula, nome);
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }

    public double calcularComissao() {
        return totalVendas * percentualComissao / 100;
    }

    @Override
    public double calcularSalarioFinal() {
        return SALARIO_BASE + calcularComissao();
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Fixo: " + SALARIO_BASE);
        System.out.println("Comissão: " + calcularComissao());
        System.out.println("Salário final: " + calcularSalarioFinal());
    }
}