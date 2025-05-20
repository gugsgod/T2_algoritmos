import java.time.LocalTime;
import java.util.Arrays;

public class Fila {
    Documento[] dados;
    int primeiro, ultimo, ocupacao;
    public Fila (int capacidade) {
        dados = new Documento[capacidade];
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }
    public Fila () {
        this(10);
    }
    public boolean filaVazia() {
        return ocupacao == 0;
    }
    public boolean filaCheia() {
        return ocupacao == dados.length;
    }
    private int proximaPosicao (int posicao) { //constroi a estrutura circular
        return (posicao + 1) % dados.length;
    }
    public void enfileira (Documento e) {
        if (filaCheia()) throw new RuntimeException("falha no enfileiramento");
        dados[ultimo] = e;
        ultimo = proximaPosicao(ultimo);
        ocupacao++;
    }
    public Documento desenfileira () {
        if (filaVazia()) throw new RuntimeException("falha no desenfileiramento");
        Documento temp = dados[primeiro];
        primeiro = proximaPosicao(primeiro);
        ocupacao--;
        return temp;
    }
    @Override
    public String toString() {
        if (filaVazia()) return "fila vazia";
        String s = "";
        for (int i=primeiro, cont=0; cont < ocupacao; cont++, i = proximaPosicao(i)) {
            s = s + dados[i] + " ";
        }
        return s;
    }
    public String toStringVetor () {
        String s = "";
        int i;
        if (filaVazia())
            for (i=0; i < dados.length; i++)
                s += "_ ";
        else if (filaCheia())
            for (i=0; i < dados.length; i++)
                s += dados[i] + " ";
        else if (primeiro < ultimo) {
            for (i=0; i<primeiro; i++)
                s += "_ ";
            for (i=primeiro; i<ultimo; i++)
                s += dados[i] + " ";
            for (i=ultimo; i<dados.length; i++)
                s += "_ ";
        }
        else {
            for (i=0; i<ultimo; i++)
                s += dados[i] + " ";
            for (i=ultimo; i<primeiro; i++)
                s += "_ ";
            for (i=primeiro; i<dados.length; i++)
                s += dados[i] + " ";
        }
        return s;
    }

}

class Documento{
    private String nome;
    private String usuario;
    private LocalTime horaSolicitacao;

    Documento(String n, String u){
        this.nome = n;
        this.usuario = u;
        this.horaSolicitacao = LocalTime.now();
    }
    
    @Override
    public String toString() {
        String string = this.nome + "   " + this.usuario + "   " + horaSolicitacao.toString();
        return string;
    }
}