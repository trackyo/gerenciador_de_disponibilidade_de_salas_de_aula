package entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.Aluno;
import service.Professor;

public class Instituicao 
{
    private String nome;
    private boolean integral;
    private boolean noturno;
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

    public boolean getIntegral() 
    {
        return integral;
    }

    public void setIntegral(boolean integral) 
    {
        this.integral = integral;
    }

    public boolean getNoturno() 
    {
        return noturno;
    }

    public void setNoturno(boolean noturno) 
    {
        this.noturno = noturno;
    }
    
    public void criaDiretInst()//cria uma pasta para todo novo objeto instituição drento da pasta diretório
    {
        File Inst = new File("diretorio//inst", this.nome);
        boolean jk = Inst.mkdir();
    }
    
    public String salvarLis()//cria um arquivo .txt com o nome de todos os objhetos para facilitar a busca em pastas
    {
            
        try 
        {
            FileWriter lt = new FileWriter("diretorio//inst//lista.txt",true);
            PrintWriter plt = new PrintWriter(lt);
            plt.println(this.nome);
                
            plt.flush();
            plt.close();//fecha a escrita
            lt.close();//fecha o arquivo
            }
            
            catch (IOException ex) 
            {
                Logger.getLogger(Instituicao.class.getName()).log(Level.SEVERE, null, ex);
            }

            return "Lista salva";
        }
    
}
