package com.template;

import java.io.*;

public class Traductor {
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> bst = new BinaryTree<>();

        // 1. Se carga el diccionario.txt
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("(", "").replace(")", "").trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    bst.insert(new Association<>(parts[0].trim().toLowerCase(), parts[1].trim().toLowerCase()));
                }
            }
        } catch (IOException e) { e.printStackTrace(); }

        // 2. Recorrido In-Order
        System.out.println("Diccionario In-order:");
        bst.inOrder(); // [cite: 88, 89]

        // 3. Se traduce el texto.txt
        System.out.println("\nResultado de la traducción:");
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("(?=[,.!?; ])|(?<=[,.!?; ])");
                for (String word : words) {
                    String cleanWord = word.toLowerCase().trim();
                    if (cleanWord.isEmpty() || !cleanWord.matches("[a-zA-Z]+")) {
                        System.out.print(word);
                        continue;
                    }
                    
                    Association<String, String> result = bst.find(new Association<>(cleanWord, ""));
                    if (result != null) {
                        System.out.print(result.getValue());
                    } else {
                        System.out.print("*" + word + "*");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}