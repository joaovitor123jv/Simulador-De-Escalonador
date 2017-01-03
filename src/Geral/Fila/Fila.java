public class Fila
{
	private int prioridade;
	private int numeroMaximoDeElementos;
	private int elementoFinal;
	//elementoInicial == 0;

	public Fila()//Construtor
	{
		this.numeroMaximoDeElementos= 10;
		this.elementoFinal= 0;
		this.prioridade=0;
	}

	public Fila(int prioridade)
	{
		this.numeroMaximoDeElementos= 10;
		this.elementoFinal= 0;
		this.prioridade=prioridade;
	}

	//Getters
	private boolean getFilaVazia()
	{
		if(this.elementoFinal == 0)
		{
			return true;
		}
		return false;
	}

	public int getPrioridade(){ return this.prioridade;}

	//Setters


	//Comandos
	public addProcesso(int processo)
	{
	}


	public String toString()
	{
		return "Essa é uma fila com "+ (this.elementoFinal+1)+" elementos";
	}
}
