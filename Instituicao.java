package entities;

public class Instituicao 
{
    private String nome;
    private Boolean integral;
    private Boolean noturno;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getIntegral() {
        return integral;
    }

    public void setIntegral(Boolean integral) {
        this.integral = integral;
    }

    public Boolean getNoturno() {
        return noturno;
    }

    public void setNoturno(Boolean noturno) {
        this.noturno = noturno;
    }
    
}
