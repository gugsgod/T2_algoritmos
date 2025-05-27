import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Fila fila = new Fila();
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
                    fila.filaPrint();
		    break;
                default:
                    continue; 
            }
        }
    }

    static void adicionaDocumento(Fila filaAtual, String nome, String usuario){
        filaAtual.enfileiraDoc(nome, usuario);
    }

    static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Adicionar documento a fila\n2 - Imprimir documento\n3 - Consultar documento\n0 - Sair");
        int select = scanner.nextInt();
        return select;
    }
}
