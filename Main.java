import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner();
    static Fila fila = new Fila();
    public static void main (String[] args){
        boolean loop = True;
        while (loop == True) {
            int opc = menu();
            switch(opc){
                case 0:
                    loop = False;
                    break;
            }
        }
        adicionaDocumento();
    }

    static void adicionaDocumento(String nome, String usuario){
        Documento documento = new Documento(nome, usuario);
        fila.enfileira(documento);
        System.out.println(fila.desenfileira());
    }

    static void menu() {
        System.out.println("1 - Adicionar documento a fila\n2 - Imprimir documento\n3 - Consultar documento\n0 - Sair");
        return scanner.nextLine();
    }
}