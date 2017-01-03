public class Main
{
	public static void main(String args[])
	{
		System.out.println(" Instanciando CPU");
		CPU cpu = new CPU();
		System.out.println(" Iniciando um processo");
		Processo p1 = new Processo(1, "nginx", 100000, true);
		p1.toString();
		System.out.println(" Iniciando CPU");
		cpu.run();
		System.out.println(" Enviando processo para executar na CPU");
		cpu.sendProcesso(p1.getId(), p1.getQuantum());
	}
}
