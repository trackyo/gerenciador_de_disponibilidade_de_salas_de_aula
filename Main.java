package entities;

import java.util.ArrayList;
import java.util.Scanner;
import service.Aluno;
import service.Professor;

public class Main 
{
    ArrayList<Predio> PredLista;
    ArrayList<Professor> ProfLista;
    ArrayList<Ocupa> OcupaAux;
    
    ArrayList<Instituicao> InstAux;
    ArrayList<Disciplina> DiscAux;
    ArrayList<Turma> TurmaAux;
    ArrayList<Sala> SalaAux;
    ArrayList<Aluno> AlunoAux;
    
    ArrayList<Instituicao> InstFim;
    ArrayList<Disciplina> DiscFim;
    ArrayList<Turma> TurmaFim;
    ArrayList<Sala> SalaFim;
    ArrayList<Aluno> alunoFim;
    
    public Main()
    {   
        PredLista = new ArrayList();
        ProfLista = new ArrayList();
        
        InstAux = new ArrayList();
        DiscAux = new ArrayList();
        TurmaAux = new ArrayList();
        SalaAux = new ArrayList();
        AlunoAux = new ArrayList();
        
        InstFim = new ArrayList();
        DiscFim = new ArrayList();
        TurmaFim = new ArrayList();
        SalaFim = new ArrayList();
        alunoFim = new ArrayList();
        
        cadastroInst();
        
    }
    
    public static void main(String[] args)
    {      
        //ArrayList<ArrayList> lista = new ArrayList<ArrayList>(); 
        new Main();
    }
    
    void cadastroInst()
    {
        Instituicao Inst = new Instituicao();
        Scanner cn = new Scanner(System.in);
	System.out.printf("informe o nome ");
        Inst.setNome(cn.nextLine());
        System.out.printf("Possue funfionamento integral?(true/false)");
        Inst.setIntegral(cn.nextBoolean());
        System.out.printf("Possue funfionamento Noturno?(true/false)");
        Inst.setNoturno(cn.nextBoolean());
        InstAux.add(Inst);
    }
    
    /*void InstFinal(String tipo,Object ObjetoAux)
    {
        Insti
        
        for(int i=0; i<InstAux.size();i++)
        {
            if()
        }
    }*/

    void cadastroPredioSalas(ArrayList<Instituicao> InstAux)
    {
        int n;
        String Inst;
        Predio Pred = new Predio();
        Scanner cn = new Scanner(System.in);
        System.out.printf("informe o nome da Instituicao ");
        Inst = cn.nextLine();
        for(int i=0; i<InstAux.size();i++)
        {
            if(Inst.equals(InstAux.get(i).getNome()))
            {
                Pred.setInstituicao(InstAux.get(i));
                break;
            }
        }
        System.out.printf("informe o nome do prédio ");
        Pred.setNome(cn.nextLine());
        System.out.printf("informe o numero de salas ");
        n = cn.nextInt();
        Pred.setQtd_salas(n);

        for(int i=0; i<n;i++)
        {
            Sala S = new Sala();
            S.setPredio(Pred);
            System.out.printf("informe o número de salas ");
            S.setIdSala(cn.nextInt());
            System.out.printf("informe a capacidade ");
            S.setCapacidade(cn.nextInt());
            System.out.printf("informe se tem arcondicionado (true/false)");
            S.setAr(cn.nextBoolean());
            System.out.printf("informe se tem projetor (true/false)");
            S.setProjetor(cn.nextBoolean());
            System.out.printf("informe se tem TV (true/false)");
            S.setTv(cn.nextBoolean());
        }
        
        //InstFinal("predio", Pred);
        PredLista.add(Pred);
    }
    
    void cadastroDiciplina()
    {
        Disciplina D = new Disciplina();
        Scanner cn = new Scanner(System.in);
        System.out.printf("informe o nome da disciplina ");
        D.setNome(cn.nextLine());
        System.out.printf("informe o código ");
        D.setCodigo(cn.nextInt());
        System.out.printf("informe a abordagem pedagógica ");
        D.setAbordagem_pedagogica(cn.nextLine());
    }
    
    void cadastroProfessor()
    {
        Professor P = new Professor();
        Scanner cn = new Scanner(System.in);
        P.setNome(cn.nextLine());
        P.setMatricula(cn.nextLong());
        P.setEspecializacao(cn.nextLine());
        P.setSalario(cn.nextFloat());
    }
    
    void cadastroAluno()
    {
        Aluno A = new Aluno();
        Scanner cn = new Scanner(System.in);
        A.setNome(cn.nextLine());
        A.setMatricula(cn.nextLong());
        A.setCurso(cn.nextLine());
    }
    
    void cadastroTurma()
    {
        Turma T = new Turma();
        Scanner cn = new Scanner(System.in);
        T.setNumAlunos(cn.nextInt());
        T.setNumDiasSema(cn.nextInt());
    }
}
