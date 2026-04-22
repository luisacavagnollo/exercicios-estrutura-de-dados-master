public class Impressora {
    private Documento[] fila;
    private int inicio;
    private int fim;
    private int tamanho;

    public Impressora(int capacidade) {
        fila = new Documento[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void adicionarDocumento(Documento doc) {
        if (tamanho == fila.length) {
            System.out.println("Fila de impressão cheia");
            return;
        }
        fila[fim] = doc;
        fim = (fim + 1) % fila.length;
        tamanho++;
    }

    public void imprimirProximo() {
        if (tamanho == 0) {
            System.out.println("Nenhum documento na fila");
            return;
        }
        Documento doc = fila[inicio];
        inicio = (inicio + 1) % fila.length;
        tamanho--;

        System.out.println("imprimindo: " + doc.nome + " (" + doc.tamanho + " páginas)");
    }

    public void mostrarFila() {
        if (tamanho == 0) {
            System.out.println("Fila vazia");
            return;
        }

        int i = inicio;
        for (int count = 0; count < tamanho; count++) {
            System.out.println(fila[i].nome + "(" + fila[i].tamanho + " páginas )");
            i = (i + 1) % fila.length;
        }
    }
}