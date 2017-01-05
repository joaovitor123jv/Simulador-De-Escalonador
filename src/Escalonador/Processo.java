//Processos (Utilizado pelo Escalonador.java)

public class Processo
{
	private int tempoRestante;
	private String nome;
	private int id;
	private boolean EntradaSaida;
	private ESTADO estado;

	//Construtores
	public Processo(int id, String nome, int tempoRestante, boolean orientadoCpu)
	{
		this.id = id;
		this.nome = nome;
		this.tempoRestante = tempoRestante;
		this.EntradaSaida = orientadoCpu;
		this.estado= ESTADO.CRIACAO;//Precisa ser criado
	}

	//Destrutores
	//Getters
	public int getId() { return this.id; }
	public String getNome(){ return this.nome; }

	public int getTempoRestante(){ return this.tempoRestante; }
	public int getQuantum(){ return this.getTempoRestante(); }
	public int getBurst(){ return this.getTempoRestante(); }

	public boolean getOrientadoACPU(){ return !this.EntradaSaida; }
	public ESTADO getEstado(){ return this.estado; }

	public boolean getFinalizado(){ if(this.tempoRestante == 0) return true; else return false;}

	//Setters
	public void setEstado(ESTADO estado) { this.estado = estado; }


	//Comandos
	public void gastaBurst(int tempoGasto)
	{
		this.tempoRestante = this.tempoRestante - tempoGasto;
	}


	public String toString()
	{
		if(this.EntradaSaida)
		{
			return "ID: "+this.id+" Processo "+this.nome+" orientado a E/S com "+this.tempoRestante+" de tempo restante na CPU";
		}
		else
		{
			return "ID: "+this.id+" Processo "+this.nome+" orientado a CPU com "+this.tempoRestante+" de tempo restante na CPU";
		}
	}
}

enum ESTADO
{
	PRONTO, CRIACAO, ESPERA, FINALIZACAO, EXECUTANDO;
}
