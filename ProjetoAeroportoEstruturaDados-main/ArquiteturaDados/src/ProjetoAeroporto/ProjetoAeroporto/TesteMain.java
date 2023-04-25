package ProjetoAeroporto;
import java.util.Random;
import java.util.Scanner;

public class TesteMain {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		
		Fila filaDecolagem = new Fila();
		Fila filaDecolagemPista2 = new Fila();
		Fila filaAterrissagem = new Fila();
		Fila filaAterrissagemPista2 = new Fila();
		
		Random r = new Random();
		int randola = 0;
		int randolaPista2 = 0;
		int countP = 0;
		int countI = 1;
		boolean filaCheia = false;
		System.out.println("Informe 1 se quiser rodar sistema");
		int rodar = entrada.nextInt();
		int aviaoAterrisagemUrgente = 0;
		float duracaoDec = 0, duracaoAte = 0, duracaoDec2 = 0, duracaoAte2 = 0; 
		
		while(rodar == 1) {
			System.out.println(filaAterrissagem.montaTabela());
			boolean ferrou = false;
			if(rodar == 1) {
				int anteriorAttUrgencia = aviaoAterrisagemUrgente; 
				aviaoAterrisagemUrgente += filaAterrissagem.pousoEmergencia(filaAterrissagem);
				aviaoAterrisagemUrgente += filaAterrissagemPista2.pousoEmergencia(filaAterrissagemPista2);
				if(aviaoAterrisagemUrgente > anteriorAttUrgencia) ferrou = true;
				filaCheia = filaDecolagem.verificaGargaloFila(filaCheia, filaDecolagem);
				if(filaCheia)
					randola = r.nextInt(0, 1);
				else
					randola = r.nextInt(0, 3);
				
				for(int x = 0; x < randola; x++) {
					countP = countP + 2;
					int anyTime = r.nextInt(3, 21);
					filaDecolagem.inserir(countP, anyTime);
					duracaoDec ++;
					x++;
				}
				// Método responsável por verificar quantidade presente em fila
				filaCheia = filaAterrissagem.verificaGargaloFila(filaCheia, filaAterrissagem);
				if(filaCheia)
					randola = r.nextInt(0, 1);
				else
					randola = r.nextInt(0, 3);
				
				for(int x = 0; x < randola; x++) {
					countI = countI +2;
					int anyTime = r.nextInt(2, 21);
					filaAterrissagem.inserir(countI, anyTime);
					duracaoAte++;
					x++;
				}
// PISTA 2 !!!
//				Nodo auxPista2 = new Nodo();
//				auxPista2 = filaAterrissagemPista2.verificaCondicoesTempo();
				}
				// Método responsável por verificar quantidade presente em fila
				filaCheia = filaDecolagemPista2.verificaGargaloFila(filaCheia, filaDecolagemPista2);
				if(filaCheia)
					randola = r.nextInt(0, 1);
				else
					randola = r.nextInt(0, 3);
				
				for(int x = 0; x < randola; x++) {
					countP = countP + 2;
					int anyTime = r.nextInt(8, 21);
					filaDecolagemPista2.inserir(countP, anyTime);	
					duracaoDec2 ++;
					x++;
				}
				// Método responsável por verificar quantidade presente em fila
				filaCheia = filaAterrissagemPista2.verificaGargaloFila(filaCheia, filaAterrissagemPista2);
				if(filaCheia)
					randola = r.nextInt(0, 1);
				else
					randola = r.nextInt(0, 3);				
				for(int x = 0; x < randola; x++) {
					countI = countI +2;
					int anyTime = r.nextInt(8, 21);
					filaAterrissagemPista2.inserir(countI, anyTime);
					duracaoAte2++;
					x++;
				}				
				filaDecolagem.mostrarFila();				
// Desta parte em diante começa a "exclusão" de aviões da fila;
				if(!ferrou) {
					randola = r.nextInt(1, 3);
					randolaPista2 = r.nextInt(1, 3);
					// Campo de verificação caso o número sortido indique uma fila vazia. {
					if((filaDecolagem.estaVazio() || filaAterrissagem.tempoBaixo()) && randola == 2 )
						randola = 1;
					else
						if((filaAterrissagem.estaVazio() || filaAterrissagem.tempoAlto()) && randola != 2)
							randola = 2;
					if((filaDecolagemPista2.estaVazio() || filaAterrissagemPista2.tempoBaixo()) && randolaPista2 == 2)
						randolaPista2 = 1;
					else
						if((filaAterrissagemPista2.estaVazio() || filaAterrissagemPista2.tempoAlto()) && randolaPista2 == 1)
							randolaPista2 = 2;
					//}		
						System.out.println(randola);
					if(randola == 2) {
						System.out.println("O avião de id: "+filaDecolagem.remover()+" decolou da  pista 1!");
					}if(randola == 1) {
							Nodo menos = filaAterrissagem.verificaCondicoesTempo();
							if(menos != null) {
								filaAterrissagem.removePorNodo(menos);
								System.out.println("O avião de id: "+menos.getDado()+" aterrissou na pista 1!");
							}
						}
					}if(randolaPista2 == 2) {
						System.out.println("O aviao de id: "+filaDecolagemPista2.remover()+" decolou da pista 2!");
					}if(randolaPista2 == 1) {
						for(int x = 0; x < 1; x++) {
							Nodo menosPista2 = filaAterrissagemPista2.verificaCondicoesTempo();
							if(menosPista2 != null) {
								filaAterrissagemPista2.removePorNodo(menosPista2);
								System.out.println("O avião de id: "+menosPista2.getDado()+" aterrissou na pista 2!");
							}
						}
					}
					
					filaAterrissagem.aumentaDuracao(); 
					filaAterrissagemPista2.aumentaDuracao(); 
					filaDecolagem.aumentaDuracao(); 
					filaDecolagemPista2.aumentaDuracao();
				
				filaAterrissagem.diminuiTempo();
				filaAterrissagemPista2.diminuiTempo();
				filaAterrissagem.mostrarFila();
				filaAterrissagemPista2.mostrarFila();
				filaDecolagem.mostrarFila();
				filaDecolagemPista2.mostrarFila();			
				System.out.println(filaAterrissagem.montaTabela());
				System.out.println("Informe 1 se desejar continuar");	
				rodar = entrada.nextInt();	
		}		
		
		
		System.out.println("\n \n \n A quantidade aviões que tiveram pouso de emergência foram "+aviaoAterrisagemUrgente);
//		System.out.println("O tempo médio de aterrissagens é "+tempoAterrissagem / tempoT+" aviões por período");
//		System.out.println("O tempo médio de decolagens é "+tempoDecolagem / tempoT+ " aviões por período \n");
		System.out.println("As listas de aviões que 'restaram' nas filas de aterrisagem da pista 1 é ");filaAterrissagem.mostrarFila();
		System.out.println("\n As listas de aviões que 'restaram' nas filas de decolagem da pista 1 é ");filaDecolagem.mostrarFila();
		System.out.println("\n As listas de aviões que 'restaram' nas filas de aterrisagem da pista 2 é ");filaAterrissagemPista2.mostrarFila();
		System.out.println("\n As listas de aviões que 'restaram' nas filas de decolagem da pista 2 é ");filaDecolagemPista2.mostrarFila();
		System.out.println("\n A média de aterrissagem de aviões na fila 1 é " + filaAterrissagem.somaPeriodo() / duracaoAte +" aviões por período");
		System.out.println("\n A média de decolagens de aviões na fila 1 é " + filaDecolagem.somaPeriodo() / duracaoDec +" aviões por período");
		System.out.println("\n A média de aterrissagem de aviões na fila 2 é " + filaAterrissagemPista2.somaPeriodo() / duracaoAte2 +" aviões por período");
		System.out.println("\n A média de decolagens de aviões na fila 2 é " + filaDecolagemPista2.somaPeriodo() / duracaoDec2 +" aviões por período");
		entrada.close();
	}
}
	