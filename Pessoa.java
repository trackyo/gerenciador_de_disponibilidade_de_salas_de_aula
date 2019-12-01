package service;

import java.util.Scanner;

public class Pessoa 
{
    private String nome;
    private long matricula;
    
/*    void cadastrarnome() 
    {
	Scanner cn = new Scanner(System.in);
	System.out.printf("informe o nome ");
	nome = cn.nextLine();
    }
    
    void cadastrarmatricula() 
    {
	Scanner cn = new Scanner(System.in);
	System.out.printf("informe a matricula ");
	matricula = cn.nextLong();
    }*/

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public Long getMatricula() 
    {
        return matricula;
    }

    public void setMatricula(long matricula) 
    {
        this.matricula = matricula;
    }
}
