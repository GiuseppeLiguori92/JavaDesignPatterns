package com.giuseppeliguori.solid.a__S;

/**
 * Created by giuseppeliguori on 19/06/2017.
 */
public class Printer {
    // This class allow to print a document
    public void print(Document document) {
        byte[] bytes = document.getBytes();
        if (bytes.length == 0) {return;}

        System.out.println("\n\nPrinter.print new file");
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("Printer.print: [" + i + "]" + String.format("0x%02X", bytes[i] & 0xFF));
        }
    }
}
