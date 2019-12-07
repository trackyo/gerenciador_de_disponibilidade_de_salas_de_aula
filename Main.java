package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.Aluno;
import service.Professor;

public class Main // classe main auxiliar para mexer em elementos não estáticos
{
    ArrayList<Predio> PredLista;
    ArrayList<Professor> ProfLista;
    ArrayList<Laboratorio> LabLista;
    ArrayList<String> EquipLista;
    
    ArrayList<Instituicao> InstAux;//listas temporárias, para manter os objetos antes de serem salvos (provavelmente essa parte seja removida)
    ArrayList<Disciplina> DiscAux;// tais mudanças serão realizadas pq provavelmente dessa forma atual dará um erro por modificação em tempo de execução
    ArrayList<Turma> TurmaAux;// eu pretendo modificar as coisa pra que eu possa criar cada objeto pelos dados salvos em arquivos
    ArrayList<Sala> SalaAux;
    ArrayList<Aluno> AlunoAux;
    ArrayList<Ocupa> OcupaAux;
    
    ArrayList<Instituicao> InstFim;//listas que serão salvas(possivelmente serão modificadas)
    ArrayList<Disciplina> DiscFim;
    ArrayList<Turma> TurmaFim;
    ArrayList<Sala> SalaFim;
    ArrayList<Aluno> alunoFim;
    ArrayList<Ocupa> OcupaFim;
    
