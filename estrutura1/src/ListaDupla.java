public class ListaDupla {
    private No inicio;
    private No fim;

    public void inserirInicio(int valor) {
    No novo = new No(valor);

    if (inicio == null) {
         inicio = fim = novo;
     } else {
        novo.proximo = inicio;
        inicio.anterior = novo;
        inicio = novo;
        }
    }

    public void inserirFim(int valor) {
        No novo = new No(valor);

        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }
    public void inserirApos(int valorBusca, int novoValor) {
        No atual = inicio;

        while (atual != null && atual.valor != valorBusca) {
            atual = atual.proximo;
        }

        if (atual != null) {
            No novo = new No(novoValor);

            novo.proximo = atual.proximo;
            novo.anterior = atual;

            if (atual.proximo != null) {
                atual.proximo.anterior = novo;
            } else {
                fim = novo;
            }

            atual.proximo = novo;
        }
    }
    public No buscar(int valor) {
        No atual = inicio;

        while (atual != null) {
            if (atual.valor == valor) return atual;
            atual = atual.proximo;
        }

        return null;
    }

    public void removerInicio() {
        if (inicio == null) return;

        inicio = inicio.proximo;

        if (inicio != null) {
            inicio.anterior = null;
        } else {
            fim = null;
        }
    }

    public void removerFim() {
        if (fim == null) return;

        fim = fim.anterior;

        if (fim != null) {
            fim.proximo = null;
        } else {
            inicio = null;
        }
    }

    public void removerValor(int valor) {
        No atual = inicio;

        while (atual != null && atual.valor != valor) {
            atual = atual.proximo;
        }

        if (atual != null) {
            if (atual.anterior != null) {
                atual.anterior.proximo = atual.proximo;
            } else {
                inicio = atual.proximo;
            }

            if (atual.proximo != null) {
                atual.proximo.anterior = atual.anterior;
            } else {
                fim = atual.anterior;
            }
        }
    }
}
