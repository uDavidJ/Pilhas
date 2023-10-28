import java.util.ArrayList;

public class Pilha {
    private ArrayList<String> lista;
    private static int TAMANHO = 20;


    public Pilha() {
        lista = new ArrayList<>(TAMANHO);
    }

    public Pilha(int tamanho) {
        lista = new ArrayList<>(tamanho);
    }

    public int tamanho() {
        return lista.size();
    }

    public void push(String x) {
        lista.add(0, x);
    }

    public Object top() {
        if(!verificaExistencia())
            System.out.println("Ainda não há elementos na pilha");
        
        return (lista.get(0));
    }

    public String pop() {
        if(!verificaExistencia())
            System.err.println("Ainda não há elementos na pilha");
        String x = lista.get(0);
        lista.remove(0);
        return x;
    }

    @Override
    public String toString() {
        return lista.toString();
    }


    private boolean verificaExistencia() {
        if(lista.size() == 0)
            return false;
        return true;
    }


}
