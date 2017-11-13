package servicos;

import arvore.interfaces.IArvoreBinaria;
import arvore.interfaces.INodo;
import arvore.entidades.NodoAVL;

public final class ServicoDeBalanceamentoAVL {
	
	private ServicoDeBalanceamentoAVL() { }
	
	public static void SetarFatorDeBalancementoDoNodo(NodoAVL nodo) {
		int fatorDeBalanceamentoDoNodo = 
				ObterAlturaDoNodo(nodo.getFilhoDaDireita()) -
				ObterAlturaDoNodo(nodo.getFilhoDaEsquerda());
		
		nodo.setFatorDeBalanceamento(fatorDeBalanceamentoDoNodo);
	}	

	public static void BalancearArvoreCasoNecessario(IArvoreBinaria arvore, NodoAVL nodoVisitado) {
		
		SetarFatorDeBalancementoDoNodo(nodoVisitado);
		
		if(nodoVisitado.getFatorDeBalanceamento() == -2)
		{
			if (ObterAlturaDoNodo(ObterMenorNetoDoMenorFilho(nodoVisitado)) >=
				ObterAlturaDoNodo(ObterMaiorNetoDoMenorFilho(nodoVisitado)))
			{
				nodoVisitado = rotacaoSimplesADireita(nodoVisitado);
			}
			else
			{
				nodoVisitado = RotacaoDuplaEsquerdaDepoisDireita(nodoVisitado);
			}
		}
		else if(nodoVisitado.getFatorDeBalanceamento() == 2)
		{
			if (ObterAlturaDoNodo(ObterMaiorNetoDoMaiorFilho(nodoVisitado)) >=
				ObterAlturaDoNodo(ObterMenorNetoDoMaiorFilho(nodoVisitado)))
			{
				nodoVisitado = rotacaoSimplesAEsquerda(nodoVisitado);
			}
			else
			{
				nodoVisitado = RotacaoDuplaDireitaDepoisEsquerda(nodoVisitado);
			}
		}
		
		if (nodoVisitado.getPai() != null)
		{
			BalancearArvoreCasoNecessario(arvore, (NodoAVL)nodoVisitado.getPai());
		}
		else
		{
			arvore.setRaiz(nodoVisitado);
		}
		
	}
	
	private static NodoAVL ObterMenorNetoDoMenorFilho(NodoAVL nodoVisitado)
	{
		return (NodoAVL)nodoVisitado.getFilhoDaEsquerda().getFilhoDaEsquerda();
	}
	
	private static NodoAVL ObterMaiorNetoDoMenorFilho(NodoAVL nodoVisitado)
	{
		return (NodoAVL)nodoVisitado.getFilhoDaEsquerda().getFilhoDaDireita();
	}
	
	private static NodoAVL ObterMaiorNetoDoMaiorFilho(NodoAVL nodoVisitado)
	{
		return (NodoAVL)nodoVisitado.getFilhoDaDireita().getFilhoDaDireita();
	}
	
	private static NodoAVL ObterMenorNetoDoMaiorFilho(NodoAVL nodoVisitado)
	{
		return (NodoAVL)nodoVisitado.getFilhoDaDireita().getFilhoDaEsquerda();
	}
	
	private static NodoAVL rotacaoSimplesADireita(NodoAVL nodoVisitado)
	{
		NodoAVL nodoFilhoDaEsquerda = (NodoAVL)nodoVisitado.getFilhoDaEsquerda();
		
		nodoFilhoDaEsquerda.setPai(nodoVisitado.getPai());

		nodoVisitado.setFilhoDaEsquerda(nodoFilhoDaEsquerda.getFilhoDaDireita());

		if (nodoVisitado.getFilhoDaEsquerda() != null) {
			nodoVisitado.getFilhoDaEsquerda().setPai(nodoVisitado);
		}

		nodoFilhoDaEsquerda.setFilhoDaDireita(nodoVisitado);
		nodoVisitado.setPai(nodoFilhoDaEsquerda);

		if (nodoFilhoDaEsquerda.getPai() != null) {

			if (nodoFilhoDaEsquerda.getPai().getFilhoDaDireita() == nodoVisitado) {
				nodoFilhoDaEsquerda.getPai().setFilhoDaDireita(nodoFilhoDaEsquerda);
			
			} else if (nodoFilhoDaEsquerda.getPai().getFilhoDaEsquerda() == nodoVisitado) {
				nodoFilhoDaEsquerda.getPai().setFilhoDaEsquerda(nodoFilhoDaEsquerda);
			}
		}

		SetarFatorDeBalancementoDoNodo(nodoVisitado);
		SetarFatorDeBalancementoDoNodo(nodoFilhoDaEsquerda);

		return nodoFilhoDaEsquerda;
	}
	
