public class Main
{
	public static void main(String args[])
	{
		//Re-farei
		Escalonador escalonador = new Escalonador("Teste", TipoCPU.singleCore);
		escalonador.addProcesso(new Processo(1, "bola", 60, true));
		escalonador.addProcesso(new Processo(2, "borboleta", 28, true));
		escalonador.addProcesso(new Processo(3, "arvore", 10, true));
		escalonador.addProcesso(new Processo(4, "casa", 50, true));
		escalonador.addProcesso(new Processo(5, "bolsa", 48, true));
		escalonador.addProcesso(new Processo(6, "familia", 5, true));
		escalonador.addProcesso(new Processo(7, "gato", 7, true));
		escalonador.addProcesso(new Processo(8, "amor", 16, true));
		escalonador.addProcesso(new Processo(9, "cachorro", 3, false));
		escalonador.addProcesso(new Processo(10, "estrela", 99, true));
		escalonador.start();

		
	}
}
