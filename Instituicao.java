package entities;

import java.util.ArrayList;
import service.Aluno;
import service.Professor;

public class Instituicao 
{
    private String nome;
    private Boolean integral;
    private Boolean noturno;
    private ArrayList <Predio> predio = new ArrayList<Predio>();
    private ArrayList <Aluno> aluno = new ArrayList<Aluno>();
    private ArrayList <Professor> professor = new ArrayList<Professor>();
    private ArrayList <Disciplina> disciplina = new ArrayList<Disciplina>();

    public ArrayList<Aluno> getAluno() 
    {
        return aluno;
    }

    public void setAluno(ArrayList<Aluno> aluno) 
    {
        this.aluno = aluno;
    }

    public ArrayList<Professor> getProfessor() 
    {
        return professor;
    }

    public void setProfessor(ArrayList<Professor> professor) 
    {
        this.professor = professor;
    }

    public ArrayList<Disciplina> getDisciplina() 
    {
        return disciplina;
    }

    public void setDisciplina(ArrayList<Disciplina> disciplina) 
    {
        this.disciplina = disciplina;
    }
    

    public ArrayList<Predio> getPredio() 
    {
        return predio;
    }

    public void setPredio(ArrayList<Predio> predio) 
    {
        this.predio = predio;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public Boolean getIntegral() 
    {
        return integral;
    }

    public void setIntegral(Boolean integral) 
    {
        this.integral = integral;
    }

    public Boolean getNoturno() 
    {
        return noturno;
    }

    public void setNoturno(Boolean noturno) 
    {
        this.noturno = noturno;
    }
    
}
