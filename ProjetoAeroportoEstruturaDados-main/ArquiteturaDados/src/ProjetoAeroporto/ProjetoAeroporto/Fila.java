package ProjetoAeroporto;


public class Fila {
    private Nodo inicio = null;
    private Nodo fim;
    private int tempo;
    
//    private int limite = 5;
//    private int tamanho = 0;

    public Fila() {
    
    }
	public Fila(int tempo) {
    	this.tempo = tempo;
    }
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
    public boolean estaVazio() {
    	if(inicio == null)return true;
    	else
    		return false;
    }

    public int getInicio() {
        if(!estaVazio()) {
            return inicio.getDado();
        }else {
            System.out.println("Fila está vazia!");
            return -1;
        }
    }
    public void inserir(int dado, int tempo) {
            Nodo novo = new Nodo(dado, tempo);
            if(estaVazio()) {
                inicio = novo;
                fim = novo;
            }else {
                fim.setProx(novo);
                fim = novo;
            }
    }
    public void inserir(int dado) {
            Nodo novo = new Nodo(dado, tempo);
            if(estaVazio()) {
                inicio = novo;
                fim = novo;
            }else {
                fim.setProx(novo);
                fim = novo;
            }
    }
    public Integer remover() {
        if(estaVazio()) {
            return null;
        }
        int valor = inicio.getDado();
        inicio = inicio.getProx();
        if(estaVazio()) {
            fim = null;
        }
        return valor;
    }
    public void separaFila(Fila F,Fila F_Par,Fila F_Impar) {

        while(!F.estaVazio()) {
            int num = F.remover();
            if(num % 2 == 0) {
                F_Par.inserir(num);
            }else {
                F_Impar.inserir(num);
            }
        }
    }
    public void mostrarFila() {
        Nodo aux = inicio;
        if (estaVazio()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Fila:");
            while (aux != null) {
                System.out.println("O avião " + aux.getDado() + " está com " + aux.getTempo() + " períodos para esgotar o combustível.");
                aux = aux.getProx();
            }
        }
    }
    public int contaFila() {
    	Nodo aux = inicio;
    	int count = 1;
    	if(estaVazio()) {
    		return 0;
    	}
    	while(aux.getProx() != null){
    		count++;
    		aux = aux.getProx();
    	}
    	return count;
    }
    public void diminuiTempo() {
    	if(estaVazio())return;
    	
    	Nodo aux = inicio;
    	do {
    		aux.setTempo(aux.getTempo()-1);
    		aux = aux.getProx();
    	}while(aux != null);
    	return;
    }
    public void aumentaDuracao() {
    	if(estaVazio())return;
    	Nodo aux = inicio;
    	do {
    		aux.setDuracao(aux.getDuracao()+1);
    		aux.getProx();
    	}while(aux != null);
    	return;
    }
    public Nodo verificaCondicoesTempo() {
    	if(estaVazio())return null;
    	Nodo aux = inicio;
    	if(aux.getDado() == 0)return null;
    	do {
    		if(aux == inicio && aux.getTempo() <= 5) {
    			return aux;
    		}else
    			aux = aux.getProx();
    	}while(aux != null);
    	return null;	
    }
    public void removePorNodo(Nodo nodo) {
        if (estaVazio()) return;
        if (nodo.equals(inicio)) {
            inicio = inicio.getProx();
            if (inicio == null) fim = null;
            return;
        }
        Nodo aux = inicio;
        while (aux.getProx() != null) {
            if (nodo.equals(aux.getProx())) {
                aux.setProx(aux.getProx().getProx());
                if (aux.getProx() == null) fim = aux;
                return;
            }
            aux = aux.getProx();
        }
    }
    public boolean verificaGargaloFila(boolean filaCheia, Fila fila) {	
    	if(estaVazio())return false;
    	filaCheia = false;
    	if(fila.contaFila() >= 2 ) {
    		filaCheia = true;
    	}else
    		filaCheia = false;	
    	return filaCheia;
    }
    public int pousoEmergencia(Fila fila) {
    	if(estaVazio())return 0;
    	Nodo aux = inicio;
    	int count = 0;
    	do {
    		if(aux.getTempo() <= 2) {
    			System.out.println("O aviao cujo id é "+aux.getDado()+" teve um pouso de emergência");
    			removePorNodo(aux);
    			count++;
    		}
    		aux = aux.getProx();
    	}while(aux != null);
    	return count;
    }
}