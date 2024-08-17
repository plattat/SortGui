package com.mycompany.sortproject;

/**
 *
 * @author cristian.otalvaro
 */
public abstract class SortAlgorithm {
    public abstract void sort(int[] array);

    public void setGui(SortGUI gui) {
        // Default implementation does nothing. Subclasses may override.
    }

    protected void printArray(int[] array, StringBuilder sb) {
        for (int j : array) {
            sb.append(j).append(" ");
        }
        sb.append("\n");
    }
}
