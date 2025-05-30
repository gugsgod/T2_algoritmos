import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Main {
    public static void main (String[] args){
        Fila fila = new Fila();
	
	
	try {
		File file = new File("entrada.txt");
	
		Scanner arquivoData = new Scanner(file);
		ArrayList<String> linhas = new ArrayList<>();
	
		while(arquivoData.hasNextLine()) {
			String line = arquivoData.nextLine();
			linhas.add(line);
		}
	
		for(int i = 0; i<20; i = i + 2){
			adicionaDocumento(fila, linhas.get(i), linhas.get(i+1));
		}
	}
	catch (FileNotFoundException e){
		System.out.println("File not found.");
        	e.printStackTrace();
	}
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int opc = menu();
            if (opc == 0) {
                break;
            }
            switch(opc){
                case 1:
                    System.out.println("Nome do arquivo: ");
                    String arquivo = scanner.nextLine(); 
                    System.out.println("Nome do usuario: ");
                    String usuario = scanner.nextLine(); 
                    try {
                        adicionaDocumento(fila, arquivo, usuario);
                    }
                    catch(Exception e) {
                        System.out.println("erro" + e);
                    }
		    break;
                case 2:
                    fila.desenfileira();
                    break;
                case 3:
		    System.out.println("Nome do arquivo:");
                    String nome = scanner.nextLine();
                    consultaFila(fila, nome);
		    break;
                default:
                    continue; 
            }
        }
    }

    static void adicionaDocumento(Fila filaAtual, String nome, String usuario){
        filaAtual.enfileiraDoc(nome, usuario);
    }

    static void consultaFila(Fila filaAtual, String nome){
        filaAtual.consultarFila(nome);
    }
    static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Adicionar documento a fila\n2 - Imprimir documento\n3 - Consultar documento\n0 - Sair");
        int select = scanner.nextInt();
        return select;
    }
}
