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
                String cont1Inst, cont2Inst, cont3Inst;//strings para contar linhas
                cont1Inst = arqContInst.readLine();
                cont2Inst = arqContInst.readLine();
                cont3Inst = arqContInst.readLine();
                
                BufferedReader arqDadosInst = new BufferedReader(new FileReader(linhaInst+".txt"));//função para instanciar objetos
                Instituicao I = new Instituicao();
                I.setNome(arqDadosInst.readLine());
                I.setIntegral(Boolean.parseBoolean(arqDadosInst.readLine()));
                I.setNoturno(Boolean.parseBoolean(arqDadosInst.readLine()));
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
                    Pred.setQtd_salas(Integer.parseInt(cont3Inst));
                    
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
    
    void cadastroInst()//forma básica para cadastrar um arrayList de instituições
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
        Inst.criaDiretInst();
        Inst.Salvar();//cria um arquivo .txt com as informações fornecidas e mostra um balão na tela quando completo 
        Inst.salvarLis();
    }
    
    /*void InstFinal()//função incompleta para procurar elementos de um mesmo objeto em diferentes listas
    {
        for(int a=0; a<InstAux.size(); a++)//ele pecorre toda a lista index por index, tal valor é fornecindo pelo .size()
        {
            Instituicao I = new Instituicao();//objeto temporario de instituição (toda vez que rolar incremento ele cria um novo objeto)
            for(int b=0; b<PredLista.size(); b++)//pecorre toda a lista de predios procurando os predios ligados a cada objeto
            {
                ArrayList <Predio> PredioLocal = new ArrayList();//arrayList temporario apenas para adicionar os predios de um mesmo objeto (depois reseta)
                if(PredLista.get(b).getInstituicao().getNome().equals(InstAux.get(a).getNome()))//verifica se o nome dos objetos são iguais
                {
                    PredioLocal.add(PredLista.get(b));//adiciona ao array de predios
                }
                I.setNome(InstAux.get(a).getNome());//adiciona os objetos
                I.setIntegral(InstAux.get(a).getIntegral());
                I.setNoturno(InstAux.get(a).getNoturno());
                I.setProfessores(ProfLista);
                I.setDisciplinas(DiscFim);
                I.setAlunos(alunoFim);
                I.setPredios(PredioLocal);
                InstFim.add(I);//adiciona ao arrayListFinal
            }
        }
    }
    
    void SalaFinal()
    {
        
    }
    
    void TurmaFinal()
    {
        
    }
    
    void OcupaFinal()
    {
        
    }
    
    void DisciFinal()//função incompleta
    {
        for(int a=0; a<DiscAux.size(); a++)
        {
            Disciplina D = new Disciplina();
            for(int b=0; b<TurmaAux.size(); b++)
            {
                ArrayList<Turma> turmaLocal = new ArrayList();
                if(TurmaAux.get(b).getDisciplina().getNome().equals(DiscAux.get(a).getNome()))
                {
                    turmaLocal.add(TurmaAux.get(b));
                }            
                D.setNome(DiscAux.get(a).getNome());
                D.setCodigo(DiscAux.get(a).getCodigo());
                D.setAbordagem_pedagogica(DiscAux.get(a).getAbordagem_pedagogica());
                D.setTurmas(turmaLocal);
                DiscFim.add(D);
            }
        }
    }*/

    void cadastroPredioSalas(ArrayList<Instituicao> InstAux)//cadastra prédio e salas
    {
        int n;
        String Inst;
        Predio Pred = new Predio();
        Scanner cn = new Scanner(System.in);
        ArrayList<Sala> SalaPred = new ArrayList();//arrayList temporário para salas
        System.out.printf("informe o nome da Instituicao ");
        Inst = cn.nextLine();
        for(int i=0; i<InstAux.size();i++)//verifica se a instituição existe
        {
            if(Inst.equals(InstAux.get(i).getNome()))
            {
                Pred.setInstituicao(InstAux.get(i));//adiciona o objeto instituição para o objeto predio
                break;
            }
        }
        System.out.printf("informe o nome do prédio ");
        Pred.setNome(cn.nextLine());
        System.out.printf("informe o numero de salas ");
        n = cn.nextInt();
        Pred.setQtd_salas(n);
        
        for(int i=0; i<n;i++)//laço para gerar vários objetos do tipo sala
        {
            int m;
            String select;
            System.out.printf("deseja adicionar sala ou labarotório? ");
            select = cn.nextLine();//seleciona o tipo de sala
            if("sala".equals(select))
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
             SalaAux.add(S);
             SalaPred.add(S);//adiciona objeto o para o Array de objetos temporarios
            }
            else
            {
               Laboratorio L = new Laboratorio();
               L.setPredio(Pred);
               System.out.printf("informe o número de salas ");
               L.setIdSala(cn.nextInt());
               System.out.printf("informe a capacidade ");
               L.setCapacidade(cn.nextInt());
               System.out.printf("informe se tem arcondicionado (true/false)");
               L.setAr(cn.nextBoolean());
               System.out.printf("informe se tem projetor (true/false)");
               L.setProjetor(cn.nextBoolean());
               System.out.printf("informe se tem TV (true/false)");
               L.setTv(cn.nextBoolean());
               System.out.printf("informe a quantidade de computadores");
               L.setQtd_computadores(cn.nextInt());
               System.out.printf("informe a quantidade de equipamentos");
               m = cn.nextInt();
               L.setQtd_equipametos(m);
               for (int j=0; j<m; j++)
               {
                   System.out.printf("informe o tipo de equipamento");
                   EquipLista.add(cn.nextLine());
               }
               L.setTipos_equipamentos(EquipLista);
               SalaAux.add(L);
               SalaPred.add(L);
               LabLista.add(L);
            }  
        }
        Pred.setSala(SalaPred);//seta o vetor para o atributo da classe
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
        DiscAux.add(D);
    }
    
    void cadastroProfessor()
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
    
    void cadastroAluno()
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
