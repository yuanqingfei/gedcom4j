/*
 * Copyright (c) 2009-2016 Matthew R. Harrah
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package org.gedcom4j.io.writer;

import java.io.IOException;
import java.io.OutputStream;

import org.gedcom4j.exception.WriterCancelledException;
import org.gedcom4j.io.encoding.AnselHandler;
import org.gedcom4j.writer.GedcomWriter;

/**
 * A class that writes GEDCOM data in ANSEL format.
 * 
 * @author frizbog
 */
class AnselWriter extends AbstractSingleByteWriter {

    /**
     * The helper class that converts UTF-16 strings to ANSEL encoded data
     */
    private final AnselHandler anselHandler = new AnselHandler();

    /**
     * Constructor
     * 
     * @param writer
     *            The {@link GedcomWriter} this object is assisting
     */
    AnselWriter(GedcomWriter writer) {
        super(writer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeLine(OutputStream out, String line) throws IOException, WriterCancelledException {
        String anselLine = anselHandler.toAnsel(line);
        for (int i = 0; i < anselLine.length(); i++) {
            char c = anselLine.charAt(i);
            out.write(c);
            bytesWritten++;
        }
        writeLineTerminator(out);
    }

}
