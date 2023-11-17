package encodeDecode;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class Encoder extends FilterReader {
    private final char keyChar;
    Encoder(Reader in, char keyChar) {
        super(in);
        this.keyChar = keyChar;
    }
    public String encode() throws IOException {
        String encodedStr = "";
        //read() 	It reads a single character.
        while (true) {
            int c = super.read();
            encodedStr += (char)(c+keyChar);
            if (c == 10) {
                break;
            }
        }

        return encodedStr;
    }
}
