package br.com.faneli;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        /*
        for (Map.Entry e : Charset.availableCharsets().entrySet()) {
            System.out.println(e.getKey());
        }
         */

        String original = "/home/faneli/Downloads/UTF16.txt";
        String novo = "/home/faneli/Downloads/UTF8.txt";


        System.out.println(System.getProperty("file.encoding"));

        for (Map.Entry e : Charset.availableCharsets().entrySet()) {
            System.out.println("Charset: " + e.getKey().toString());
            try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(original), e.getKey().toString()));) {
                String line;
                int j = 0;
                while ((line = in.readLine()) != null) {
                    System.out.println("Linha: " + j);
                    String[] p = line.split(";");
                    int i = 0;
                    while (i < p.length) {
                        String text = new String(p[i].getBytes());
                        System.out.println(text);
                        i++;
                    }
                    j++;
                }
            }
        }
    }
}
