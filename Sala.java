package entities;

import java.util.ArrayList;

public class Sala 
{
    private int idSala;
    private int capacidade;
    private boolean ar;
    private boolean projetor;
    private boolean tv;
    private Predio predio;
    private ArrayList <Ocupa> ocupa = new ArrayList<Ocupa>();
    private ArrayList <Turma> turma = new ArrayList<Turma>();
    
    public Predio getPredio() 
    {
        return predio;
    }

    public void setPredio(Predio predio) 
    {
        this.predio = predio;
    }
   
    public ArrayList<Ocupa> getOcupa() 
    {
        return ocupa;
    }

    public void setOcupa(ArrayList<Ocupa> ocupa) 
    {
        this.ocupa = ocupa;
    }

    public ArrayList<Turma> getTurma() 
    {
        return turma;
    }

    public void setTurma(ArrayList<Turma> turma) 
    {
        this.turma = turma;
    }

    public int getIdSala() 
    {
        return idSala;
    }

    public void setIdSala(int idSala) 
    {
        this.idSala = idSala;
    }

    public int getCapacidade() 
    {
        return capacidade;
    }

    public void setCapacidade(int capacidade) 
    {
        this.capacidade = capacidade;
    }

    public boolean isAr() 
    {
        return ar;
    }

    public void setAr(boolean ar) 
    {
        this.ar = ar;
    }

    public boolean isProjetor() 
    {
        return projetor;
    }

    public void setProjetor(boolean projetor) 
    {
        this.projetor = projetor;
    }

    public boolean isTv() 
    {
        return tv;
    }

    public void setTv(boolean tv) 
    {
        this.tv = tv;
    }
}
