package br.com.lts.desafio.joiasfigure.utils;

import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

@Service
public class GerenciadorArquivoFactory {
    public PrintWriter criarArquivo(String nomeArquivo) throws IOException {
        return new PrintWriter(new FileWriter(nomeArquivo, Charset.defaultCharset(), true));
    }
}
