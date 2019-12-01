package entities;

import java.util.Date;

public class Ocupa 
{
    private Date dia_hora;
    private Turma turma;
    private Sala sala;

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

    public Date getDia_hora() 
    {
        return dia_hora;
    }

    public void setDia_hora(Date dia_hora) 
    {
        this.dia_hora = dia_hora;
    }
}
