public class EditorTexto {
    private Pilha pilhaDesfazer;
    private Pilha pilhaRefazer;
    private String textoAtual;

    public EditorTexto(int capacidade) {
        pilhaDesfazer = new Pilha(capacidade);
        pilhaRefazer = new Pilha(capacidade);
        textoAtual = "";
    }

    public void inserirTexto(String novoTexto) {
        pilhaDesfazer.empilhar(textoAtual.hashCode());
        pilhaRefazer = new Pilha(10); // limpa refazer
        textoAtual = novoTexto;
        System.out.println("texto atual:" + textoAtual);
    }

    public void desfazer() {
        if (!pilhaDesfazer.estaVazia()) {
            pilhaRefazer.empilhar(textoAtual.hashCode());
            textoAtual = String.valueOf(pilhaDesfazer.desempilhar());
            System.out.println("desfazer -> " + textoAtual);
        } else {
            System.out.println("nada para desfazer");
        }
    }

    public void refazer() {
        if (!pilhaRefazer.estaVazia()) {
            pilhaDesfazer.empilhar(textoAtual.hashCode());
            textoAtual = String.valueOf(pilhaRefazer.desempilhar()) ;
            System.out.println("refazer -> " + textoAtual);
        } else {
            System.out.println("nada para refazer");
        }
    }
}