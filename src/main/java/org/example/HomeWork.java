package org.example;


import java.util.List;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Требуется реализовать интерфейс MorseTranslator в соответствии с JavaDoc описанием.
     */
    MorseTranslator morseTranslator;

    public HomeWork(MorseTranslator morseTranslator) {
        this.morseTranslator = morseTranslator;
    }

    public HomeWork() {
        this.morseTranslator = new MorseTranslatorImpl();
    }

    public MorseTranslator morseTranslator() {
        return this.morseTranslator;
    }

}
