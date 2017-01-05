package Geral;
//Leitor
import java.io.BufferedReader;
import java.io.FileReader;

public class Leitor {
//Construtor
//Destrutor
//Getters
//Setters
//Comandos
	public static LerArquivo(){
		FileReader fileR;
		BufferedReader buff;
		fileR = new FileReader("arquivo.txt");
		buff = new BufferedReader(fileR);
		while(buff.ready())
		{
			buff.readLine();
		}
	}

}
