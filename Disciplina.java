package Entities;

import java.util.ArrayList;
public class Disciplina 
{
    private String nome;
    private long codigo;
    private String abordagem_pedagogica;
    private ArrayList <Turma> turmas = new ArrayList<>();
    private String nivel;

    //metodo construtor
    public Disciplina() {
        this.setNome("NAO DEFINIDO");
        this.setAbordagem_pedagogica("ABORDAGEM PEDAGOGICA NAO DEFINIDA");
        this.setCodigo(0);
        this.setNivel("NIVEL ACADEMICO NAO DEFINIDO");
    }       
    //getters e setters
    public ArrayList<Turma> getTurmas() 
    {
        return this.turmas;
    }
    public void setTurmas(ArrayList<Turma> turmas) 
    {
        this.turmas = turmas;
    }

    public String getNome() 
    {
        return this.nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public long getCodigo() 
    {
        return this.codigo;
    }

    public void setCodigo(long codigo) 
    {
        this.codigo = codigo;
    }
    
    public String getAbordagem_pedagogica() 
    {
        return this.abordagem_pedagogica;
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
    
    //metodos personalizados
    public void informacoesDisciplina(){
        System.out.println("--------------------------------");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Abordagem Pedagogica: " + this.getAbordagem_pedagogica());
    }
    public void cadastrarNivel(String nv) {
    	System.out.println("Defina o nivel acadêmico da disciplina");
        if(nv.equalsIgnoreCase("graduação")|| nv.equalsIgnoreCase("graduacao")){
            this.setNivel("Graduação.");
    		
                }
    	if (nv.equalsIgnoreCase("extensão") || nv.equalsIgnoreCase("extensao")){
            this.setNivel("Extensão.");	
    	    }
    	  	
    	if (nv.equalsIgnoreCase("Lato Sensu")) {
            this.setNivel("Lato Sensu.");
    }
    	if(nv.equalsIgnoreCase("stricto sensu")) {
            this.setNivel("Stricto Sensu.");		
            }
    
    	else{
            System.out.println("Erro! Digite um Nível válido!");
            }
    	System.out.println("Disciplina cadastrada em: " + this.getNivel());
    	      
    }
    
    public void cadastrarNome(String name){
        this.setNome(name);
    }
    
    public void cadastrarCodigo(long code){
        this.setCodigo(code);
    }
    
    public void cadastrarAbordagem(String abordagem){
        this.setAbordagem_pedagogica(abordagem);
    }        
    public void cadastrarDisciplina(String name, long code, String abordagem, String level){
        this.cadastrarNome(name);
        this.cadastrarCodigo(code);
        this.cadastrarAbordagem(abordagem);
        this.cadastrarNivel(level);
        System.out.println("Sua disciplina foi cadastrada com as seguintes informacoes: ");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Abordagem Pedagogica: " + this.getAbordagem_pedagogica());
        System.out.println("Nivel Academico: " + this.getNivel());
    }  
}
