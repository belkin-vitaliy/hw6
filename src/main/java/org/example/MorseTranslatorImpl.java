package org.example;

import java.util.HashMap;
import java.util.Map;

public class MorseTranslatorImpl implements MorseTranslator {

    // Карта для хранения символов и их соответствия коду Морзе
    private static final Map<Character, String> morseCodeMap = new HashMap<>();
    private static final Map<String, Character> reverseMorseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put('a', ".-");
        morseCodeMap.put('b', "-...");
        morseCodeMap.put('c', "-.-.");
        morseCodeMap.put('d', "-..");
        morseCodeMap.put('e', ".");
        morseCodeMap.put('f', "..-.");
        morseCodeMap.put('g', "--.");
        morseCodeMap.put('h', "....");
        morseCodeMap.put('i', "..");
        morseCodeMap.put('j', ".---");
        morseCodeMap.put('k', "-.-");
        morseCodeMap.put('l', ".-..");
        morseCodeMap.put('m', "--");
        morseCodeMap.put('n', "-.");
        morseCodeMap.put('o', "---");
        morseCodeMap.put('p', ".--.");
        morseCodeMap.put('q', "--.-");
        morseCodeMap.put('r', ".-.");
        morseCodeMap.put('s', "...");
        morseCodeMap.put('t', "-");
        morseCodeMap.put('u', "..-");
        morseCodeMap.put('v', "...-");
        morseCodeMap.put('w', ".--");
        morseCodeMap.put('x', "-..-");
        morseCodeMap.put('y', "-.--");
        morseCodeMap.put('z', "--..");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
        morseCodeMap.put('0', "-----");
        // Построение обратной карты для декодирования
        for (Map.Entry<Character, String> entry : morseCodeMap.entrySet()) {
            reverseMorseCodeMap.put(entry.getValue(), entry.getKey());
        }
    }

    @Override
    public String decode(String morseCode) {
        StringBuilder decodedText = new StringBuilder();
        String[] words = morseCode.split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                decodedText.append(reverseMorseCodeMap.get(letter));
            }
            decodedText.append(" ");
        }
        return decodedText.toString().trim();
    }

    @Override
    public String encode(String source) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : source.toLowerCase().toCharArray()) {
            if (c == ' ') {
                morseCode.append(" / ");
            } else {
                morseCode.append(morseCodeMap.get(c)).append(" ");
            }
        }
        return morseCode.toString().trim();
    }
}
