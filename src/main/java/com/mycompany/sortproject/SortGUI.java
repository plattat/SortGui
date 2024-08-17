package com.mycompany.sortproject;

/**
 *
 * @author cristian.otalvaro
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SortGUI extends JFrame {
    private final JTextArea textArea;
    private final JTextField inputField;
    private SortAlgorithm sortAlgorithm;

    public SortGUI() {
        setTitle("Sort Visualizer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField(20);
        JButton sortButton = new JButton("Ordenar");
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JLabel algorithmLabel = new JLabel("Seleccionar algoritmo de ordenamiento:");
        JComboBox<String> algorithmComboBox = new JComboBox<>(new String[]{"Seleccionar...", "Bubble Sort", "Selection Sort", "Insertion Sort"});
        algorithmComboBox.addActionListener(new AlgorithmSelectionListener());

        sortButton.addActionListener(new SortButtonListener());

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(new JLabel("Ingrese los números (separados por comas):"), gbc);

        gbc.gridx = 1;
        topPanel.add(inputField, gbc);

        gbc.gridx = 2;
        topPanel.add(sortButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        topPanel.add(algorithmLabel, gbc);

        gbc.gridy = 2;
        topPanel.add(algorithmComboBox, gbc);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void updateTextArea(String text) {
        textArea.setText(text);
    }

    private class SortButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
            String input = inputField.getText();
            try {
                String[] parts = input.split(",");
                int[] arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Integer.parseInt(parts[i].trim());
                }
                if (sortAlgorithm != null) {
                    sortAlgorithm.sort(arr);
                } else {
                    JOptionPane.showMessageDialog(SortGUI.this, "Por favor, seleccione un algoritmo de ordenamiento.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(SortGUI.this, "Entrada inválida. Por favor, ingrese una lista de números separados por comas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class AlgorithmSelectionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
            String selectedAlgorithm = (String) comboBox.getSelectedItem();
            
            switch (selectedAlgorithm) {
                case "Bubble Sort":
                    sortAlgorithm = new BubbleSort();
                    break;
                case "Selection Sort":
                    sortAlgorithm = new SelectionSort();
                    break;
                case "Insertion Sort":
                    sortAlgorithm = new InsertionSort();
                    break;
                default:
                    sortAlgorithm = null;
                    break;
            }
            if (sortAlgorithm != null) {
                sortAlgorithm.setGui(SortGUI.this); // Pass the GUI instance to the selected algorithm
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortGUI frame = new SortGUI();
            frame.setVisible(true);
        });
    }
}
