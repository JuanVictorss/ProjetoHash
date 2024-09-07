package testes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class HashMapTest {

    @Test
    public void testeInsercaoUnicoElemento() {
        HashMap<String, String> map = new HashMap<>();
        map.put("souUnico", "valor1");
        assertTrue(map.containsKey("souUnico"));
    }

    @Test
    public void testeInsercaoMultiploElementos() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put("variosEus" + i, "valor" + i);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(map.containsKey("variosEus" + i));
        }
    }

    @Test
    public void testeRemocaoElemento() {
        HashMap<String, String> map = new HashMap<>();
        map.put("VouSair", "valor1");
        map.remove("VouSair");
        assertFalse(map.containsKey("VouSair"));
    }

    @Test
    public void testeRemocaoMultiploElementos() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put("souO" + i, "valor" + i);
        }
        for (int i = 0; i < 100; i++) {
            map.remove("souO" + i);
            assertFalse(map.containsKey("souO" + i));
        }
    }

    @Test
    public void testeBuscaElementoExistente() {
        HashMap<String, String> map = new HashMap<>();
        map.put("vaiMeProcurar", "valor1");
        assertTrue(map.containsKey("vaiMeProcurar"));
    }

    @Test
    public void testeBuscaElementoInexistente() {
        HashMap<String, String> map = new HashMap<>();
        assertFalse(map.containsKey("euSimplesmenteNaoExisto"));
    }
}