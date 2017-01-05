//Atenção !!! Essa classe serve somente como suporte

public class Escalonador extends Thread
{
	String nome;
	Processo processo;
	private boolean acabou;
	TipoCPU tipoDeCpu;
	Fila fila[];
	int qualFila;//Armazena a fila a qual o ultimo processo pertence
	CPU cpu;

	//Construtor
	public Escalonador(String nome, TipoCPU tipoDeCpu, Processo processo[])
	{
		super(nome);
		this.tipoDeCpu = tipoDeCpu;
		if(tipoDeCpu == TipoCPU.singleCore)
		{
			this.cpu = new CPU();
			this.cpu.iniciar();
		}
		else
		{
			System.out.println("Esse algoritimo não suporta esse tipo de CPU");
		}

		fila = new Fila[4];
		fila[0] = new Fila(10);
		fila[1] = new Fila(20);
		fila[2] = new Fila(30);
		fila[3] = new Fila(40);
		acabou = true;
	}

	//Getters

	//Setters


//Comandos

	//TODO
	@Override
	public void run()
	{
		if(cpu.getOcupado())
		{
			this.processo.setEstado(ESTADO.EXECUTANDO);
		}
		else
		{
			if(this.processo != null)
			{
				if(this.processo.getEstado() == ESTADO.EXECUTANDO)
				{
					if(this.processo.getFinalizado())
					{
						this.processo.setEstado(ESTADO.FINALIZACAO);
						this.fila[qualFila].rmProcesso();
					}
				}
			}
			if(this.fila[0].getFilaVazia())
			{
				if(this.fila[1].getFilaVazia())
				{
					if(this.fila[2].getFilaVazia())
					{
						if(this.fila[3].getFilaVazia())
						{
							System.out.print("CPU Ociosa \n");
						}
						else
						{
							qualFila = 3;
							if(!this.cpu.sendProcesso(this.fila[3].getProcesso()))
							{
								System.out.println("Erro: CPU não pôde aceitar processo");
							}	
							else
							{
								this.processo = this.fila[qualFila].getProcesso();
							}
						}
					}
					else
					{
						qualFila = 2;
						if(!this.cpu.sendProcesso(this.fila[2].getProcesso()))
						{
							System.out.println("Erro: CPU não pôde aceitar processo");
						}
						this.processo = this.fila[qualFila].getProcesso();
					}
				}
				else
				{
					qualFila = 1;
					if(!this.cpu.sendProcesso(this.fila[1].getProcesso()))
					{
						System.out.println("Erro: CPU não pôde aceitar processo");
					}
					this.processo = this.fila[qualFila].getProcesso();

				}
			}
			else
			{
				qualFila = 0;
				if(!this.cpu.sendProcesso(this.fila[0].getProcesso()))
				{
					System.out.println("Erro: CPU não pôde aceitar processo");
				}
				this.processo = this.fila[qualFila].getProcesso();
				this.processo.setEstado(ESTADO.CRIACAO);
			}
		}
	}


	public void addProcesso(Processo processo)
	{
		if(processo.getQuantum() <= 10)
		{
			this.fila[0].addProcesso(processo);
		}
		else if(processo.getQuantum()<= 20)
		{
			this.fila[1].addProcesso(processo);
		}
		else if(processo.getQuantum() <= 30)
		{
			this.fila[2].addProcesso(processo);
		}
		else
		{
			this.fila[3].addProcesso(processo);
		}
	}








	@Override
	public String toString()
	{
		return "Este é o escalonador"+this.nome;

	}
}