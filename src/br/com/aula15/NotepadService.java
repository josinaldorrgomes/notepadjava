package br.com.aula15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NotepadService {

    Path path;

    public String abrir(String caminhoDoArquivo) throws IOException {
        path = Paths.get(caminhoDoArquivo);
        List<String> linhas = Files.readAllLines(path, Charset.forName("windows-1252"));
        StringBuilder builder = new StringBuilder();
        for (String linha : linhas) {
            builder.append(linha).append("\n");
        }
        return builder.toString();
    }

    public String salvar(String caminhoDoArquivo, String conteudo) throws IOException {
        path = Paths.get(caminhoDoArquivo);
        File file = path.toFile();
        try {
            FileOutputStream escritor = new FileOutputStream(file);
            escritor.write(conteudo.getBytes("ISO-8859-1"));
            escritor.close();

        } catch (Exception e) {
        }
        return null;
    }

}
