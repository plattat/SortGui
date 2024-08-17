package com.mycompany.sortproject;

/**
 *
 * @author cristian.otalvaro
 */
public class InsertionSort extends SortAlgorithm {
    private SortGUI gui;

    public void setGui(SortGUI gui) {
        this.gui = gui;
    }

    public void sort(int[] array) {
        StringBuilder sb = new StringBuilder();
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
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
