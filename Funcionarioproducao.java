public class Funcionarioproducao extends Colaborador {

    private final double valorPorPeca;
    private final int quantidadeProduzida;

    public Funcionarioproducao(int matricula, String nome, double valorPorPeca, int quantidadeProduzida) {
        super(matricula, nome);
        this.valorPorPeca = valorPorPeca;
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public double calcularBonus() {
        return valorPorPeca * quantidadeProduzida;
    }

    @Override
    public double calcularSalarioFinal() {
        return SALARIO_BASE + calcularBonus();
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Fixo: " + SALARIO_BASE);
        System.out.println("Produtividade: " + calcularBonus());
        System.out.println("Salário final: " + calcularSalarioFinal());
    }
}