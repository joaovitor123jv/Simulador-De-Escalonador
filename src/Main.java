public class Main
{
	public static void main(String args[])
	{

		Fila fila = new Fila(10);
		if(fila.getFilaVazia())
		{
			System.out.println(" Fila Vazia");
		}
		else
		{
			System.out.println(" Fila não vazia");
		}

		System.out.println(fila.toString());

		try
		{
			Thread.sleep(4000);
		}
		catch(InterruptedException ex)
		{
			System.out.println(ex);
		}

/*

		System.out.println(" Instanciando CPU");
		CPU cpu = new CPU();
		System.out.println(" Iniciando um processo");
		Processo p1 = new Processo(1, "nginx", 5, true);
		p1.toString();
		System.out.println(" Iniciando CPU");

	

		cpu.iniciar();


		try
		{
			Thread.sleep(4000);
		}
		catch(InterruptedException ex)
		{
			System.out.println(ex);
		}

		System.out.println(" Enviando processo para executar na CPU");
		cpu.sendProcesso(p1.getId(), p1.getQuantum());
		*/
	}
}
