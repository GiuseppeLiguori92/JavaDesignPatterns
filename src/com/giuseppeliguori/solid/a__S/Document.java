package com.giuseppeliguori.solid.a__S;

/**
 * Created by giuseppeliguori on 19/06/2017.
 */
public class Document {

    private byte[] bytes;

    public Document(String text) {
        this.bytes = text.getBytes();
    }

    public Document (byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
