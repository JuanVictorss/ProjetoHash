package ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        // Inserindo elementos na lista
        lista.insere("oloco");
        lista.insere("naaaao");
        lista.insere("aiiii");
        lista.insere("eu tu nós");

        // Imprimindo a lista
        System.out.println("Lista após inserções:");
        printLista(lista);

        // Buscando elementos na lista
        String[] buscas = {"oloco", "naaaao", "naoexiste"};
        for (String busca : buscas) {
            boolean encontrado = lista.busca(busca);
            System.out.println("Elemento \"" + busca + "\" encontrado? " + encontrado);
        }

        // Removendo elementos da lista
        lista.remove("aiiii");
        System.out.println("Lista após remoção de 'aiiii':");
        printLista(lista);

        // Tentando remover um elemento que não existe
        lista.remove("naoexiste");
        System.out.println("Lista após tentativa de remoção de 'naoexiste':");
        printLista(lista);
    }

    // Método para imprimir a lista
    private static void printLista(ListaEncadeada lista) {
        Node current = lista.getRef();
        while (current != null) {
            System.out.print(current.getInfo() + " -> ");
            current = current.getProx();
        }
        System.out.println("null");
    }
}
