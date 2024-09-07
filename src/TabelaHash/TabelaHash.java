package TabelaHash;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.Node;

public class TabelaHash {
	private ListaEncadeada[] tabela;
	private int capacidade;
	private int quantElementos;
	private int margem;
	private int a;
	private int colisao = 0;

	//Construtor 100%
	public TabelaHash(int n, int margem, int a) {
		this.capacidade = calcularCapacidade(n, margem);
		this.margem = margem;
		this.a = a;
		this.tabela = new ListaEncadeada[capacidade];
		for (int i = 0; i < capacidade; i++) {
			tabela[i] = new ListaEncadeada();
		}
		this.quantElementos = 0;
	}
	
	//Calcula capacidade 100%
	private int calcularCapacidade(int n, int margem) {
		int capacidade = (int) Math.ceil(n / (margem / 100.0));
		if (!primo(capacidade)) {
			capacidade = proximoPrimo(capacidade);
		}
		return capacidade;
	}

	//Verifica valor primo para capacidade 100%
	private boolean primo(int numero) {
		if (numero <= 1)
			return false;
		if (numero == 2 || numero == 3)
			return true;
		if (numero % 2 == 0 || numero % 3 == 0)
			return false;
		for (int i = 5; i * i <= numero; i += 6) {
			if (numero % i == 0 || numero % (i + 2) == 0)
				return false;
		}
		return true;
	}

	private int proximoPrimo(int numero) {
		numero++;
		while (true) {
			if (primo(numero)) {
				return numero;
			}
			numero++;
		}
	}

	//Hash da string 100%
	private int hash(String str) {
		int hash = 0;
		int primo = 7;
		for (int i = 0; i < str.length(); i++) {
			char caractere = str.charAt(i);
			int ascii = (int) caractere;

			hash = ascii + hash;
		}
		hash = hash * primo;
		return Math.abs(hash % capacidade);
	}
	double fatora;
	double fatorb;

	// Insere string na tabela 100%
	public void insere(String str) { 
		if (str == null) {
			throw new IllegalArgumentException("O valor a ser inserido não pode ser nulo.");
		}
		double fatorDeCargaReal = (double) quantElementos / tabela.length;
		double fatorDeCargaEsperado = a + a * margem / 100.0;
		fatora = fatorDeCargaReal;
		fatorb =  fatorDeCargaEsperado;
		if (fatorDeCargaReal > fatorDeCargaEsperado) {
			redimensionar();
		}
		int index = hash(str);
		if (tabela[index].getTamanho() > 0) {
			colisao++;
		}
		tabela[index].insere(str);
		quantElementos++;
	}

	//busca elemento 100%
	public boolean busca(String str) {
		if (str == null) {
			throw new IllegalArgumentException("O valor a ser inserido não pode ser nulo.");
		}
		int index = hash(str);
		boolean encontrado = tabela[index].busca(str);
		return encontrado;
	}

	//remove elemento 100%
	public void remove(String str) {
		if (str == null) {
			throw new IllegalArgumentException("O valor a ser inserido não pode ser nulo.");
		}
		int index = hash(str);
		boolean removido = tabela[index].remove(str);
		if (removido) {
			quantElementos--;
		}
	}

	//redimensiona tabela 100%
	private void redimensionar() {
		this.capacidade = proximoPrimo(capacidade * 2);
		ListaEncadeada[] novaTabela = new ListaEncadeada[capacidade];
		for (int i = 0; i < capacidade; i++) {
			novaTabela[i] = new ListaEncadeada();
		}
		for (ListaEncadeada lista : tabela) {
			Node node = lista.getRef();
			while (node != null) {
				String elemento = node.getInfo();
				int novoIndice = hash(elemento);
				novaTabela[novoIndice].insere(elemento);
				node = node.getProx();
			}
		}
		tabela = novaTabela;
	}
	//retorna n de colisões
	public int getColisao() {
		return this.colisao;
	}
	public int getQuantElementos() {
		return this.quantElementos;
	}
	public int getCapacidade() {
		return this.capacidade;
	}
}