	private static NodoAVL rotacaoSimplesAEsquerda(NodoAVL nodoVisitado)
	{
		NodoAVL nodoFilhoDaDireita = (NodoAVL)nodoVisitado.getFilhoDaDireita();
		
		nodoFilhoDaDireita
			.setPai(nodoVisitado.getPai());
		
		nodoVisitado
			.setFilhoDaDireita(nodoFilhoDaDireita.getFilhoDaEsquerda());
		
		if (nodoVisitado.getFilhoDaDireita() != null) 
			nodoVisitado.getFilhoDaDireita().setPai(nodoVisitado);

		nodoFilhoDaDireita.setFilhoDaEsquerda(nodoVisitado);
		nodoVisitado.setPai(nodoFilhoDaDireita);

		if (nodoFilhoDaDireita.getPai() != null) 
		{
			if (nodoFilhoDaDireita.getPai().getFilhoDaDireita() == nodoVisitado)
				nodoFilhoDaDireita.getPai()
					.setFilhoDaDireita(nodoFilhoDaDireita);
			 else if (nodoFilhoDaDireita.getPai().getFilhoDaEsquerda() == nodoVisitado)
				nodoFilhoDaDireita.getPai()
					.setFilhoDaEsquerda(nodoFilhoDaDireita);
		}

		SetarFatorDeBalancementoDoNodo(nodoVisitado);
		SetarFatorDeBalancementoDoNodo(nodoFilhoDaDireita);
		
		return nodoFilhoDaDireita;
	}
	
	public static NodoAVL RotacaoDuplaEsquerdaDepoisDireita(NodoAVL nodoVisitado) {
		
		NodoAVL nodoAEsquerda = rotacaoSimplesAEsquerda((NodoAVL)nodoVisitado.getFilhoDaEsquerda());
		
		nodoVisitado.setFilhoDaEsquerda(nodoAEsquerda);
		
		return rotacaoSimplesADireita(nodoVisitado);
	}

	public static NodoAVL RotacaoDuplaDireitaDepoisEsquerda(NodoAVL nodoVisitado) {
		NodoAVL nodoADireita = rotacaoSimplesADireita((NodoAVL)nodoVisitado.getFilhoDaDireita());
		
		nodoVisitado.setFilhoDaDireita(nodoADireita);
		
		return rotacaoSimplesAEsquerda(nodoVisitado);
	}
	
	public static int ObterAlturaDoNodo(INodo nodo)	{
		
		if (nodo == null)
		{
			return -1;			
		}
		else if (nodo.getFilhoDaEsquerda() == null && nodo.getFilhoDaDireita()== null)
		{
			return 0;			
		}
		else if (nodo.getFilhoDaEsquerda() == null)
		{
			return 1 + ObterAlturaDoNodo(nodo.getFilhoDaDireita());			
		}
		else if (nodo.getFilhoDaDireita() == null) 
		{
			return 1 + ObterAlturaDoNodo(nodo.getFilhoDaEsquerda());
		
		} 
		else 
		{
			return 1 + Math.max(ObterAlturaDoNodo(nodo.getFilhoDaEsquerda()), 
					ObterAlturaDoNodo(nodo.getFilhoDaDireita()));
		}
	}
}
