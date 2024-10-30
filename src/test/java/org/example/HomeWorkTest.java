package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    private final String ENCODE_TEXT = ".... . .-.. .-.. ---  / .-- --- .-. .-.. -..";
    private final String DECODE_TEXT = "hello world";
    HomeWork homeWork = new HomeWork();

    @Test
    void managerFabric() {
    }

    @Test
    void check() {
        MorseTranslator morseTranslator = homeWork.morseTranslator();
        /*
          Пример исходного сообщения: 'hello world'
          Пример закодированного: '.... . .-.. .-.. --- / .-- --- .-. .-.. -..'
         */
        assertEquals(ENCODE_TEXT, morseTranslator.encode(DECODE_TEXT));
        assertEquals(DECODE_TEXT, morseTranslator.decode(ENCODE_TEXT));

    }

    private List<String> generatePairs(List<Integer> expectedQueue) {
        List<String> pairs = new ArrayList<>();
        Function<Integer, Integer> map = (x) -> (x < 0 || x >= expectedQueue.size()) ? 0 : expectedQueue.get(x);

        for (int i = 0;
             i < expectedQueue.size(); i++) {
            pairs.add(String.format("%d:%d", map.apply(i - 1), map.apply(i + 1)));
        }
        Collections.shuffle(pairs);
        return pairs;
    }

    private List<Integer> generateQueue(int seed, int length) {
        return new Random(seed)
                .ints(1, length * 100)
                .limit(length)
                .boxed()
                .collect(Collectors.toList());
    }


}