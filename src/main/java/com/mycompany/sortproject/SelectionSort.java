package com.mycompany.sortproject;

/**
 *
 * @author cristian.otalvaro
 */
public class SelectionSort extends SortAlgorithm {
    private SortGUI gui;

    @Override
    public void setGui(SortGUI gui) {
        this.gui = gui;
    }

    @Override
    public void sort(int[] array) {
        StringBuilder sb = new StringBuilder();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
            appendArray(array, sb);
        }
        sb.append("Array ordenado:\n");
        appendArray(array, sb);
        gui.updateTextArea(sb.toString());
    }

    private void appendArray(int[] array, StringBuilder sb) {
        for (int j : array) {
            sb.append(j).append(" ");
        }
        sb.append("\n");
    }
}
