public class Funcionariopadrao extends Colaborador {

    public Funcionariopadrao(int matricula, String nome) {
        super(matricula, nome);
    }

    @Override
    public double calcularSalarioFinal() {
        return SALARIO_BASE;
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Fixo: " + SALARIO_BASE);
        System.out.println("Extras: 0.0");
        System.out.println("Salário final: " + calcularSalarioFinal());
    }
}