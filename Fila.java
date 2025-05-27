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
    public void enfileiraDoc (String nome, String usuario){
        Documento documento = new Documento(nome, usuario);
        System.out.println(documento);
        enfileira(documento);
    }
    public void filaPrint(String nome, int funcao){
        Documento[] listaDocs;
        int ocupacao = 0;
        if (funcao = 0) {
            for (int i = 0, count = 0, idx = primeiro; count < ocupacao; count++, idx = proximaPosicao(idx)){
                if (dados[idx].getNome() == nome){
                    listaDocs[ocupacao] = dados[idx];
                    ocupacao++;
                }
            }
            System.out.printf("Foram achados %d registros com esse usuário", ocupacao)
        }
        if (funcao = 1){
            for (int i = 0, count = 0, idx = primeiro; count < ocupacao; count++, idx = proximaPosicao(idx)){
                if (dados[idx].getUser() == nome){
                    listaDocs[ocupacao] = dados[idx];
                    ocupacao++;
                }
            }
            System.out.printf("Foram achados %d registros com esse usuário", ocupacao)

        }
            }
    public void desenfileira () {
        if (filaVazia()){
            System.out.println("Fila esta vazia");
            throw new RuntimeException("falha no desenfileiramento")
        };
        else {
            Documento temp = dados[primeiro];
            primeiro = proximaPosicao(primeiro);
            ocupacao--;
            System.out.println(temp);
        }
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
    private LocalTime horaImp;

    Documento(String n, String u){
        this.nome = n;
        this.usuario = u;
        this.horaSolicitacao = LocalTime.now();
    }
    
    public String getNome(){
        return this.nome;
    }

    public LocalTime horaImpressao(){
            this.horaImp = LocalTime.now();
        }

    @Override
    public String toString() {
        String string = this.nome + "   " + this.usuario  + "   " + horaSolicitacao.toString();
        return string;
    }

    
}
