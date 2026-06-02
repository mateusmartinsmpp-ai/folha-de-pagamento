public abstract class Colaborador {

    protected int matricula;
    protected String nome;
    protected static final double SALARIO_BASE = 2000.0;

    public Colaborador(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public abstract double calcularSalarioFinal();

    public abstract void exibirDados();

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }
}