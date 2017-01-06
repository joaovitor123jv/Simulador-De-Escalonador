//Fila pode ter até 10 elementos


public class Fila
{
	private int quantum;
	//Linha abaixo não utilizado ainda
	//private int numeroMaximoDeElementos;
	private int elementoFinal;
	private Processo[] processo;
	private CPU cpu;

//Construtores
	public Fila()
	{
		//this.numeroMaximoDeElementos= 10;
		this.elementoFinal= 0;
		this.quantum=0;
		this.processo = new Processo[10];
	}

	public Fila(int quantum)
	{
		//this.numeroMaximoDeElementos= 10;
		this.elementoFinal= 0;
		this.quantum=quantum;
		this.processo = new Processo[10];
	}

	//Getters
	public boolean getFilaVazia()
	{
		if(this.processo[0] == null)
		{
			return true;
		}
		return false;
	}

	public int getQuantum(){ return this.quantum;}

	public Processo getProcesso()
	{
		return this.processo[0];
	}

	public Processo getProcesso(int posicao)
	{
		return this.processo[posicao];
	}


	//Setters


	//Comandos
	//TODO
	public void addProcesso(Processo processo)
	{
		System.out.println("Fazendo");
		System.out.println("ID recebido = "+processo.getId());
		int i = 0;
		while(true)
		{
			if(this.processo[i] == null)
			{
				break;
			}
			else
			{
				i++;
			}
		}
		this.processo[i] = processo;
	}

	public void rmProcesso()
	{
		System.out.println("Destruindo Processo "+this.processo[0].getId());
		this.processo[0] = null;
		int  i=1;
		do
		{
			this.processo[i-1] = this.processo[i];
			i++;
		}while(this.processo[i-1] != null);
		System.out.print("Processo destruído\n");
		
		this.processo[i] = null;
	}

	public String toString()
	{
		return "Essa é uma fila com "+ this.elementoFinal+" elementos e "+getQuantum()+" de tempo de quantum";
	}
}
