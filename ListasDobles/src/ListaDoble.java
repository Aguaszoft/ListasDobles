import javax.swing.*;

public class ListaDoble {

    private NodoDoble inicio;
    private NodoDoble fin;
    private int tamano;

    public ListaDoble() {
        inicio = null;
        fin = null;
        tamano = 0;
    }

    // Método para agregar un valor entero al final de la lista doble
    public void agregar(int dato, JTextArea textArea) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (inicio == null) {  // Lista vacía
            inicio = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
        tamano++;
        actualizarTextArea(textArea);
    }

    // Método para eliminar un valor entero de la lista doble
    public boolean eliminar(int dato, JTextArea textArea) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return false;
        }
        NodoDoble actual = inicio;
        while (actual != null && actual.dato != dato) {
            actual = actual.siguiente;
        }
        if (actual == null) { // Elemento no encontrado
            JOptionPane.showMessageDialog(null, "Elemento no encontrado en la lista.");
            return false;
        }
        if (actual == inicio) {
            inicio = inicio.siguiente;
            if (inicio != null) inicio.anterior = null;
        } else if (actual == fin) {
            fin = fin.anterior;
            if (fin != null) fin.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        tamano--;
        actualizarTextArea(textArea);
        return true;
    }

    // Método para buscar un valor en la lista doble
    public int buscar(int dato) {
        NodoDoble actual = inicio;
        int posicion = 0;
        while (actual != null) {
            if (actual.dato == dato) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1; // Retorna -1 si no se encuentra
    }

    // Método para ordenar la lista usando burbuja
    public void ordenarBurbuja(JTextArea textArea) {
        if (inicio == null || inicio.siguiente == null) return;

        boolean swapped;
        do {
            swapped = false;
            NodoDoble actual = inicio;
            while (actual.siguiente != null) {
                if (actual.dato > actual.siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    swapped = true;
                }
                actual = actual.siguiente;
            }
        } while (swapped);

        actualizarTextArea(textArea); // Actualiza la vista en el JTextArea
    }

    // Método para mostrar la lista en el JTextArea en ambas direcciones
    public void mostrarLista(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("La lista está vacía.");
            return;
        }
        StringBuilder listaStr = new StringBuilder("Lista en orden:\n");
        NodoDoble actual = inicio;
        while (actual != null) {
            listaStr.append(actual.dato).append(" ");
            actual = actual.siguiente;
        }

        listaStr.append("\nLista en orden inverso:\n");
        actual = fin;
        while (actual != null) {
            listaStr.append(actual.dato).append(" ");
            actual = actual.anterior;
        }

        textArea.setText(listaStr.toString());
    }

    // Método para actualizar el JTextArea cada vez que cambia la lista
    private void actualizarTextArea(JTextArea textArea) {
        mostrarLista(textArea);
    }
}
