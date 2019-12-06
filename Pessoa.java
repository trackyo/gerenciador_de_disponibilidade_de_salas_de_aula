package service;

import entities.Instituicao;
import java.io.File;
import java.util.Scanner;

public class Pessoa 
{
    Instituicao Inst;
    private String nome;
    private long matricula;


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

    public Long getMatricula() 
    {
        return matricula;
    }

    public void setMatricula(long matricula) 
    {
        this.matricula = matricula;
    }
    
    public void criaDiretPes()//cria uma pasta pessoa dentro de diretorio
    {
        File Insti = new File("diretorio//inst//"+this.Inst.getNome(), "pessoa");
        boolean jk = Insti.mkdir();
    }
    
    public void criaDiretAluno()//cria uma pasta aluno dentro de pessoa
    {
        File Insti = new File("diretorio//inst//"+this.Inst.getNome()+"//pessoa", "aluno");
        boolean jk = Insti.mkdir();
    }
    
    public void criaDiretProf()//cria uma pasta prof dentro de pessoa
    {
        File Insti = new File("diretorio//inst//"+this.Inst.getNome()+"//pessoa", "professor");
        boolean jk = Insti.mkdir();
    }
}
