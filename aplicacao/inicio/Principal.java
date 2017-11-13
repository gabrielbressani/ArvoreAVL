package inicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import arvore.entidades.ArvoreAVL;
import arvore.interfaces.INodo;
import servicos.ServicoDeManipulacaoDeAquivos;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		Random random = new Random();	
		int chaveRandomica =  random.nextInt(10);
		
		String[] chavesASeremInseridas = ServicoDeManipulacaoDeAquivos
			.ObterChavesASeremInseridasEmArquivo();

		ArvoreAVL arvoreAVL = new ArvoreAVL();
		
		for(String chave: chavesASeremInseridas)
			arvoreAVL.InserirNodoPelaChave(Integer.parseInt(chave));
		
		INodo nodoEncontradoPelaBusca = arvoreAVL
			.EncontrarNodoPelaChave(chaveRandomica);
		
		arvoreAVL
			.RemoverNodoPelaChave(chaveRandomica);
		
		arvoreAVL
			.AtualizarNodo(nodoEncontradoPelaBusca, chaveRandomica);
		
		ArrayList<INodo> nodosEmOrdem = arvoreAVL.ObterNodosEmOrdem();

		ServicoDeManipulacaoDeAquivos
			.ImprimirArvoreEmArquivo(nodosEmOrdem);
	}
}
