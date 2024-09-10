package org.graalvm.demo;

import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

public class Application {
    private static final String MESSAGE = System.getenv("CUSTOM_MESSAGE");

    public static void main(String[] args) {
        var message = MESSAGE != null ? MESSAGE : "Hello, native, I'm using a method from commons-lang3!";
        System.out.println(capitalizeFully(message));
    }
}
