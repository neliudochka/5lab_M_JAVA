package encodeDecode;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        char keyChar = 'e';

        var reader = new InputStreamReader(System.in);
        Encoder encoder = new Encoder(reader, keyChar);
        String encoded = "";
        try {
            encoded = encoder.encode();
            System.out.println("Encoded: " + encoded);
            reader.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        OutputStreamWriter writer
                = new OutputStreamWriter(System.out);
        try {
            Decoder decoder = new Decoder(writer, keyChar);
            decoder.decode(encoded);
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

