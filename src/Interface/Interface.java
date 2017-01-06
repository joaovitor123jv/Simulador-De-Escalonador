import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;




public class Interface extends JFrame
{
	JLabel lbProcessos, lbCPU;
	JTable tbDados;
	JPanel pnCPU, pnDados;
	String header[];
	public Interface()
	{
//Definição de Interface
		super("Monitor de Processos (escalonador)");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);

//Painéis
		this.pnCPU = new JPanel();
		this.pnDados = new JPanel();

		this.add(pnDados, BorderLayout.NORTH);
		this.add(pnCPU, BorderLayout.SOUTH);

		

//Definição de Layout
		pnDados.setBackground(new Color(126,180,146));
		pnCPU.setBackground(new Color(176,230,196));

//Labels
		this.lbProcessos = new JLabel("Processos");
		this.lbCPU = new JLabel("CPU : Ocupada");

//Adição de Labels
		pnDados.add(this.lbProcessos);
		pnCPU.add(this.lbCPU);

//Tabelas
		header = new String[] { "Prority", "Task Title", "Start", "Pause", "Stop", "Statulses" };
		tbDados = new JTable();

		tbDados.setShowVerticalLines(true);
		tbDados.setCellSelectionEnabled(true);
		tbDados.setColumnSelectionAllowed(true);
		tbDados.addColumn(new TableColumn(header));


//Adição de Tabelas
		pnDados.add(this.tbDados, BorderLayout.CENTER);


		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
}