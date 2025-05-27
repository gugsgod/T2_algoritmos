import java.util.Scanner;

public class Reimpressão {
  public static void main(String[] args) {
    Pilha pilha = new Pilha();
    Scanner scanner = new Scanner(System.in);
    String arquivo = null;
    String usuario = null;
    while (true) {
      int opc = menu();
      if (opc == 0) {
        break;
      }
      switch (opc) {
        case 1:
          System.out.println("Nome do arquivo: ");
          arquivo = scanner.nextLine();
          System.out.println("Nome do usuario: ");
          usuario = scanner.nextLine();
          scanner.close();
          try {
            adicionaDocumento(pilha, arquivo, usuario);
          } catch (Exception e) {
            System.out.println("erro" + e);
          }
          break;
        case 2:
          pilha.pop();
          break;
        case 3:
          pilha.consultarDocumento(arquivo);
          break;
        default:
          continue;
      }
    }
  }

  static void adicionaDocumento(Pilha pilhaAtual, String nome, String usuario) {
    pilhaAtual.push(nome, usuario);
  }

  static int menu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1 - Adicionar documento a pilha\n2 - Reimprimir documento\n3 - Consultar documento\n0 - Sair");
    int select = scanner.nextInt();
    scanner.close();
    return select;
  }
}
