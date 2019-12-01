package service;

public class Professor extends Pessoa
{
    private String especializacao;
    private float salario;

    public String getEspecializacao() 
    {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) 
    {
        this.especializacao = especializacao;
    }

    public Float getSalario() 
    {
        return salario;
    }

    public void setSalario(float salario) 
    {
        this.salario = salario;
    }
}
