package testes;


import TabelaHash.TabelaHash;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class TestTabelaHash {

	@Test
	public void testeInsercaoUnicoElemento() {
		TabelaHash tabela = new TabelaHash(10, 20, 2);
		tabela.insere("geteaseis");
		assertTrue(tabela.busca("geteaseis"));
	}

	@Test
	public void testeBuscaElementoExistente() {
		TabelaHash tabela = new TabelaHash(10, 20, 2);
		tabela.insere("residentEvil");
		assertTrue(tabela.busca("residentEvil"));
	}

	@Test
	public void testeBuscaElementoInexistente() {
		TabelaHash tabela = new TabelaHash(10, 20, 2);
		assertFalse(tabela.busca("euSimplismenteNaoExisto"));
	}

	@Test
	public void testeRemocaoElemento() {
		TabelaHash tabela = new TabelaHash(10, 20, 2);
		tabela.insere("vouSairJaja");
		tabela.remove("vouSairJaja");
		assertFalse(tabela.busca("vouSairJaja"));
	}

	@Test
	public void testeRemocaoMultiploElementos() {
		TabelaHash tabela = new TabelaHash(10, 20, 2);
		for (int i = 0; i < 100; i++) {
			tabela.insere("elemento" + i);
		}
		for (int i = 0; i < 100; i++) {
			tabela.remove("elemento" + i);
			assertFalse(tabela.busca("elemento" + i));
		}
	}

	@Test
	public void testeInsercaoeBuscaElementos() {
		TabelaHash tabela = new TabelaHash(10, 20, 2);
		for (int i = 0; i < 100; i++) {
			tabela.insere("elemento" + i);
		}
		for (int i = 0; i < 100; i++) {
			assertTrue(tabela.busca("elemento" + i));
		}
	}

	@Test
	public void testeColisao() {
		TabelaHash tabela = new TabelaHash(10, 20, 2);
		tabela.insere("Estou Colidindo");
		tabela.insere("Estou Colidindo");

		assertEquals(1, tabela.getColisao());
	}

	@Test
	public void testeFatorCargaAtualizado() {
		TabelaHash tabela = new TabelaHash(22, 75, 2);
		for (int i = 0; i < 109; i++) {
			tabela.insere("elemento" + i);
		}
		assertEquals(31, tabela.getCapacidade());
		tabela.insere("elementoQueVaiFazerAtualizar");
		assertEquals(67, tabela.getCapacidade());
	}

	@Test
	public void testeInserindoValorNulo() {
		TabelaHash ht = new TabelaHash(22, 75, 2);
		assertThrows(IllegalArgumentException.class, () -> {
			ht.insere(null);
		});
	}

	@Test
	public void testeCaseSensitive() {
		TabelaHash ht = new TabelaHash(14, 50, 2);
		ht.insere("ESTOUMAIOR");
		assertFalse(ht.busca("estoumaior"));
	}

	@Test
	public void testeCaracteres() {
		TabelaHash ht = new TabelaHash(14, 50, 2);
		ht.insere("/*-+!@#$%¨&*()");
		assertTrue(ht.busca("/*-+!@#$%¨&*()"));
	}
}
