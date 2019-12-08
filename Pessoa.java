package service;

import entities.Instituicao;
import java.io.File;

public class Pessoa 
{
    Instituicao Inst;
    private String nome;
    private int matricula;


    public Instituicao getInst() 
    {
        return Inst;
    }

    public void setInst(Instituicao Inst) 
    {
        this.Inst = Inst;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getMatricula() 
    {
        return matricula;
    }

    public void setMatricula(int matricula) 
    {
        this.matricula = matricula;
    }
    
    public void criaDiretPes()//cria uma pasta pessoa dentro de diretorio
    {
        File Insti = new File("diretorio//inst//"+this.Inst.getNome(), "pessoa");
        boolean jk = Insti.mkdir();
    }   
    
}
