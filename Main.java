import java.time.LocalTime;

public class Main {
    static Fila fila = new Fila();
    public static void main (String[] args){
        adicionaDocumento("gustavo", "bomfim");
    }

    static void adicionaDocumento(String nome, String usuario){
        Documento documento = new Documento(nome, usuario);
        fila.enfileira(documento);
        System.out.println(fila.desenfileira());
    }
}