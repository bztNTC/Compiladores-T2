package br.ufscar.dc.compiladores.compt2;

import br.ufscar.dc.compiladores.compt2.AlgumaLexer;
import br.ufscar.dc.compiladores.compt2.AlgumaParser;
import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;


public class Principal
{
    public static void main(String[] args) throws RuntimeException, FileNotFoundException, IOException 
    {      
        // Verifica se o número de argumentos passados está correto
         if (args.length < 2) {
            System.out.println("Falha na execução.\nNúmero de parâmetros inválidos.");
            System.exit(0);
        }

        // Cria um analisador léxico com base no arquivo de entrada
        AlgumaLexer entrada = new AlgumaLexer(CharStreams.fromFileName(args[0]));
        // Cria um analisador sintático com base no analisador léxico
        AlgumaParser parser = new AlgumaParser(new CommonTokenStream(entrada));

        // Remove os ouvintes de erro padrão
        parser.removeErrorListeners();
        // Adiciona o ouvinte de erro personalizado
        parser.addErrorListener(Erro.INSTANCE);
        
        try (PrintWriter saida = new PrintWriter(args[1])) {
            try {
                // Tenta fazer a análise sintática do programa
                parser.programa();
            }
            // Captura exceções de cancelamento de análise (erros sintáticos)
            catch (ParseCancellationException mensagem_erro) {
                // Imprime a mensagem de erro no arquivo de saída
                saida.println(mensagem_erro.getMessage());
                // Fecha o arquivo de saída
                saida.close();
        } 
        } catch (IOException exception) {
            // Trata exceções de IO ao abrir o arquivo de saída
            System.out.println("Falha na execução.\nO programa não conseguiu abrir o arquivo: " + args[1]+ ".");
        }   
    }
}