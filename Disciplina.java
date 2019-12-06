
package entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Disciplina 
{
    private String nome;
    private long codigo;
    private String abordagem_pedagogica;
    private ArrayList <Turma> turmas = new ArrayList<Turma>();
    private String nivel;
    
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
    
    public void setNivel(String nv) {
    	this.nivel = nv;	
    } 
    public String getNivel() {
    	return this.nivel;
    }
    public void escolherNivel(String nv) {
    	System.out.println("Defina o nivel acadêmico da disciplina");
    	  	if(nv.equalsIgnoreCase("graduação")|| nv.equalsIgnoreCase("graduacao")) {
    		setNivel("Graduação.");
    		
    	}
    	  	if (nv.equalsIgnoreCase("extensão") || nv.equalsIgnoreCase("extensao")) {
    			setNivel("Extensão.");
    	  	
    	  	}
    	  	
    	  	if (nv.equalsIgnoreCase("Lato Sensu")) {
    	  		setNivel("Lato Sensu.");
    }
    	  	if(nv.equalsIgnoreCase("stricto sensu")) {
        		setNivel("Stricto Sensu.");
        		
        	}
    
    	  	else {
    	  		System.out.println("Erro! Digite um Nível válido!");
    	  	}
    	  	System.out.println("O nivel da disciplina é " + nivel );
    	      
    }
    
    public void criaDiretDisciplina()
    {
        File Insti = new File("diretorio//disc", this.nome);
        boolean jk = Insti.mkdir();
    }
    
    public String salvarLis()//cria um arquivo .txt com o nome de todos os objetos para facilitar a busca em pastas
    {
            
        try 
        {
            FileWriter lt = new FileWriter("diretorio//disc//lista.txt",true);
            PrintWriter plt = new PrintWriter(lt);
            plt.println(this.nome);

            plt.flush();
            plt.close();//fecha a escrita
            lt.close();//fecha o arquivo
        }
            
        catch (IOException ex) 
        {
            Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Lista salva";
    }
}
