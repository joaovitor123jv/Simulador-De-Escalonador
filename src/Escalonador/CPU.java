//Simulador de CPU
public class CPU implements Runnable
{
	private boolean rodando;
	private int maiorTempoOcioso;//Mostra o maior tempo de ociosidade da CPU
	private int tempoOcioso;//Checa a quanto tempo a cpu está ociosa
	public boolean ocupado;//Para checar se há algum processo executando agora
	private int idProcesso;//Id do processo que está na CPU
	private int quantum;

//Construtores
	public CPU()
	{
		this.maiorTempoOcioso = 0;
		this.tempoOcioso = 0;
		this.idProcesso = 0;
		this.ocupado = false;
		this.rodando = false;
	}
//Destrutores

//Getters
	public boolean getOcupado() { return this.ocupado; }
	public boolean getOcioso() { return !this.ocupado; }
//Setters
	
//Comandos
	public boolean sendProcesso(int id, int quantum)
	{
		if(this.getOcupado())
		{
			return false;
		}
		else
		{
			this.ocupado = true;
			this.quantum = quantum;
			this.idProcesso = id;
			return true;
		}
	}

	public boolean sendProcesso(Processo processo)
	{
		if(this.getOcupado())
		{
			return false;
		}
		else
		{
			this.ocupado = true;
			this.quantum = processo.getQuantum();
			this.idProcesso = processo.getId();
			return true;
		}
	}

	public void encerrar()
	{
		this.rodando = false;
	}

	@Override
	public void run()
	{
		this.rodando = true;
		while(this.rodando)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex)
			{
				System.out.println(ex);
			}
			if(this.ocupado)
			{
				System.out.println("CPU Ocupada");
				System.out.println("\tID: "+this.idProcesso);
				this.quantum--;
				if(this.quantum == 0)
				{
					this.ocupado = false;
				}
			}
			else
			{
				this.tempoOcioso++;
				System.out.println("CPU Ociosa por "+this.tempoOcioso);
				if(this.tempoOcioso > this.maiorTempoOcioso)
				{
					this.maiorTempoOcioso = this.tempoOcioso;
				}
			}
		}
	}

	public void iniciar()
	{
		Thread t1 = new Thread(this);
		t1.start();
	}
}
