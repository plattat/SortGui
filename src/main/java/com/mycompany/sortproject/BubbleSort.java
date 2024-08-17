package com.mycompany.sortproject;

/**
 *
 * @author cristian.otalvaro
 */
public class BubbleSort extends SortAlgorithm {
    private SortGUI gui;

    public void setGui(SortGUI gui) {
        this.gui = gui;
    }

    public void sort(int[] array) {
        StringBuilder sb = new StringBuilder();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    appendArray(array, sb);
                }
            }
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
