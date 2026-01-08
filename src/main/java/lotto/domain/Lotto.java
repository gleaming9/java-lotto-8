package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }
    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> myset = new HashSet<>(numbers);
        if(myset.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public String lottoString(){
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ","[","]"));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
