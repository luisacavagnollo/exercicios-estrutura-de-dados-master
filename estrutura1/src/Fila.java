public class Fila {
    private int[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    public Fila(int capacidade) {
        elementos = new int[capacidade];
        inicio =0;
        fim = 0;
        tamanho= 0;
    }

    public void enfileirar(int valor) {
        if (tamanho == elementos.length) {
            System.out.println("fila cheia");
            return;
        }
        elementos[fim] = valor;
        fim = (fim + 1) % elementos.length;
        tamanho++;
    }

    public int desenfileirar() {
        if (estaVazia()) {
            System.out.println("fila vazia");
            return -1;
        }
        int valor = elementos[inicio];
        inicio= (inicio + 1) % elementos.length;
        tamanho--;
        return valor;
    }

    public boolean estaVazia() {
        return tamanho ==0;
    }
}