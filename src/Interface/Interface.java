import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;




public class Interface extends JFrame implements Runnable
{
	JLabel lbProcessos, lbCPU, lbIdProcesso, lbBurstRestante, lbQuantumFila, lbNomeProcesso;
	JPanel pnCPU, pnDados, pnDetalhes;
	CPU cpu;
	Escalonador escalonador;
	public Interface(Escalonador escalonador)
	{
//Definição de Interface
		super("Monitor de Processos (escalonador)");
		this.cpu = escalonador.getCPU();
		this.escalonador = escalonador;
		this.setSize(800,600);
		this.setLocationRelativeTo(null);

//Painéis
		this.pnCPU = new JPanel();
		this.pnDados = new JPanel();
		this.pnDetalhes = new JPanel();

		this.add(pnDados, BorderLayout.NORTH);
		this.add(pnCPU, BorderLayout.SOUTH);
		this.add(pnDetalhes, BorderLayout.CENTER);

		

//Definição de Layout
		pnDados.setBackground(new Color(126,180,146));
		pnCPU.setBackground(new Color(176,230,196));

		pnDetalhes.setLayout(new GridLayout(2,2));

//Labels
		this.lbProcessos = new JLabel("Processos");
		this.lbCPU = new JLabel("CPU : Ocupada");

		this.lbNomeProcesso = new JLabel("Nome do processo: ");
		this.lbQuantumFila = new JLabel("Quantum da Fila: ");
		this.lbBurstRestante = new JLabel("Burst do processo restante: ");
		this.lbIdProcesso = new JLabel("Id do processo: ");

//Adição de Labels
		pnDados.add(this.lbProcessos);
		pnCPU.add(this.lbCPU);

		pnDetalhes.add(lbNomeProcesso, 0, 0);
		pnDetalhes.add(lbIdProcesso, 1, 0);
		pnDetalhes.add(lbBurstRestante, 0, 1);
		pnDetalhes.add(lbQuantumFila, 1, 1);





		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.start();
	}
 
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(200);
			}
			catch(InterruptedException ex)
			{
				System.out.print(ex);
			}
			//System.out.println("Rodando");
			if(this.cpu.getOcupado())
			{
				lbCPU.setText("CPU : Ocupado");
				lbIdProcesso.setText("Id do processo: "+escalonador.processo.getId());
				lbQuantumFila.setText("Quantum da fila: "+escalonador.getNumeroFila()+" : "+escalonador.getQuantumFila());
				lbBurstRestante.setText("Burst do processo "+escalonador.processo.getNome()+" : "+escalonador.processo.getBurst());
				lbNomeProcesso.setText("Nome do processo: "+escalonador.processo.getNome());
			}
			else
			{
				lbCPU.setText("CPU : Ociosa");
				lbIdProcesso.setText("Id do processo: Inexistente");
				lbQuantumFila.setText("Quantum da fila abobora: Inexistente");
				lbBurstRestante.setText("Burst do processo : Inexistente");
				lbNomeProcesso.setText("Nome do processo: Inexistente");
			}
			
		}
	}

	public void start()
	{
		Thread t1 = new Thread(this);
		t1.start();
	}
}