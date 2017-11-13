package arvore.entidades;

import java.util.ArrayList;

import arvore.interfaces.IArvoreBinaria;
import arvore.interfaces.INodo;

public abstract class ArvoreBinaria implements IArvoreBinaria {
	protected INodo Raiz;
	
	@Override
	public INodo getRaiz() {
		return Raiz;
	}

	@Override
	public void setRaiz(INodo nodo) {
		Raiz = nodo;
	}
		
	@Override
	public void InserirNodo(INodo nodoVisitado, INodo nodoASerInserido) {
		
		if(ArvoreEstaVazia()) {
			InserirNodoNaRaiz(nodoASerInserido);
		}
		else if (DeveInserirAEsquerda(nodoVisitado, nodoASerInserido)) {
			
			if(EsquerdaLivreParaInsercao(nodoVisitado))
				InserirNodoAEsquerda(nodoVisitado, nodoASerInserido);
			else
				InserirNodo(nodoVisitado.getFilhoDaEsquerda(), nodoASerInserido);
		}
		else if (DeveInserirADireita(nodoVisitado, nodoASerInserido)){
			
			if(DireitaLivreParaInsercao(nodoVisitado))
				InserirNodoADireita(nodoVisitado, nodoASerInserido);
			else
				InserirNodo(nodoVisitado.getFilhoDaDireita(), nodoASerInserido);
		}
	}
	
	protected void InserirNodoNaRaiz(INodo nodoASerInserido)
	{
		setRaiz(nodoASerInserido);
	}
	
	protected void InserirNodoAEsquerda(INodo nodoVisitado, INodo nodoASerInserido)
	{
		nodoVisitado
			.setFilhoDaEsquerda(nodoASerInserido);
		
		nodoASerInserido
			.setPai(nodoVisitado);
	}
	
	protected void InserirNodoADireita(INodo nodoVisitado, INodo nodoASerInserido)
	{
		nodoVisitado
			.setFilhoDaDireita(nodoASerInserido);
		
		nodoASerInserido
			.setPai(nodoVisitado);
	}
	
	@Override
	public boolean ArvoreEstaVazia() {
		boolean arvoreEstaVazia = false;
		
		if (Raiz == null)
			arvoreEstaVazia = true;
		
		return arvoreEstaVazia;
	}

	@Override
	public boolean DeveInserirAEsquerda(INodo nodoVisitado, INodo nodoASerInserido) {
		boolean deveInserirAEsquerda = false;
		
		if (nodoASerInserido.getChave() < nodoVisitado.getChave())
			deveInserirAEsquerda = true;
		
		return deveInserirAEsquerda;
	}

	@Override
	public boolean DeveInserirADireita(INodo nodoVisitado, INodo nodoASerInserido) {
		boolean deveInserirADireita = false;
		
		if (nodoASerInserido.getChave() > nodoVisitado.getChave())
			deveInserirADireita = true;
		
		return deveInserirADireita;
	}

	@Override
	public boolean EsquerdaLivreParaInsercao(INodo nodo) {
		boolean esquerdaLivreParaInsercao = false;
		
		if (nodo.getFilhoDaEsquerda() == null)
			esquerdaLivreParaInsercao = true;
		
		return esquerdaLivreParaInsercao;
	}

	@Override
	public boolean DireitaLivreParaInsercao(INodo nodo) {
		boolean direitaLivreParaInsercao = false;
		
		if (nodo.getFilhoDaDireita() == null)
			direitaLivreParaInsercao = true;
		
		return direitaLivreParaInsercao;
	}
	
	@Override
	public void AtualizarNodo(INodo nodo, int novaChave) {
		RemoverNodo(nodo);
		InserirNodoPelaChave(novaChave);
	}

	@Override
	public void RemoverNodoPelaChave(int chave) {
		INodo nodoASerRemovido = EncontrarNodoPelaChave(chave);
			
		if (nodoASerRemovido != null)
			RemoverNodo(nodoASerRemovido);
	}
	
	private void RemoverNodo(INodo nodoASerRemovido)
	{
		
	}

	@Override
	public INodo EncontrarNodoPelaChave(int chave) {
		return EncontrarNodoPelaChave(getRaiz(), chave);
	}
	
	private INodo EncontrarNodoPelaChave(INodo nodoDoContexto, int chave) {
		
		if (nodoDoContexto == null)
			return null;
		
		if (nodoDoContexto.getChave() ==  chave)
			return nodoDoContexto;
		
		if(nodoDoContexto.getChave() > chave)
			return EncontrarNodoPelaChave(nodoDoContexto.getFilhoDaEsquerda(), chave);
		
		return EncontrarNodoPelaChave(nodoDoContexto.getFilhoDaDireita(), chave);
	}
	
	@Override
	public ArrayList<INodo> ObterNodosEmOrdem() {
		ArrayList<INodo> nodosEmOrdem = new ArrayList<INodo>();
		
		CaminhamentoEmOrdem(getRaiz(), nodosEmOrdem);
		
		return nodosEmOrdem;
	}

	protected void CaminhamentoEmOrdem(INodo nodo, ArrayList<INodo> nodosEmOrdem) {
		if (nodo == null) 
			return;
		
		CaminhamentoEmOrdem(nodo.getFilhoDaEsquerda(), nodosEmOrdem);
		
		nodosEmOrdem.add(nodo);
		
		CaminhamentoEmOrdem(nodo.getFilhoDaDireita(), nodosEmOrdem);
	}

}
