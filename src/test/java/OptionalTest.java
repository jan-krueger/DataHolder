/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Jan Krueger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

import de.SweetCode.DataHolder.utils.Optional;
import junit.framework.TestCase;

/**
 * Created by Yonas on 31.10.2015.
 */
public class OptionalTest extends TestCase {

    public void testStore() {

        Optional<String> optional = new Optional<>("Value");

        assertEquals(
                "Optional#Constructor doesn't store the value.",
                "Value",
                optional.get()
        );

    }

    public void testIsPresent() {

        Optional presentYes = new Optional("Value");
        Optional presentNo = new Optional(null);

        assertEquals(
                "Optional#isPresent method doesn't work.",
                true,
                presentYes.isPresent() && !presentNo.isPresent()
        );
    }

    public void testOrElse() {

        Optional optional = new Optional(null);
        assertEquals(
                "Optional#orElse returns the wrong value.",
                "Value",
                optional.orElse("Value")
        );

    }

    public void testOrElseThrow() {

        Optional optional = new Optional(null);
        try {

            optional.orElseThrow(new NullPointerException("Invalid value."));
            fail("Expected InvalidArgumentException");

        } catch (Throwable throwable) {

            assertEquals(
                    String.format("Unexpected exception."),
                    throwable.getMessage(),
                    "Invalid value."
            );

        }

    }


}
