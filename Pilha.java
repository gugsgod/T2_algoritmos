import java.time.LocalTime;
import java.time.Duration;

public class Pilha {
    private No topo;
    private int tamanhoMaximo = 10;

    public int verificarOcupacao(){
        int i = 0;
        No runner = topo;
        while(runner != null){
            i++;
            runner = runner.getProximo();
        }
        return i;
    }    

    public boolean estaCheio(){
        return tamanhoMaximo == verificarOcupacao();
    }
    //lembrem-se, temos o construtor padrão, herdado de Object

    public void push (String nome, String usuario) {
        Documento doc = new Documento(nome, usuario);
        if (estaCheio()){
            throw new RuntimeException("Pilha cheia, impossível de realizar operação");
        }
        No novo = new No(doc);
        if (!pilhaVazia() ) {
            novo.setProximo(topo);
        }
        topo = novo;
    }

    public void push(Documento doc){
        if (estaCheio()){
            throw new RuntimeException("Pilha cheia, impossível de realizar operação");
        }
        No novo = new No(doc);
        if (!pilhaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
    }

    public boolean pilhaVazia() {
        return topo == null;
    }
    public Documento pop() {
        if (pilhaVazia())
            throw new RuntimeException("pilha vazia, falha no pop");
        Documento doc = topo.getDoc();
        topo = topo.getProximo();
        doc.horaImpressao();
        Duration tempoDecorrido = Duration.between(doc.getHoraSolicitacao(), doc.getHoraImp());
        long segundos = tempoDecorrido.getSeconds();
        System.out.println("Reimpressão realizada com sucesso!\nTempo decorrido: " + segundos + "s");
        return doc;
    }
    public Documento peek () {
        if (pilhaVazia()) 
            throw new RuntimeException("pilha vazia");
        return topo.getDoc();
    }
    public void invertePilha() {
        Pilha p = new Pilha();
        while (!pilhaVazia()) {
            p.push(this.pop());
        }
        this.topo = p.topo;
    }

    public Documento consultarDocumento(String nome){
        int posicao = 0;
        No runner = topo;
        while (runner != null && !runner.getDoc().getNome().equals(nome)) {
            runner = runner.getProximo();
            posicao++;
        }
        if (runner == null) {
            return null;
        }
        runner.getDoc().setPosicao(posicao);;
        return runner.getDoc();
    }    
}
class No {
    private Documento doc;
    private No proximo;
    public No(Documento doc) {
        this.doc = doc;
    }
    public Documento getDoc() {
        return doc;
    }
    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString () {
        return "[" + doc + "]";
    }
}

class Documento{
    private String nome;
    private String usuario;
    private int posicao;
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

    public void horaImpressao(){
            this.horaImp = LocalTime.now();
        }

    public LocalTime getHoraSolicitacao(){
        return horaSolicitacao;
    }

    public LocalTime getHoraImp(){
        return horaImp;
    }

    public void setPosicao(int posicao){
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        String string = "Nome: " + nome + "\nUsuario: " + usuario  + "\nPosicao na pilha: "  + posicao + "\nHora de solicitacao: " + horaSolicitacao.toString();
        return string;
    }

    
}
