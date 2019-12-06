package service;

import entities.Disciplina;
import entities.Turma;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Professor extends Pessoa
{
    private String especializacao;
    private float salario;
    private Turma turma;

    public Turma getTurma() 
    {
        return turma;
    }

    public void setTurma(Turma turma) 
    {
        this.turma = turma;
    }

    public String getEspecializacao() 
    {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) 
    {
        this.especializacao = especializacao;
    }

    public Float getSalario() 
    {
        return salario;
    }

    public void setSalario(float salario) 
    {
        this.salario = salario;
    }
    
    public void criaDiretProf()
    {
        File Insti = new File("diretorio//inst//"+this.Inst.getNome()+"//pessoa", "professor");
        boolean jk = Insti.mkdir();
        File Prof = new File(Insti, this.getNome());
        boolean pf = Prof.mkdir();
    }
    
    public String salvarLisProf()//cria um arquivo .txt com o nome de todos os objhetos para facilitar a busca em pastas
    {
            
        try 
        {
            FileWriter lt = new FileWriter("diretorio//inst//"+this.Inst.getNome()+"//pessoa//professor//lista.txt",true);
            PrintWriter plt = new PrintWriter(lt);
            plt.println(this.getNome());

            plt.flush();
            plt.close();//fecha a escrita
            lt.close();//fecha o arquivo
        }
            
        catch (IOException ex) 
        {
            Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Lista salva";
    }
}
