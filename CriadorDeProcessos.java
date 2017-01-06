import java.util.Random;

public class CriadorDeProcessos
{
	private int ultimoId;
	private Random rnd;

	public CriadorDeProcessos()
	{
		this.ultimoId = 0;
		this.rnd = new Random();
	}

	public Processo getProcesso()
	{
		this.ultimoId++;
		return (new Processo(this.ultimoId, String.valueOf(rnd.nextInt(99999)), rnd.nextInt(70), rnd.nextBoolean()));
	}
}