    public void LerArq()//função imcompleta
    {
        try 
        {
            BufferedReader arqListInst = new BufferedReader(new FileReader("diretorio//inst//lista.txt"));//procura e abre para leitura o elemeto da lista.txt
            String linhaInst = "";
            linhaInst = arqListInst.readLine();//string para ler linha
            while(linhaInst != null)//laço para ler todo o arquivo
            {
                BufferedReader arqContInst = new BufferedReader(new FileReader("diretorio//inst//"+linhaInst+"//"+linhaInst+".txt"));//abre o arquivo que contém o objeto
                String cont1Inst;//strings para contar linhas
                cont1Inst = arqContInst.readLine();
                
                BufferedReader arqDadosInst = new BufferedReader(new FileReader(linhaInst+".txt"));//função para instanciar objetos
                Instituicao I = new Instituicao();
                I.setNome(arqDadosInst.readLine());
                InstAux.add(I);//arraysList auxliar para gaurdar informação
                
                BufferedReader arqListPred = new BufferedReader(new FileReader("diretorio//inst//"+linhaInst+"//lista.txt"));//função para abrir a pasta dentro da pasta
                String linhaPred = "";
                linhaPred = arqListPred.readLine();
                while(linhaPred != null)
                {
                    BufferedReader arqContPred = new BufferedReader(new FileReader("diretorio//inst//"+linhaInst+"//"+linhaPred+"//"+linhaPred+".txt"));
                    String cont1Pred, cont2Pred, cont3Pred;
                    cont1Pred = arqContPred.readLine();
                    cont2Pred = arqContPred.readLine();
                    cont3Pred = arqContPred.readLine();
                
                    BufferedReader arqDadosPred = new BufferedReader(new FileReader(linhaPred+".txt"));
                    Predio Pred = new Predio();
                    Pred.setInstituicao(I);
                    Pred.setNome(cont2Pred);
                    
                }
                
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Main()
    {   
        PredLista = new ArrayList();//instanciando os arrayLists
        ProfLista = new ArrayList();
        LabLista = new ArrayList();
        EquipLista = new ArrayList();
        
        InstAux = new ArrayList();
        DiscAux = new ArrayList();
        TurmaAux = new ArrayList();
        SalaAux = new ArrayList();
        AlunoAux = new ArrayList();
        OcupaAux = new ArrayList();
        
        InstFim = new ArrayList();
        DiscFim = new ArrayList();
        TurmaFim = new ArrayList();
        SalaFim = new ArrayList();
        alunoFim = new ArrayList();
        OcupaFim = new ArrayList();
        
        File diretorio = new File("diretorio");//cria uma pasta chamada diretorio para poder guardar os arquivos
        boolean mk = diretorio.mkdir();
        System.out.println("diretorio criado " + mk);//confirma se o diretorio foi criado
        File Inst = new File(diretorio, "inst");// criam duas pastas para separar os derivados de instituicao e os de disciplina
        boolean jk = Inst.mkdir();
        File Disc = new File(diretorio, "disc");
        boolean ik = Disc.mkdir();
         
        cadastroInst();
        
    }
    
    public static void main(String[] args)//classe main estática
    {      
        new Main(); // declaração do metodo main 
    }
    
    void cadastroInst()//cadastra instituições
    {//primeiro a ser cadastrado
        Instituicao Inst = new Instituicao();
        int a;
        ArrayList<Predio> PredioLocal = new ArrayList();
        Scanner cn = new Scanner(System.in);
	System.out.printf("informe o nome ");
        Inst.setNome(cn.nextLine());
        Inst.criaDiretInst();
        Inst.Salvar();//cria um arquivo .txt com as informações fornecidas e mostra um balão na tela quando completo 
        Inst.salvarLis();
        System.out.printf("informe o numero de predios ");
        a = cn.nextInt();
        for(int b=0; b<a; b++)
        {
            Predio Pred = new Predio();
            PredioLocal.add(Pred.cadPred(Inst));
            PredLista.add(Pred.cadPred(Inst));
            
        }
        for(int c=0; c<PredioLocal.size(); c++)
        {
            for(int d=0; d<PredioLocal.get(c).getSala().size(); d++)
            {
                SalaFim.add(PredioLocal.get(c).getSala().get(d));
            }
        }
        Inst.setPredios(PredioLocal);
        InstFim.add(Inst);
    } 

    void cadastroPredio()//cadastra apenas prédio e salas
    {
        int n;
        String Inst;
        Predio Pred = new Predio();
        Scanner cn = new Scanner(System.in);
        System.out.printf("informe o nome da Instituicao ");
        Inst = cn.nextLine();
        for(int i=0; i<InstFim.size();i++)//verifica se a instituição existe
        {
            if(Inst.equals(InstFim.get(i).getNome()))
            {
                InstFim.get(i).getPredios().add(Pred.cadPred(InstFim.get(i)));
                PredLista.add(Pred.cadPred(InstFim.get(i)));
                for(int j=0;j<Pred.cadPred(InstFim.get(i)).getSala().size(); j++)
                {
                    SalaFim.add(Pred.cadPred(InstFim.get(i)).getSala().get(i));    
                }
                
                break;
            }
        }
        
    }
    
    void cadastroSala()//cadastra apenas salas
    {
        int n;
        String Pred;
        Sala S = new Sala();
        Scanner cn = new Scanner(System.in);
        System.out.printf("informe o nome do Predio ");
        Pred = cn.nextLine();
        for(int i=0; i<PredLista.size();i++)//verifica se a instituição existe
        {
            if(Pred.equals(PredLista.get(i).getNome()))
            {
                PredLista.get(i).getSala().add(S.cadSala(PredLista.get(i)));
                SalaFim.add(S.cadSala(PredLista.get(i)));//depois criar uma função para abrir o arquivo e modificar a quantidade de salas do predio
                for(int j=0; j<InstFim.size(); j++)
                {
                    for(int k=0; k<InstFim.get(j).getPredios().size(); k++)
                    {
                        if(InstFim.get(i).getPredios().get(k).getNome().equals(Pred))
                        {
                            InstFim.get(i).getPredios().get(k).getSala().add(S.cadSala(PredLista.get(i)));
                        }
                    }
                }
                break;
            }
        }
        
    }        
    
    void cadastroDiciplina()// terceiro a ser cadastrado
    {
        Disciplina D = new Disciplina();
        int a;
        String prof;
        Scanner cn = new Scanner(System.in);
        ArrayList <Turma> TurmaLocal = new ArrayList();
        System.out.printf("informe o nome da disciplina ");
        D.setNome(cn.nextLine());
        System.out.printf("informe o código ");
        D.setCodigo(cn.nextInt());
        System.out.printf("informe a abordagem pedagógica ");
        D.setAbordagem_pedagogica(cn.nextLine());
        System.out.printf("informe o nume de turmas ");
        a = cn.nextInt();
        for(int i=0; i<a; i++)
        {
            Turma T = new Turma();
            System.out.printf("informe o nome do professor ");
            prof = cn.nextLine();
            for(int j=0; j<ProfLista.size(); j++)
            {
                if(prof.equals(ProfLista.get(j).getNome()))
                {
                    TurmaLocal.add(T.cadTurma(D, ProfLista.get(j), SalaFim));
                    TurmaFim.add(T.cadTurma(D, ProfLista.get(j), SalaFim));
                    break;
                }
            }
            
        }
        D.setTurmas(TurmaLocal);
        DiscFim.add(D);
    }
    
    void cadastroProfessor()//segundo a ser cadastrado
    {
        Professor P = new Professor();
        String Inst;
        Scanner cn = new Scanner(System.in);
        System.out.printf("informe a instituicao");
        Inst = cn.nextLine();
        for(int a=0; a<InstAux.size(); a++)
        {
            if(Inst.equals(InstAux.get(a).getNome()))
            {
                P.setInst(InstAux.get(a));
                break;
            }
        }
        P.setNome(cn.nextLine());
        P.setMatricula(cn.nextLong());
        P.setEspecializacao(cn.nextLine());
        P.setSalario(cn.nextFloat());
        ProfLista.add(P);
    }
    
    void cadastroAluno()//ultimo a ser cadastrado
    {
        Aluno A = new Aluno();
        String modo, Disc, Turma, Inst;
        int i=1;
        ArrayList <Turma> TurmaLocal = new ArrayList();//array temporário
        Scanner cn = new Scanner(System.in);
        System.out.printf("informe o nome");
        A.setNome(cn.nextLine());
        System.out.printf("informe a matrícula");
        A.setMatricula(cn.nextLong());
        System.out.printf("informe o curso");
        A.setCurso(cn.nextLine());
        System.out.printf("informe a instituicao");
        Inst = cn.nextLine();
        for(int a=0; a<InstAux.size(); a++)
        {
            if(Inst.equals(InstAux.get(a).getNome()))
            {
                A.setInst(InstAux.get(a));
                break;
            }
        }
        while(i<42)//loop para adicionar quantas turmas forem nescessárias(como o i não incrementa ele sempre vai ser menor do que 42)
        {
            System.out.printf("informe a disciplina");
            Disc = cn.nextLine();
            for(int j=0; j<DiscAux.size();j++)//procura as disciplinas
            {
                if(Disc.equals(DiscAux.get(j).getNome()))
                {
                    System.out.printf("informe a turma");
                    Turma = cn.nextLine();
                    for(int k=0; k<DiscAux.get(j).getTurmas().size();k++)//procura a turma
                    {
                        if(Disc.equals(DiscAux.get(j).getTurmas().get(k).getNome()))
                        {
                            TurmaLocal.add(DiscAux.get(j).getTurmas().get(k));//adiciona a turma
                            break;
                        }
                    }
                }
                break;
            }
            System.out.printf("deseja adicionar mais matérias?");
            modo = cn.nextLine();
            if ("n".equals(modo))//condição de saida do loop
            {
                break;
            }
        }
        AlunoAux.add(A);
    }
    
    void cadastroTurma()
    {
        int n, Sala;
        String Prof, Disc, Predio;
        Turma T = new Turma();
        ArrayList<Ocupa> OcupaCont = new ArrayList();
        Scanner cn = new Scanner(System.in); 
        System.out.printf("informe o nome da turma ");
        T.setNome(cn.nextLine());
        System.out.printf("informe o nome da disciplina ");
        Disc = cn.nextLine();
        for(int i=0; i<DiscAux.size();i++)//procura na lista de disciplinas
        {
            if(Disc.equals(DiscAux.get(i).getNome()))
            {
                T.setDisciplina(DiscAux.get(i));
                break;
            }
        }
        
        System.out.printf("informe o nome do professor");
        Prof = cn.nextLine();
        for(int j=0; j<ProfLista.size();j++)//procura na lista de professores
        {
            if(Prof.equals(ProfLista.get(j).getNome()))
            {
                T.setProfessor(ProfLista.get(j));
                break;
            }
        }
        System.out.printf("informe o numer de aulos");
        T.setNumAlunos(cn.nextInt());
        System.out.printf("informe o numero de dias na semana");
        n = cn.nextInt();//a quatidade de ocupações é calculada pelo numero de dias que a aula ocorre em uma semana
        T.setNumDiasSema(n);
        
        for (int k=0; k<n; k++)//for para gerar várias ocupações
        {
            Ocupa O = new Ocupa();
            
            Predio = cn.nextLine();
            for(int l=0; l<PredLista.size();l++)//procura um prédio
            {
                if(Predio.equals(PredLista.get(l).getNome()))
                {
                    System.out.printf("informe a sala ");
                    Sala = cn.nextInt();
                    for(int a=0; a<PredLista.get(l).getSala().size();a++)//procura a sala
                    {
                        if(Sala == (PredLista.get(l).getSala().get(a).getIdSala()))
                        {
                            O.setSala(PredLista.get(l).getSala().get(a));
                            break;
                        }
                    }
                    break;
                }
            }
            
            O.setTurma(T);
            System.out.printf("informe o dia da semana dessa ocupacao");
            O.setDia(cn.nextLine());
            System.out.printf("informe o dia horario dessa ocupacao");
            O.setHorario(cn.nextInt()); 
            OcupaAux.add(O);
            OcupaCont.add(O);
        }
        T.setOcupacoes(OcupaCont);
        TurmaAux.add(T);
    }
}
