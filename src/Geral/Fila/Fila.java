//Fila pode ter até 10 elementos


public class Fila
{
	private int quantum;
	private int numeroMaximoDeElementos;
	private int elementoFinal;
	private Processo[] processo;
	private CPU cpu;
	//elementoInicial == 0;

	public Fila()//Construtor
	{
		this.numeroMaximoDeElementos= 10;
		this.elementoFinal= 0;
		this.quantum=0;
		this.processo = new Processo[10];
	}

	public Fila(int quantum)
	{
		this.numeroMaximoDeElementos= 10;
		this.elementoFinal= 0;
		this.quantum=quantum;
		this.processo = new Processo[10];
	}

	//Getters
	public boolean getFilaVazia()
	{
		if(this.elementoFinal == 0)
		{
			return true;
		}
		return false;
	}

	public int getQuantum(){ return this.quantum;}

	//Setters


	//Comandos
	//TODO
	public void addProcesso(Processo processo)
	{
		System.out.println("Fazendo");
		System.out.println("ID recebido = "+processo.getId());
	}


	public String toString()
	{
		return "Essa é uma fila com "+ this.elementoFinal+" elementos e "+getQuantum()+" de tempo de quantum";
	}
}
