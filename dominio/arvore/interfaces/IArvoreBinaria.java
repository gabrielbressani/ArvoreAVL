package arvore.interfaces;

import java.util.ArrayList;

public interface IArvoreBinaria {
	INodo getRaiz();
	
	void setRaiz(INodo nodo);
	
	void InserirNodoPelaChave(int chave);
	
	void InserirNodo(INodo nodoVisitado, INodo nodoASerInserido);
	
	void AtualizarNodo(INodo nodo, int novaChave);
	
	void RemoverNodoPelaChave(int chave);
	
	boolean ArvoreEstaVazia();
	
	boolean DeveInserirAEsquerda(INodo nodoVisitado, INodo nodoASerInserido);
	
	boolean DeveInserirADireita(INodo nodoVisitado, INodo nodoASerInserido);
	
	boolean EsquerdaLivreParaInsercao(INodo nodo);
	
	boolean DireitaLivreParaInsercao(INodo nodo);
	
	INodo EncontrarNodoPelaChave(int chave);
	
	ArrayList<INodo> ObterNodosEmOrdem();
}
