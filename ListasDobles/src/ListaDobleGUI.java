import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDobleGUI {
    private JPanel pGeneral;
    private JTextField inputField;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton ordenarButton;
    private JButton buscarButton;
    private JButton mostrarListaButton;
    private JTextArea textArea;

    ListaDoble listaDoble= new ListaDoble();
    public ListaDobleGUI() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    listaDoble.agregar(valor,textArea);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    listaDoble.eliminar(valor,textArea);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDoble.ordenarBurbuja(textArea);
                JOptionPane.showMessageDialog(null, "Lista ordenada con el método Burbuja.");
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    int posicion = listaDoble.buscar(valor);
                    if (posicion == -1) {
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento encontrado en posición: " + posicion);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
        mostrarListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDoble.mostrarLista(textArea);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListaDobleGUI");
        frame.setContentPane(new ListaDobleGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
