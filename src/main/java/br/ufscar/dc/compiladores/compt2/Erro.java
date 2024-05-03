package br.ufscar.dc.compiladores.compt2;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import java.util.HashMap;
import java.util.Map;

public class Erro extends BaseErrorListener {    

    public static final Erro INSTANCE = new Erro();

    // Método para tratamento de erros sintáticos
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
            int charPositionInLine, String msg, RecognitionException e) 
                throws ParseCancellationException{
        
        Token token = (Token) offendingSymbol;

        // Base da mensagem de erro
        String base = "Linha " + token.getLine() + ": "; 
        
        // Verifica se o erro está relacionado a algum token específico
        if(eh_erro(token.getType())) {
            // Trata diferentes tipos de erros
            switch (token.getType()) {
                case AlgumaLexer.CARACTER_INVALIDO:
                    throw new ParseCancellationException(base + token.getText() + " - simbolo nao identificado\nFim da compilacao");
                case AlgumaLexer.CADEIA_SEM_FIM:
                    throw new ParseCancellationException(base + "cadeia literal nao fechada\nFim da compilacao");
                default:
                    throw new ParseCancellationException(base + "comentario nao fechado\nFim da compilacao");
            }
        }
        // Erro próximo ao final do arquivo
        else if (token.getType() == Token.EOF)
                throw new ParseCancellationException(base + "erro sintatico proximo a EOF\nFim da compilacao");
        // Erro sintático próximo a um token específico
        else
                throw new ParseCancellationException(base + "erro sintatico proximo a " + token.getText()+ "\nFim da compilacao");
        }

    // Verifica se o tipo de token indica um erro
    private static Boolean eh_erro(int tkType) {
        if(tkType == AlgumaLexer.CADEIA_SEM_FIM || tkType == AlgumaLexer.COMENTARIO_SEM_FIM || tkType == AlgumaLexer.CARACTER_INVALIDO )
            return true;
        return false;
    }
}