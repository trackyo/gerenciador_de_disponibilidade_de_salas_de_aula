package service;

import entities.Turma;
import java.io.File;
import java.util.ArrayList;


public class Aluno extends Pessoa 
{
    private String curso;
    private ArrayList <Turma> turmas = new ArrayList<Turma>();

    public ArrayList<Turma> getTurmas() 
    {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) 
    {
        this.turmas = turmas;
    }

    public String getCurso() 
    {
        return curso;
    }

    public void setCurso(String curso) 
    {
        this.curso = curso;
    }
    
    public void criaDiretAluno()
    {
        File Insti = new File("diretorio//inst//"+this.Inst.getNome()+"//pessoa", "aluno");
        boolean jk = Insti.mkdir();
        File Al = new File(Insti, this.getNome());
        boolean pf = Al.mkdir();
    }
}
