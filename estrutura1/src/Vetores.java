public class Vetores {
    private int[] elementos;
    private int tamanho;

    public Vetores(int capacidade){
        elementos = new int[capacidade];
        tamanho = 0;
    }
    private void aumCapacidade(){
        int[] novo = new int[elementos.length*2];
        for (int i = 0; i<elementos.length; i++){
            novo[i] =elementos[i];
        }
        elementos = novo;
    }

    public void inserir(int valor){
        if(tamanho ==elementos.length){
            aumCapacidade();
        }
        elementos[tamanho]=valor;
        tamanho++;
    }

    public int buscar(int valor){
        for(int i = 0; i<tamanho;i++){
            if(elementos[i]==valor){
                return i;
            }
        }
        return  -1;
    }

    public boolean remover(int valor){
        int pos = buscar(valor);
        if (pos ==-1) return false;
        for (int i = pos; i<tamanho -1; i++){
            elementos[i] = elementos[i+1];
        }
        tamanho--;
        return true;
    }

    public void inserir(int pos, int valor){
        if(pos<0||pos >tamanho){
            System.out.println("posição invalida");
            return;
        }
        if (tamanho==elementos.length){
            aumCapacidade();
        }
        for (int i =tamanho; i>pos; i--){
            elementos[i] = elementos[i-1];
        }
        elementos[pos]=valor;
        tamanho++;
    }
}
