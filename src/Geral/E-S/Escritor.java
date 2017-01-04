//Escritor
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.PrintWriter;
import java.FileReader;
import java.FileWriter;

import java.io.IOException;
import java.io.File;

public class Escritor
{
	public static void Escreve(String nomeArquivo, String conteudo)
	{
		File arquivo = new File(nomeArquivo);
		if(!arquivo.exists())
		{
			arquivo.CreateNewFile();
		}
		PrintWriter saida = new PrintWriter(new BufferedWriter(new FileWriter(nomeArquivo, true)));
		saida.print(conteudo+"\n");
		saida.close();
	}
}