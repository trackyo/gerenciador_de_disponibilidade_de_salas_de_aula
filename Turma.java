package entities;

import java.util.ArrayList;
import service.Aluno;
import service.Professor;

public class Turma 
{
    private int numAlunos;
    private String horario;
    private Disciplina disciplina;
    private ArrayList <Aluno> aluno = new ArrayList<Aluno>();
    private ArrayList <Professor> professor =  new ArrayList<Professor>();
    
    public Disciplina getDisciplina() 
    {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) 
    {
        this.disciplina = disciplina;
    }
    
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

    public int getNumAlunos() 
    {
        return numAlunos;
    }

    public void setNumAlunos(int numAlunos) 
    {
        this.numAlunos = numAlunos;
    }

    public String getHorario() 
    {
        return horario;
    }

    public void setHorario(String horario) 
    {
        this.horario = horario;
    }
}
