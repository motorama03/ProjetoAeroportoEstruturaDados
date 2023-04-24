package ProjetoAeroporto;


public class Fila {
    private Nodo inicio = null;
    private Nodo fim;
    private int tempo;
    private int duracao;
//    private int limite = 5;
//    private int tamanho = 0;

    public Fila() {
    
    }
	public Fila(int tempo) {
    	this.tempo = tempo;
    }
    
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
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
//    public boolean temEspaco() {
//        return limite > tamanho;
//    }
    public int getInicio() {
        if(!estaVazio()) {
            return inicio.getDado();
        }else {
            System.out.println("Fila está vazia!");
            return -1;
        }
    }
    public void inserir(int dado, int tempo) {
//        if(temEspaco()) {
            Nodo novo = new Nodo(dado, tempo);
            if(estaVazio()) {
                inicio = novo;
                fim = novo;
            }else {
                fim.setProx(novo);
                fim = novo;
            }
//        }else {
//            System.out.println("Fila cheia!");
//        }
    }
    // Inserir para a distribuição das filas
    public void inserir(int dado) {
//        if(temEspaco()) {
            Nodo novo = new Nodo(dado, tempo);
            if(estaVazio()) {
                inicio = novo;
                fim = novo;
            }else {
                fim.setProx(novo);
                fim = novo;
            }
//        }else {
//            System.out.println("Fila cheia!");
//        }
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
    
    public Nodo verificaCondicoesTempo() {
    	if(estaVazio())return null;
    	Nodo aux = inicio;
    	Nodo menos = new Nodo();
    	do {
    		if(aux == inicio) {
    			menos = aux;
    		}else
    			if(aux.getTempo() < menos.getTempo()) {
    				menos = aux;
    			}
    		aux = aux.getProx();
    	}while(aux != null);
    	System.out.println("O avião com menos combústivel possui a identificação: "+menos.getDado());
    	return menos;
    	
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
    	if(fila.contaFila() >= 5 ) {
    		filaCheia = true;
    	}else
    		filaCheia = false;
    	
    	return filaCheia;
    }
}