package br.com.faneli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {

    FileReader file;

    public LeitorArquivo carregar(String caminho) throws IOException {

        file = new FileReader(caminho);
        return this;
    }

    public LeitorArquivo imprimir() throws IOException {
        try(BufferedReader reader = new BufferedReader(file)){
            while(reader.ready()){
                String linha = reader.readLine();
                System.out.println(linha);
            }
        }
        return this;
    }
}
