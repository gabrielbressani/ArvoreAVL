package arvore.entidades;

import arvore.interfaces.INodo;

public abstract class Nodo implements INodo {
	protected int Chave;
	protected INodo Pai;
	protected INodo FilhoDaEsquerda;
	protected INodo FilhoDaDireita;
	
	@Override
	public INodo getPai() {
		return Pai;
	}

	@Override
	public void setPai(INodo nodo) {
		Pai = nodo;
	}

	@Override
	public INodo getFilhoDaEsquerda() {
		return FilhoDaEsquerda;
	}

	@Override
	public void setFilhoDaEsquerda(INodo nodo) {
		FilhoDaEsquerda = nodo;
	}

	@Override
	public INodo getFilhoDaDireita() {
		return FilhoDaDireita;
	}

	@Override
	public void setFilhoDaDireita(INodo nodo) {
		FilhoDaDireita = nodo;
	}

	@Override
	public int getChave() {
		return Chave;
	}

	@Override
	public void setChave(int chave) {
		Chave = chave;
	}
}
