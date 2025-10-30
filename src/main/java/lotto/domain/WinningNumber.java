package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.*;

public class WinningNumber {
    private static final String BASE_DELIMITER = "[,]";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private List<Integer> numbers;

    public WinningNumber(String input){
        this.numbers = validate(input);
    }

    private List<Integer> validate(String input){
        List<String> numberStrings = parseInput(input);
        List<Integer> convertedNumbers = convertAndValidateRules(numberStrings);
        validateDuplication(convertedNumbers);

        return convertedNumbers;
    }

    private List<String> parseInput(String input){
        List<String> numbers = Arrays.asList(input.split(BASE_DELIMITER));
        if(numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
        return numbers;
    }

    private List<Integer> convertAndValidateRules(List<String> numbers){
        List<Integer> convertedNumbers = new ArrayList<>();
        for(String numberStr : numbers){
            try{
                int num = Integer.parseInt(numberStr.trim());
                validateRange(num);
                convertedNumbers.add(num);
            }
            catch(NumberFormatException e){
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
            }
        }
        return convertedNumbers;
    }

    private void validateRange(int num){
        if(num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPICATE_WINNING_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
