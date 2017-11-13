package arvore.entidades;

import arvore.interfaces.INodo;
import servicos.ServicoDeBalanceamentoAVL;

public class ArvoreAVL extends ArvoreBinaria {
	
	@Override
	public void InserirNodoPelaChave(int chave) {
		NodoAVL novoNodo = new NodoAVL();
		
		novoNodo.setChave(chave);
		
		InserirNodo(getRaiz(), novoNodo);
	}
	
	@Override
	protected void InserirNodoAEsquerda(INodo nodoVisitado, INodo nodoASerInserido)
	{	
		super.InserirNodoAEsquerda(nodoVisitado, nodoASerInserido);
		
		ServicoDeBalanceamentoAVL
			.BalancearArvoreCasoNecessario(this, (NodoAVL)nodoVisitado);
	}
	
	@Override
	protected void InserirNodoADireita(INodo nodoVisitado, INodo nodoASerInserido)
	{
		super.InserirNodoADireita(nodoVisitado, nodoASerInserido);

		ServicoDeBalanceamentoAVL
			.BalancearArvoreCasoNecessario(this, (NodoAVL)nodoVisitado);
		
	}
		
}