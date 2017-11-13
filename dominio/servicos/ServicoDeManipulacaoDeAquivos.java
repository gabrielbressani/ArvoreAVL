package servicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import arvore.interfaces.INodo;

public final class ServicoDeManipulacaoDeAquivos {
	
	/**
	  *
	  * As chaves devem ser inseridas em linhas, separadas por um espaço.
	  * Exemplo: 1 2 3 4
	  * 
	  */
	private static String CaminhoDoArquivoDeLeitura = "/home/gabrielbressani/Documents/chaves.txt";
	
	private static String CaminhoDoArquivoDeEscrita = "/home/gabrielbressani/Documents/arvore.txt";
	
	private ServicoDeManipulacaoDeAquivos() { }
	
	public static String[] ObterChavesASeremInseridasEmArquivo() throws IOException
	{
		String chavesASeremInseridas[] = null;
		
		FileReader arquivo = new FileReader(CaminhoDoArquivoDeLeitura);
		
		BufferedReader bufferDeLeitura = new BufferedReader(arquivo);
		
		String linha = bufferDeLeitura.readLine(); 
		
		if (linha != null)		
			chavesASeremInseridas = linha.split(" ");
			 
		arquivo.close();
		
		return chavesASeremInseridas;
	}
	
	public static void ImprimirArvoreEmArquivo(ArrayList<INodo> nodosEmOrdem) throws IOException
	{
	    FileWriter arquivo = new FileWriter(CaminhoDoArquivoDeEscrita);
	    
	    PrintWriter printWriter = new PrintWriter(arquivo);
	 
	    printWriter.printf("Árvore com caminhamento em ordem:%n");
	    
	    for(INodo nodo: nodosEmOrdem)
	    	printWriter.printf("%d ", nodo.getChave());
	 
	    arquivo.close();
	}
}

