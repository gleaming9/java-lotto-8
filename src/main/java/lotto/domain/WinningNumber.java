package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.*;

public class WinningNumber {
    private static final String BASE_DELIMITER = "[,]";
    private final List<Integer> numbers;

    public WinningNumber(String input){
        this.numbers = validate(input);
        Collections.sort(numbers);
    }

    private List<Integer> validate(String input){
        List<String> numberStrings = parseInput(input);
        List<Integer> convertedNumbers = convertAndValidateRules(numberStrings);
        validateDuplication(convertedNumbers);

        return convertedNumbers;
    }

    private List<String> parseInput(String input){
        List<String> numbers = Arrays.asList(input.split(BASE_DELIMITER));
        if(numbers.size() != LottoRule.LOTTO_NUMBER_COUNT.getValue()) {
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
        if(num < LottoRule.MIN_LOTTO_NUMBER.getValue()|| num > LottoRule.MAX_LOTTO_NUMBER.getValue()){
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
