//Atenção !!! Essa classe serve somente como suporte

public class Escalonador extends Thread
{
	String nome;
	Processo processo;
	private boolean acabou;
	TipoCPU tipoDeCpu;
	Fila fila[];
	int qualFila;//Armazena a fila a qual o ultimo processo pertence
	int previsao;//Controle para saber quando um processo deve ser interrompido por estouro de burst permitido pela fila(Round Robin)

	CPU cpu;

	//Construtor
	public Escalonador(String nome, TipoCPU tipoDeCpu)
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
		while(true)
		{
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException ex)
			{
				System.out.println("Interrompido");
				System.out.print(ex);
			}
			//System.out.println("Estado de CPU :"+ this.cpu.getOcupado());
			if(this.cpu.getOcupado())
			{
				//System.out.println("CPU Ocupada");
				this.processo.setEstado(ESTADO.EXECUTANDO);
				//System.out.println("Previsao = "+this.previsao);
				//System.out.println("Burst = "+ this.processo.getBurst());
				
				//System.out.println("Quantum da Fila = "+ this.fila[qualFila].getQuantum());
				if(this.processo.getBurst() == previsao)
				{
					this.fila[qualFila].interromperProcesso();
					this.cpu.interromper();
				}
			}
			else
			{
				//System.out.println("CPU Ociosa Detectada pelo Escalonador");
				if(this.processo != null)
				{
				//	System.out.print("Chegou aqui !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 1");
					if(this.processo.getEstado() == ESTADO.EXECUTANDO)
					{

						if(this.processo.getFinalizado())
						{
							this.processo.setEstado(ESTADO.FINALIZACAO);
						}
					}
				}

				/*
				else
				{
					System.out.println("Processo igual a NULL");
				}*/


				if(this.fila[0].getFilaVazia())
				{
					System.out.println("\nFila 0 vazia");
					if(this.fila[1].getFilaVazia())
					{
						System.out.println("Fila 1 vazia");
						if(this.fila[2].getFilaVazia())
						{
							System.out.println("Fila 2 vazia");
							if(this.fila[3].getFilaVazia())
							{
								System.out.println("Fila 3 vazia");
								System.out.print("CPU Ociosa \n");
							}
							else
							{
								System.out.println("Fila 3 não está vazia");

								System.out.println("Processo Enviado");
								if(this.processo != null)
								{
									System.out.println("Processo Anterior: "+this.processo.getId());	
									System.out.println("Removendo processo anterior");
									this.fila[qualFila].rmProcesso();
								}
								this.processo = this.fila[qualFila].getProcesso();
								if(this.processo == null)
								{
									System.out.println("Trocando de Fila");

								}
								else
								{


									System.out.println("Novo Processo : "+this.processo.getId());
									this.processo.setEstado(ESTADO.CRIACAO);
									System.out.println("Enviando Processo à CPU");
									if(!this.cpu.sendProcesso(this.fila[3].getProcesso()))
									{
										System.out.println("Erro: CPU não pôde aceitar processo");
									}
								}
								qualFila = 3;
								if(this.processo != null)
								{
									previsao = this.processo.getBurst() - this.fila[qualFila].getQuantum();	
								}
								










							}
						}
						else
						{
							System.out.println("Fila 2  não está vazia");

							System.out.println("Processo Enviado");
							if(this.processo != null)
							{
								System.out.println("Processo Anterior: "+this.processo.getId());	
								System.out.println("Removendo processo anterior");
								this.fila[qualFila].rmProcesso();
							}
							this.processo = this.fila[qualFila].getProcesso();
							if(this.processo == null)
							{
								System.out.println("Trocando de Fila");

							}
							else
							{


								System.out.println("Novo Processo : "+this.processo.getId());
								this.processo.setEstado(ESTADO.CRIACAO);
								System.out.println("Enviando Processo à CPU");
								if(!this.cpu.sendProcesso(this.fila[2].getProcesso()))
								{
									System.out.println("Erro: CPU não pôde aceitar processo");
								}
							}
							qualFila = 2;
							if(this.processo != null)
							{
								previsao = this.processo.getBurst() - this.fila[qualFila].getQuantum();	
							}

						}
					}
					else
					{
						System.out.println("\nFila 1  não está vazia");
						
						System.out.println("Processo Enviado");
						if(this.processo != null)
						{
							System.out.println("Processo Anterior: "+this.processo.getId());	
							System.out.println("Removendo processo anterior");
							System.out.println("Removendo da fila :"+ qualFila);
							this.fila[qualFila].rmProcesso();
							System.out.println("Processo REMOVIDO");
						}

						this.processo = this.fila[1].getProcesso();
						if(this.processo == null)
						{
							System.out.println("Trocando de Fila");
						}
						else
						{


							System.out.println("Novo Processo : "+this.processo.getId());
							this.processo.setEstado(ESTADO.CRIACAO);
							System.out.println("Enviando Processo à CPU");
							if(!this.cpu.sendProcesso(this.fila[1].getProcesso()))
							{
								System.out.println("Erro: CPU não pôde aceitar processo");
							}
						}
						qualFila = 1;
						if(this.processo != null)
						{
							previsao = this.processo.getBurst() - this.fila[qualFila].getQuantum();	
						}

					}
				}
				else
				{
					System.out.println("\nFila 0 não está vazia");
					qualFila = 0;
					System.out.println("Processo Enviado");
					if(this.processo != null)
					{
						System.out.println("Processo Anterior: "+this.processo.getId());	
						System.out.println("Removendo processo anterior");
						this.fila[0].rmProcesso();
					}
					this.processo = this.fila[qualFila].getProcesso();
					if(this.processo == null)
					{
						System.out.println("Trocando de Fila");
					}
					else
					{


						System.out.println("Novo Processo : "+this.processo.getId());
						this.processo.setEstado(ESTADO.CRIACAO);
						System.out.println("Enviando Processo à CPU");
						if(!this.cpu.sendProcesso(this.fila[0].getProcesso()))
						{
							System.out.println("Erro: CPU não pôde aceitar processo");
						}
					}
					if(this.processo != null)
					{
						previsao = this.processo.getBurst() - this.fila[qualFila].getQuantum();	
					}
				}
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
		return "Escalonador "+this.nome+" Executando "+this.processo+'\n'+
		" Quantum restante :"+ this.processo.getBurst()+'\n'+
		" Fila :"+this.qualFila;

	}
}