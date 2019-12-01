package entities;

public class Laboratorio extends Sala
{
    private int qtd_computadores;
    private int qtd_equipametos;
    private String tipo_equipamento;

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

    public String getTipo_equipamento() 
    {
        return tipo_equipamento;
    }

    public void setTipo_equipamento(String tipo_equipamento) 
    {
        this.tipo_equipamento = tipo_equipamento;
    }
}
