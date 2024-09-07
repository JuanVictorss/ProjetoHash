package ListaEncadeada;

public class Node {
    private String info;
    private Node prox;

    public Node(String info, Node prox) {
        this.info = info;
        this.prox = prox;
    }

    public String getInfo() { 
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Node getProx() {
        return prox;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        if (prox != null) {
            return info + ", " + prox.toString();
        } else {
            return info;
        }
    }
}