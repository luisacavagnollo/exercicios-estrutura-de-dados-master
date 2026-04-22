public class Pilha {
    private int[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new int[capacidade];
        topo = -1;
    }

    public void empilhar(int valor) {
        if (topo == elementos.length - 1) {
            System.out.println("Pilha cheia");
            return;
        }
        elementos[++topo] = valor;
    }

    public int desempilhar() {
        if (estaVazia()) {
            System.out.println("pilha vazia");
            return -1;
        }
        return elementos[topo --];
    }

    public boolean estaVazia() {
        return topo ==-1;
    }
}
