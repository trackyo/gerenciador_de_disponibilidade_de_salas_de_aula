package entities;

import java.util.ArrayList;
import java.util.Scanner;
import service.Aluno;
import service.Professor;

public class Main 
{
    public static void main(String[] args)
    {        
        //ArrayList<ArrayList> lista = new ArrayList<ArrayList>();    
    }
    
    public void cadastroInst()
    {
        Instituicao Inst = new Instituicao();
        Scanner cn = new Scanner(System.in);
	System.out.printf("informe o nome ");
        Inst.setNome(cn.nextLine());
        System.out.printf("Possue funfionamento integral?(true/false)");
        Inst.setIntegral(cn.nextBoolean());
        System.out.printf("Possue funfionamento Noturno?(true/false)");
        Inst.setNoturno(cn.nextBoolean());
    }

    public void cadastroPredioSalas()
    {
        int n;
        Predio Pred = new Predio();
        Scanner cn = new Scanner(System.in);
        System.out.printf("informe o nome ");
        Pred.setNome(cn.nextLine());
        System.out.printf("informe o numero de salas ");
        n = cn.nextInt();
        Pred.setQtd_salas(n);
        //na proxima tentar colocar tudo im inst
        for(int i=0; i<n;i++)
        {
            Sala S = new Sala();
            S.setIdSala(cn.nextInt());
            S.setCapacidade(cn.nextInt());
            S.setPredio(Pred);
            S.setAr(cn.nextBoolean());
            S
        }
    }
    
    public void cadastroDiciplina()
    {
        Disciplina D = new Disciplina();
    }
    
    public void cadastroProfessor()
    {
        Professor P = new Professor();
    }
    
    public void cadastroAluno()
    {
        Aluno A = new Aluno();
    }
    
    public void cadastroTurma()
    {
        Turma T = new Turma();
    }
}
