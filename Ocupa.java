package entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ocupa 
{
    private String dia;//informa o dia da semana em que a ocupação ocorre
    private int horario;
    private Turma turma;
    private Sala sala;

    public String getDia() 
    {
        return dia;
    }

    public void setDia(String dia) 
    {
        this.dia = dia;
    }

    public int getHorario() 
    {
        return horario;
    }

    public void setHorario(int horario) 
    {
        this.horario = horario;
    }

    public Turma getTurma() 
    {
        return turma;
    }

    public void setTurma(Turma turma) 
    {
        this.turma = turma;
    }

    public Sala getSala() 
    {
        return sala;
    }

    public void setSala(Sala sala) 
    {
        this.sala = sala;
    }
    
    public void criaDiretOcupaSala()
    {
        File Insti = new File("diretorio//inst//"+this.sala.getPredio().getInstituicao().getNome()+"//"+this.sala.getPredio().getNome()+"//"+Integer.toString(this.sala.getIdSala()), "ocupa");
        boolean jk = Insti.mkdir();
    }
    
    public void criaDiretOcupaTurma()
    {
        File Insti = new File("diretorio//disc//"+this.turma.getDisciplina().getNome()+"//"+this.turma.getNome(), "ocupa");
        boolean jk = Insti.mkdir();
    }
    
    public String salvarLisSala()
    {
            
        try 
        {
        FileWriter lt = new FileWriter("diretorio//inst//"+this.sala.getPredio().getInstituicao().getNome()+"//"+this.sala.getPredio().getNome()+"//"+Integer.toString(this.sala.getIdSala())+"//ocupa//lista.txt",true);
        PrintWriter plt = new PrintWriter(lt);
        plt.println(this.turma.getDisciplina().getNome()+"//"+this.turma.getNome());
                
        plt.flush();
        plt.close();
        lt.close();
        }
            
        catch (IOException ex) 
        {
            Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Lista salva";
    }
    
    public String salvarLisTurma()
    {
            
        try 
        {
        FileWriter lt = new FileWriter("diretorio//disc//"+this.turma.getDisciplina().getNome()+"//"+this.turma.getNome()+"//ocupa//lista.txt",true);
        PrintWriter plt = new PrintWriter(lt);
        plt.println(this.sala.getPredio().getInstituicao().getNome()+"//"+this.sala.getPredio().getNome()+"//"+Integer.toString(this.sala.getIdSala()));
                
        plt.flush();
        plt.close();
        lt.close();
        }
            
        catch (IOException ex) 
        {
            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Lista salva";
    }
    
}
