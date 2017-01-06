public class Main
{
	public static void main(String args[])
	{
		//Re-farei
		
		Processo processos[] = new Processo[20];

		Escalonador escalonador = new Escalonador("Teste", TipoCPU.singleCore);
		/*escalonador.addProcesso(new Processo(1, "bola", 60, true));
		escalonador.addProcesso(new Processo(2, "borboleta", 28, true));
		escalonador.addProcesso(new Processo(3, "arvore", 10, true));
		escalonador.addProcesso(new Processo(4, "casa", 50, true));
		escalonador.addProcesso(new Processo(5, "bolsa", 48, true));
		escalonador.addProcesso(new Processo(6, "familia", 5, true));
		escalonador.addProcesso(new Processo(7, "gato", 7, true));
		escalonador.addProcesso(new Processo(8, "amor", 16, true));
		escalonador.addProcesso(new Processo(9, "cachorro", 1, false));
		escalonador.addProcesso(new Processo(10, "estrela", 99, true));
		*/
		CriadorDeProcessos criador = new CriadorDeProcessos();
		escalonador.start();
		new Interface(escalonador);

		for(int i=0; i<20; i++)
		{
			processos[i] = criador.getProcesso();
			escalonador.addProcesso(processos[i]);
			try
			{
				Thread.sleep(5000);//Espera 5 s antes de criar um novo processo
			}
			catch(InterruptedException ex)
			{
				System.out.print(ex);
			}
		}
		//escalonador.addProcesso(new Processo(11, "passaro", 8, false));
	}
}