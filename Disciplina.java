package entities;

import java.util.ArrayList;

public class Disciplina 
{
    private String nome;
    private long codigo;
    private String abordagem_pedagogica;
    private ArrayList <Turma> turma = new ArrayList<Turma>();

    public ArrayList<Turma> getTurma() 
    {
        return turma;
    }

    public void setTurma(ArrayList<Turma> turma) 
    {
        this.turma = turma;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public long getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(long codigo) 
    {
        this.codigo = codigo;
    }

    public String getAbordagem_pedagogica() 
    {
        return abordagem_pedagogica;
    }

    public void setAbordagem_pedagogica(String abordagem_pedagogica) 
    {
        this.abordagem_pedagogica = abordagem_pedagogica;
    }
}
