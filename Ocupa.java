package entities;

import java.util.Date;

public class Ocupa 
{
    private String dia;
    private String horario;
    private Turma turma;
    private Sala sala;

    public String getDia() 
    {
        return dia;
    }

    public void setDia(String dia) 
    {
        this.dia = dia;
    }

    public String getHorario() 
    {
        return horario;
    }

    public void setHorario(String horario) 
    {
        this.horario = horario;
    }

    public Turma getTurma() 
    {
        return turma;
    }

    public void setTurma(Turma turma) 
    {
        this.turma = turma;
    }

    public Sala getSala() 
    {
        return sala;
    }

    public void setSala(Sala sala) 
    {
        this.sala = sala;
    }

}
