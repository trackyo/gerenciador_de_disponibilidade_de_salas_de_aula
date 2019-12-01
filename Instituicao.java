package entities;

import java.util.ArrayList;
import service.Aluno;
import service.Professor;

public class Instituicao 
{
    private String nome;
    private Boolean integral;
    private Boolean noturno;
    private ArrayList <Predio> predios = new ArrayList<Predio>();
    private ArrayList <Aluno> alunos = new ArrayList<Aluno>();
    private ArrayList <Professor> professores = new ArrayList<Professor>();
    private ArrayList <Disciplina> disciplinas = new ArrayList<Disciplina>();

    public ArrayList<Predio> getPredios() 
    {
        return predios;
    }

    public void setPredios(ArrayList<Predio> predios) 
    {
        this.predios = predios;
    }

    public ArrayList<Aluno> getAlunos() 
    {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) 
    {
        this.alunos = alunos;
    }

    public ArrayList<Professor> getProfessores() 
    {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) 
    {
        this.professores = professores;
    }

    public ArrayList<Disciplina> getDisciplinas() 
    {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) 
    {
        this.disciplinas = disciplinas;
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
