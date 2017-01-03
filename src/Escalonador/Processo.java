//Processos (Utilizado pelo Escalonador.java)

public class Processo
{
	private int tempoRestante;
	private String nome;
	private int id;
	private boolean EntradaSaida;

	//Construtores
	public Processo(int id, String nome, int tempoRestante, boolean orientadoCpu)
	{
		this.id = id;
		this.nome = nome;
		this.tempoRestante = tempoRestante;
		this.EntradaSaida = orientadoCpu;
	}

	//Destrutores
	//Getters
	public int getId() { return this.id; }
	public String getNome(){ return this.nome; }
	public int getTempoRestante(){ return this.tempoRestante; }
	public int getBurst(){ return this.getTempoRestante(); }
	public boolean getOrientadoACPU(){ return !this.EntradaSaida; }

	//Setters


	//Comandos
	public void gastaTempo(int tempoGasto)
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
