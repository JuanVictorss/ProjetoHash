package ListaEncadeada;

public class ListaEncadeada {
    private Node ref;
    private int tamanho = 0;

    public Node getRef() {
        return ref;
    }
    public void setRef(Node ref) {
        this.ref = ref;
    }
    public int getTamanho() {
    	return this.tamanho;
    }

    public ListaEncadeada() {
        ref = null;
    }
    public void insere(String info) {
    	tamanho++;
    	ref = new Node(info, ref);
    }
    public boolean remove(String info) {
        if (ref == null) {
            return false;
        }
        if (ref.getInfo().equals(info)) {
            ref = ref.getProx();
        	tamanho--;
            return true;
        }
        Node prev = ref;
        for (Node curr = ref.getProx(); curr != null; curr = curr.getProx()) {
            if (curr.getInfo().equals(info)) {
                prev.setProx(curr.getProx());
                tamanho--;
                return true;
            }
            prev = curr;
        }

        return false;
    }
    public boolean busca(String info) {
        for (Node i = ref; i != null; i = i.getProx()) {
            if (i.getInfo().equals(info)) {
                return true;
            }
        }
        return false;
    }
    public void imprime() {
        Node atual = ref;
        while (atual != null) {
            System.out.print(atual.getInfo() + " -> ");
            atual = atual.getProx();
        }
        System.out.println("null");
    }
}