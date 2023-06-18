package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {
    public void print(File file, String indent, boolean isLast) {
        indent = printRoot(file, indent, isLast);
        File[] files = file.listFiles();
        if (isEmpty(files)) return;
        int subDirTotal = getSubDirTotal(files);
        printFiles(indent, files, subDirTotal);
    }

    private boolean isEmpty(File[] files) {
        return files == null;
    }

    private int getSubDirTotal(File[] files) {
        int subDirTotal = 0;
        for (File file : files) {
            if (file.isDirectory())
                subDirTotal++;
        }
        return subDirTotal;
    }

    private void printFiles(String indent, File[] files, int subDirTotal) {
        int subDirCounter = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                print(file, indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            } else {
                print(file, indent, true);
            }
        }
    }

    private String printRoot(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());
        return indent;
    }
}

