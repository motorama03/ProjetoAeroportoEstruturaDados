//package ProjetoAeroporto;
//
//public class ListaDuplamenteEncadeadaAeroporto {
//	
//	private Nodo inicio;
//	private Nodo fim;
////	private int periodo;
//	
//	public ListaDuplamenteEncadeadaAeroporto(Nodo ant, Nodo prox) {
//		this.inicio = null;
//		this.fim = null;
//	}
//	public ListaDuplamenteEncadeadaAeroporto() {
//		
//	}
//	
//	
//	public Nodo getInicio() {
//		return inicio;
//	}
//	public void setInicio(Nodo inicio) {
//		this.inicio = inicio;
//	}
//	public Nodo getFim() {
//		return fim;
//	}
//	public void setFim(Nodo fim) {
//		this.fim = fim;
//	}
//
//
//	public void inserirInicio(int dado) {
//		Nodo novo = new Nodo(dado);
//		if(inicio != null) {
//			inicio.setAnt(novo);
//			novo.setProx(inicio);
//		}
//		inicio = novo;
//		if(fim == null) {
//			fim = novo;
//		}
//	}
//	
//	public void inserirFinal(int dado) {
//		Nodo novo = new Nodo(dado);
//		if(fim != null) {
//			fim.setProx(novo);
//			novo.setAnt(fim);
//		}
//		fim = novo;
//		if(inicio == null) {
//			inicio = novo;
//		}
//	}
//	
//	public void removerInicio() {
//		Nodo nodoRemovido = inicio;
//		if(inicio == null)return;
//		
//		inicio = inicio.getProx();
//		if(inicio != null) {
//			inicio.setAnt(null);
//		}
//		if(nodoRemovido == fim) {
//			removerFinal();
//		}
//		
//	}
//	
//	public void removerFinal() {
//		Nodo nodoRemovido = fim;
//		if(fim == null)return;
//		
//		fim = fim.getAnt();
//		if(fim != null) {
//			fim.setProx(null);
//		}
//		if (nodoRemovido == inicio) {
//			removerInicio();
//		}
//	}
//	
//	public void removeComValor(int dado) {
//		Nodo nodoRemovido = null;
//		Nodo aux = inicio;
//		while(aux != null) {
//			if(aux.getDado() == dado) {
//				nodoRemovido = aux;
//				break;
//			}
//			aux = aux.getProx();
//		}
//		if(nodoRemovido == null)return;
//		
//		if (nodoRemovido == inicio) {
//			removerInicio();
//		}else if(nodoRemovido == fim) {
//			removerFinal();
//		}else {
//			nodoRemovido.getAnt().setProx(nodoRemovido.getProx());
//			nodoRemovido.getProx().setAnt(nodoRemovido.getAnt());
//		}
//	}
//	
//	public void mostrarLista() {
//		StringBuilder lista = new StringBuilder();
//		lista.append(" ");
//	    Nodo atual = inicio;
//	    while (atual != null) {
//	        lista.append("ID avião: "+atual.getDado()+" Combústivel do avião: "+atual.getCombus() + "\n");
//	        atual = atual.getProx();
//	    }
//	    System.out.println(lista);
//	}
//	
//	public int contaFila() {
//		
//		if(inicio == null) return 0;
//		int count = 0;
//		Nodo aux = inicio;
//		while(aux.getProx() != null) {
//			count ++;
//			aux = aux.getProx();
//		}
//		return count;
//	}
//	public void organizaVoando() {
//	    if (inicio == null) return;
//	    Nodo atual = inicio;
//	    Nodo proximo;
//	    int tamanho = contaFila();
//
//	    for (int i = 0; i < tamanho - 1; i++) {
//	        proximo = atual.getProx();
//	        for (int j = i; j < tamanho; j++) {
//	            if (atual.getCombus() > proximo.getCombus()) {
//	                int combusAtual = atual.getCombus();
//	                atual.setCombus(proximo.getCombus());
//	                proximo.setCombus(combusAtual);
//	            }
//	            proximo = proximo.getProx();
//	        }
//	        atual = atual.getProx();
//	    }
//	    // Reduz a gasolina a cada turno;
//	    Nodo aux = inicio;
//	    while (aux != null) {
//	        if (aux.getCombus() <= 2 && verificaVagaPouso()) {
//	            System.out.println(aux.getDado() + " acaba de pousar com " + aux.getCombus());
//	            removeComValor(aux.getDado());
//	        } else {
//	            aux.setCombus(aux.getCombus() - 1);
//	            aux = aux.getProx();
//	        }
//	    }
//	}
//	
//	public void organizarPousada() {
//		if (inicio == null) return;
//	    Nodo atual = inicio;
//	    Nodo proximo;
//	    int tamanho = contaFila();
//
//	    for (int i = 0; i < tamanho - 1; i++) {
//	        proximo = atual.getProx();
//	        for (int j = i; j < tamanho; j++) {
//	            if (atual.getCombus() < proximo.getCombus()) {
//	                int combusAtual = atual.getCombus();
//	                atual.setCombus(proximo.getCombus());
//	                proximo.setCombus(combusAtual);
//	            }
//	            proximo = proximo.getProx();
//	        }
//	        atual = atual.getProx();
//	    }
//	    
//	    // Abastece a cada turno
//	    Nodo aux = inicio;
//	    do {
//	    	while(aux != null) {
//	    		System.out.println(2);
//	    		organizaVoando();
//	    		if(aux.getCombus() != 5)
//	    			aux.setCombus(aux.getCombus()+1);
//	    		aux = aux.getProx();
//	    	}
//	    }while(inicio != null);
//	}
//	
//	public boolean verificaVagaPouso() {
//		if(inicio == null) return true;
//		int count = 1;
//		Nodo aux = inicio;
//		boolean vaga = false;
//		while(count < 5 && vaga != true) {
//			count ++;
//			if(aux.getProx() != null) vaga = false;
//			else vaga = true;
//			aux = aux.getProx();
//		}
//		return vaga;
//	}
//	
//	
////	public String funcionandoAeroporto() {
////		
////	}
//	
//	
//	
//	
//}
