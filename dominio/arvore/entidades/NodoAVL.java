package arvore.entidades;

public class NodoAVL extends Nodo {
	private int FatorDeBalanceamento;
	
	public NodoAVL()
	{
		setFilhoDaEsquerda(null);
		setFilhoDaDireita(null);
		setFatorDeBalanceamento(0);
	}
	
	public int getFatorDeBalanceamento() {
		return FatorDeBalanceamento;
	}
	
	public void setFatorDeBalanceamento(int fatorDeBalanceamento) {
		FatorDeBalanceamento = fatorDeBalanceamento;
	}
}
