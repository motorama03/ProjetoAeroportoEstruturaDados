package ProjetoAeroporto;


public class Fila {
    private Nodo inicio = null;
    private Nodo fim;

    public Fila() {
    
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
            Nodo novo = new Nodo(dado);
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
    		aux = aux.getProx();
    	}while(aux != null);
    	return;
    }
    public Nodo verificaCondicoesTempo() {
    	if(estaVazio())return null;
    	Nodo aux = inicio;
    	Nodo menos = inicio;
    	if(aux.getDado() == 0)return null;
    	do {
    		if(aux.getTempo() < menos.getTempo() && aux.getTempo() <= 3) {
    			menos = aux;
    		}else
    			aux = aux.getProx();
    	}while(aux != null);
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
    	if(fila.contaFila() >= 10 ) {
    		filaCheia = true;
    	}else
    		filaCheia = false;	
    	return filaCheia;
    }
    public int pousoEmergencia(Fila fila) {
    	if(estaVazio())return 0;
    	Nodo aux = inicio;
    	int count = 0;
    	int entupe = 0;
    	do {
    		if(aux.getTempo() <= 2) {
    			System.out.println("O aviao cujo id é "+aux.getDado()+" teve um pouso de emergência");
    			removePorNodo(aux);
    			entupe =+ 1;
    			count++;
    		}
    		aux = aux.getProx();
    	}while(aux != null && entupe != 2);
    	return count;
    }
    public String montaTabela() {
    	String tabela = "//---------------------------------------||---------------------------------------//";
    	return tabela;
    }
    public boolean tempoBaixo() {
    	if(estaVazio())return false;
    	boolean tem = false;
    	Nodo aux = inicio;
    	do {
    		if(aux.getTempo() <= 4)
    			tem = true;
    		aux = aux.getProx();
    	}while(aux != null);
    	return tem;
    	
    }
    public boolean tempoAlto() {
    	if(estaVazio())return false;
    	boolean tem = false;
    	Nodo aux = inicio;
    	do {
    		if(aux.getTempo() >= 15)
    			tem = true;
    		if(aux.getTempo() <= 8)return false;
    		aux = aux.getProx();
    	}while(aux != null);
    	return tem;
    }
    public int tamanhoFila() {
    	int count = 0;
    	if(estaVazio())return count;
    	Nodo aux = inicio;
    	do {
    		count ++;
    		aux = aux.getProx();
    	}while(aux != null);
    	return count;
    }
    public float somaPeriodo() {
    	if(estaVazio())return 0;
    	Nodo aux = inicio;
    	float count = 0;
    	do {
    		count =+ aux.getTempo();
    		aux = aux.getProx();
    	}while(aux != null);
    	System.out.println(count);
    	return count;
    }
}