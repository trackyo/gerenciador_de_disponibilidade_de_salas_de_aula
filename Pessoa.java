package entities;

import java.util.Scanner;

public class Pessoa {
	
private String nome;

private Long matricula;

public String getNome() {
	return nome;
}
void cadastrarnome() {
	Scanner cn = new Scanner(System.in);
	String nome ;
	System.out.printf("informe o nme ");
	nome = cn.nextLine();
}
public void setNome(String nome) {
	this.nome = nome;
}

public Long getMatricula() {
	return matricula;
}

public void setMatricula(Long matricula) {
	this.matricula = matricula;
}



}
