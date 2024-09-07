package testes;

import java.util.HashMap;

import TabelaHash.TabelaHash;

public class DesempenhoTeste {

    public static void main(String[] args) {
        TabelaHash minhaTabela = new TabelaHash(100, 20, 2);
        HashMap<String, String> javaHashMap = new HashMap<>();

        // Teste de inserção
        long startMinhaIns = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            minhaTabela.insere("chave" + i);
        }
        long endMinhaIns = System.nanoTime();
        System.out.println("Tempo de inserção (minha tabela): " + (endMinhaIns - startMinhaIns) + " ns");

        long startJavaIns = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            javaHashMap.put("chave" + i, "valor" + i);
        }
        long endJavaIns = System.nanoTime();
        System.out.println("Tempo de inserção (HashMap): " + (endJavaIns - startJavaIns) + " ns");

        // Teste de busca
        long startMinhaBusca = System.nanoTime();
        minhaTabela.busca("chave500");
        long endMinhaBusca = System.nanoTime();
        System.out.println("Tempo de busca (minha tabela): " + (endMinhaBusca - startMinhaBusca) + " ns");

        long startJavaBusca = System.nanoTime();
        javaHashMap.containsKey("chave500");
        long endJavaBusca = System.nanoTime();
        System.out.println("Tempo de busca (HashMap): " + (endJavaBusca - startJavaBusca) + " ns");

        // Teste de remoção
        long startMinhaRem = System.nanoTime();
        minhaTabela.remove("chave500");
        long endMinhaRem = System.nanoTime();
        System.out.println("Tempo de remoção (minha tabela): " + (endMinhaRem - startMinhaRem) + " ns");

        long startJavaRem = System.nanoTime();
        javaHashMap.remove("chave500");
        long endJavaRem = System.nanoTime();
        System.out.println("Tempo de remoção (HashMap): " + (endJavaRem - startJavaRem) + " ns");
    }
}