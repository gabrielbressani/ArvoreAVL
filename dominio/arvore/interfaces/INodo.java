package arvore.interfaces;

public interface INodo {
	INodo getPai();
	void setPai(INodo nodo);
	
	INodo getFilhoDaEsquerda();
	void setFilhoDaEsquerda(INodo nodo);
	
	INodo getFilhoDaDireita();
	void setFilhoDaDireita(INodo nodo);
	
	int getChave();
	void setChave(int chave);
}