//Simulador de CPU
public class CPU implements Runnable
{
	private boolean rodando;
	private int maiorTempoOcioso;//Mostra o maior tempo de ociosidade da CPU
	private int tempoOcioso;//Checa a quanto tempo a cpu está ociosa
	public boolean ocupado;//Para checar se há algum processo executando agora
	public Processo processo; 

//Construtores
	public CPU()
	{
		this.maiorTempoOcioso = 0;
		this.tempoOcioso = 0;
		this.ocupado = false;
		this.rodando = false;
	}
//Destrutores

//Getters
	public boolean getOcupado() { return this.ocupado; }
	public boolean getOcioso() { return !this.ocupado; }
//Setters
	
//Comandos
	public void interromper()
	{
		this.ocupado = false;
	}

	public boolean sendProcesso(Processo processo)
	{
		if(this.getOcupado())
		{
			return false;
		}
		else
		{
			System.out.println("Processo \"RECEBIDO\"");
			this.ocupado = true;
			this.processo = processo;
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
				Thread.sleep(200);
			}
			catch(InterruptedException ex)
			{
				System.out.println(ex);
			}
			if(this.ocupado)
			{
				//System.out.println("CPU Ocupada");
				System.out.println("\tID: "+this.processo.getId());
				this.processo.gastaBurst(1);
				if(this.processo.getFinalizado())
				{
					System.out.println("CPU Detectou Finalização de Processo");
					this.ocupado = false;
				}
				else
				{
					System.out.println("CPU NÃO Detectou Finalização de Processo");
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
