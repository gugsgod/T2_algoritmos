import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Reimpressao {
  public static void main(String[] args) {
    Pilha pilha = new Pilha();
    Scanner scanner = new Scanner(System.in);
    String arquivo = null;
    String usuario = null;
    String procura = null;

    try {
      File file = new File("entrada.txt");

      Scanner arquivoData = new Scanner(file);
      ArrayList<String> linhas = new ArrayList<>();

      while(arquivoData.hasNextLine()) {
        String line = arquivoData.nextLine();
	linhas.add(line);
      }

      for (int i = 0; i < 20; i = i + 2) {
        adicionaDocumento(pilha, linhas.get(i), linhas.get(i+1));
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found.");
      e.printStackTrace();
    }
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
          System.out.print("Digite o nome do arquivo: ");
          procura = scanner.nextLine();
          Documento doc = pilha.consultarDocumento(procura);
          if (doc != null) {
              System.out.println(doc);
          } else {
            System.out.println("Documento não encontrado.");
          }
        
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
    scanner.nextLine(); 
    return select;

  }
}
