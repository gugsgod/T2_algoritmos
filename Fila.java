import java.time.LocalTime;
import java.util.Arrays;
import java.time.Duration;

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
        if (filaCheia()){
            System.out.println("Fila esta cheia, libere espaco na fila para adicionar mais arquivos.");
        }
        else {
        dados[ultimo] = e;
        ultimo = proximaPosicao(ultimo);
        ocupacao++;
        }
    }
    public void enfileiraDoc (String nome, String usuario){
        Documento documento = new Documento(nome, usuario);
        System.out.println(documento);
        enfileira(documento);
    }
    public void consultarFila(String nome){
        boolean achou = false;
        for(int index = 0;index < ocupacao;index++){
            if (dados[index].getNome().equals(nome)){
                System.out.printf("Arquivo encontrado na fila na posicao %d\n", index+1);
                System.out.println("NOME     USUARIO     HORA DE SOLICITACAO");
                System.out.println(dados[index]);
                achou = true;
            }
        }
        if(achou == false){
            System.out.println("Arquivo nao encontrado na fila");
        }
    }
    
    public void desenfileira () {
        if (filaVazia()){
            System.out.println("Fila esta vazia");
        }
        else {
            dados[primeiro].horaImpressao();

            LocalTime horaImp = dados[primeiro].getHImpressao();
            LocalTime horaAdd = dados[primeiro].getHAdicao();

            Duration duracao = Duration.between(horaAdd, horaImp);

            long totalSeconds = duracao.getSeconds();

            System.out.printf("O arquivo ficou %02d segundos na fila\n", totalSeconds);

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

    public void horaImpressao(){
            this.horaImp = LocalTime.now();
    }

    public String getNome(){
        return this.nome;
    }

    public String getUser(){
        return this.usuario;
    }

    public LocalTime getHImpressao(){
        return horaImp;
    }

    public LocalTime getHAdicao(){
        return horaSolicitacao;
    }


    @Override
    public String toString() {
        String string = this.nome + "   " + this.usuario  + "   " + horaSolicitacao.toString();
        return string;
    }

    
}
