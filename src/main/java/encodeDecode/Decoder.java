package encodeDecode;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class Decoder extends FilterWriter {
    private final char keyChar;
    protected Decoder(Writer out, char keyChar) {
        super(out);
        this.keyChar = keyChar;
    }

    public void decode(String str) throws IOException {
        super.write("Decoded: ");
        for(char c: str.toCharArray()) {
            super.write(c-keyChar);
            }
        }
    }

