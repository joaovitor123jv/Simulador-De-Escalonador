//Simulador de CPU
public class CPU
{
	private int maiorTempoOcioso;//Mostra o maior tempo de ociosidade da CPU
	private int tempoOcioso;//Checa a quanto tempo a cpu está ociosa
	public boolean ocupado;//Para checar se há algum processo executando agora
	private int idProcesso;//Id do processo que está na CPU
	private int quantum;

//Construtores
	public CPU()
	{
		this.ocioso = true;
		this.maiorTempoOcioso = 0;
		this.tempoOcioso = 0;
		this.idProcesso = 0;
		this.ocupado = false;
	}
//Destrutores

//Getters
	public boolean getOcupado() { return this.ocupado; }
	public boolean getOcioso() { return !this.ocupado; }
//Setters
	
//Comandos
	public boolean sendProcesso(int id, int quantum)
	{
		if(this.getOcupado)
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
}
