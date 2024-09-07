package TabelaHash;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(22, 75, 2); // Capacidade inicial ajustada
        
        // 115 palavras não aleatórias
        String[] palavras = {
            "gato", "banana", "cachorro", "agua", "getea", "minecraft", "saude", "ame", "minico", "aiaiaiaia",
            "naaaaaao", "sol", "lua", "carro", "caminhao", "computador", "teclado", "monitor", "cadeira", "janela",
            "porta", "aviao", "navio", "celular", "trem", "floresta", "rio", "oceano", "montanha", "deserto",
            "fogo", "terra", "ar", "vento", "tempestade", "chuva", "neve", "trovão", "relâmpago", "furacao", "vulcao",
            "estrela", "galaxia", "planeta", "astronauta", "foguete", "espaco", "buraco", "negro", "gravidade", "energia",
            "eletricidade", "magnetismo", "forca", "pressao", "velocidade", "tempo", "relatividade", "quimica", "fisica",
            "biologia", "matematica", "geografia", "historia", "filosofia", "psicologia", "sociologia", "antropologia",
            "linguistica", "poesia", "literatura", "musica", "pintura", "escultura", "teatro", "cinema", "fotografia",
            "video", "jornalismo", "politica", "economia", "administração", "marketing", "publicidade", "contabilidade",
            "estatistica", "probabilidade", "finanças", "investimentos", "negocios", "empreendedorismo", "tecnologia",
            "ciencia", "engenharia", "medicina", "enfermagem", "psiquiatria", "neurologia", "dermatologia", "cardiologia",
            "anatomia", "fisiologia", "farmacia", "veterinaria", "odontologia", "nutricao", "educacao", "pedagogia",
             "ciclismo", "musculacao"
        };

        // Inserir as palavras na tabela hash
        for (String palavra : palavras) {
            tabelaHash.insere(palavra);
        }

        System.out.println("Inserção e remoção das 115 palavras concluídas.");
    }
}
