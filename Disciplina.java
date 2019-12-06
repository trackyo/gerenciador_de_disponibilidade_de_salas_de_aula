package entities;

import java.io.File;
import java.util.ArrayList;

public class Disciplina 
{
    private String nome;
    private long codigo;
    private String abordagem_pedagogica;
    private ArrayList <Turma> turmas = new ArrayList<Turma>();

    public ArrayList<Turma> getTurmas() 
    {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) 
    {
        this.turmas = turmas;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public long getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(long codigo) 
    {
        this.codigo = codigo;
    }

    public String getAbordagem_pedagogica() 
    {
        return abordagem_pedagogica;
    }

    public void setAbordagem_pedagogica(String abordagem_pedagogica) 
    {
        this.abordagem_pedagogica = abordagem_pedagogica;
    }
    
    public void criaDiretDisciplina()
    {
        File Insti = new File("diretorio//disc", this.nome);
        boolean jk = Insti.mkdir();
    }
}
