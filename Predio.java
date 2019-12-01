package entities;

import java.util.ArrayList;

public class Predio 
{
    private int qtd_salas;
    private String nome;
    private Instituicao instituicao;
    private ArrayList <Sala> sala = new ArrayList<Sala>();
    
    public Instituicao getInstituicao() 
    {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) 
    {
        this.instituicao = instituicao;
    }
    

    public ArrayList<Sala> getSala() 
    {
        return sala;
    }

    public void setSala(ArrayList<Sala> sala) 
    {
        this.sala = sala;
    }

    public int getQtd_salas() 
    {
        return qtd_salas;
    }

    public void setQtd_salas(int qtd_salas) 
    {
        this.qtd_salas = qtd_salas;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
}
