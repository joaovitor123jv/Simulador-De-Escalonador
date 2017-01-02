public class Fila
{
	private int numeroMaximoDeElementos;
	private int elementoFinal;
	private int elementoInicial;

	public Fila()//Construtor
	{
		this.numeroMaximoDeElementos= 10;
		this.elementoFinal= 0;
		this.elementoInicial= 0;
	}

	//Getters
	private boolean getFilaVazia()
	{
		if(this.elementoFinal == this.elementoInicial)
		{
			return true;
		}
		return false;
	}

	//Setters


	//Comandos
	public addElemento(int elemento)
	{
	}


	public String toString()
	{
		return "Essa é uma fila com "+ (this.elementoFinal+1)+" elementos";
	}
}
