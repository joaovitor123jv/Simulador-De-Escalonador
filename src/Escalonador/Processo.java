//Processos (Utilizado pelo Escalonador.java)

public Processo
{
	private int tempoRestante;
	private String nome;
	private int id;

	//Construtores
	public Processo(int id, String nome, int tempoRestante)
	{
		this.id = is;
		this.nome = nome;
		this.tempoRestante = tempoRestante;
	}

	//Destrutores
	//Getters
	public int getId() { return this.id; }
	public String getNome(){ return this.nome; }
	public int getTempoRestante(){ return this.tempoRestante; }

	//Setters


	//Comandos
	public gastaTempo(int tempoGasto)
	{
		this.tempoRestante = this.tempoRestante - tempoGasto;
	}


	public String toString()
	{
		if(this.EntradaSaida)
		{
			return "Processo orientado a E/S com "+tempoRestante+" de tempo restante na CPU";
		}
		else
		{
			return "Processo orientado a CPU com "+tempoRestante+" de tempo restante na CPU";
		}
	}
}
