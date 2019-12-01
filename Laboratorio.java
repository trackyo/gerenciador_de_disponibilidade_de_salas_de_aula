package entities;

import java.util.ArrayList;

public class Laboratorio extends Sala
{
    private int qtd_computadores;
    private int qtd_equipametos;
    private ArrayList <String> tipo_equipamento = new ArrayList<String>();

    public int getQtd_computadores() 
    {
        return qtd_computadores;
    }

    public void setQtd_computadores(int qtd_computadores) 
    {
        this.qtd_computadores = qtd_computadores;
    }

    public int getQtd_equipametos() 
    {
        return qtd_equipametos;
    }

    public void setQtd_equipametos(int qtd_equipametos) 
    {
        this.qtd_equipametos = qtd_equipametos;
    }

    public ArrayList<String> getTipo_equipamento() 
    {
        return tipo_equipamento;
    }

    public void setTipo_equipamento(ArrayList<String> tipo_equipamento) 
    {
        this.tipo_equipamento = tipo_equipamento;
    }

}
