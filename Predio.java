package entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Predio 
{
    private int qtd_salas;
    private String nome;
    private Instituicao instituicao;
    private ArrayList <Sala> salas = new ArrayList<Sala>();
    
    public Instituicao getInstituicao() 
    {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) 
    {
        this.instituicao = instituicao;
    }
    

    public ArrayList<Sala> getSala() 
    {
        return salas;
    }

    public void setSala(ArrayList<Sala> sala) 
    {
        this.salas = sala;
    }

    public int getQtd_salas() 
    {
        return qtd_salas;
    }

    public void setQtd_salas(int qtd_salas) 
    {
        this.qtd_salas = qtd_salas;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public void criaDiretPredio()
    {
        File Inst = new File("diretorio//inst//"+this.instituicao.getNome(), this.nome);
        boolean jk = Inst.mkdir();
        File arquivo = new File(Inst, this.nome+".txt");
        try 
        {
            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Predio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
