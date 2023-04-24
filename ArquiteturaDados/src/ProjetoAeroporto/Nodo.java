package ProjetoAeroporto;


public class Nodo {
	
	private int dado;
	private int tempo;
	private Nodo prox;
//	private Nodo ant;
	
	public Nodo() {
		
	}
	public Nodo(int dado, int tempo) {
		this.dado = dado;
		this.tempo = tempo;
		this.prox = null;
		
	}
	public Nodo(int dado) {
		this.dado = dado;
		this.prox = null;
		
	}
	public Nodo(int dado, Nodo prox, int combus, int tempoV) {
		this.dado = dado;
		this.prox = null;
		
	}
//	public Nodo(int dado) {
//		prox = null;
//		ant = null;
//		this.dado = dado;
//	}
	
	
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempoV) {
		this.tempo = tempoV;
	}
	public int getDado() {
		return dado;
	}
	public void setDado(int dado) {
		this.dado = dado;
	}
	public Nodo getProx() {
		return prox;
	}
	public void setProx(Nodo prox) {
		this.prox = prox;
	}
//	public Nodo getAnt() {
//		return ant;
//	}
//	public void setAnt(Nodo ant) {
//		this.ant = ant;
//	}
	
	
	
}
