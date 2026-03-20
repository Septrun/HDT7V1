package com.template;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testInsertAndFind() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        Association<String, String> assoc = new Association<>("house", "casa");

        tree.insert(assoc);

        Association<String, String> found = tree.find(new Association<>("house", ""));
        assertNotNull(found, "La palabra debería existir en el árbol");
        assertEquals("casa", found.getValue());
    }

    @Test
    public void testFindNonExistent() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        tree.insert(new Association<>("dog", "perro"));
        
        // 3. Probar búsqueda de un elemento que NO existe
        Association<String, String> found = tree.find(new Association<>("cat", ""));
        assertNull(found, "La palabra no debería existir en el árbol");
    }

    @Test
    public void testInOrderProperty() {
        // Esta prueba verifica indirectamente que el árbol mantiene el orden lógico
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        tree.insert(new Association<>("m", "medio"));
        tree.insert(new Association<>("a", "inicio"));
        tree.insert(new Association<>("z", "final"));
        
        assertNotNull(tree.find(new Association<>("a", "")));
        assertNotNull(tree.find(new Association<>("m", "")));
        assertNotNull(tree.find(new Association<>("z", "")));
    }
}