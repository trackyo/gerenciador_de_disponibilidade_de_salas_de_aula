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
    private Instituicao instituicao;//faz a associação com instituições
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
    
    public void criaDiretPredio()//cria uma pasta para cada objeto predio
    {
        File Inst = new File("diretorio//inst//"+this.instituicao.getNome(), this.nome);//cocatena strings para poder criar o caminho
        boolean jk = Inst.mkdir();
    }
}
