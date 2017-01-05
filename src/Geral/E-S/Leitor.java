package Geral;
//Leitor
import java.io.BufferedReader;
import java.io.FileReader;

public class Leitor {
	
	FileReader fileR;
	BufferedReader buff;

//Construtor
	public Leitor (){
		fileR = new FileReader("arquivo.txt");
		buff = new BufferedReader(fileR);
		while(buff.ready()){
			buff.readLine();
		}
	}

}
