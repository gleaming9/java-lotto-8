package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int calcMatchCount(List<Integer> numbers) {
        int matchCount = 0;
        for (int num : numbers) {
            if (winningNumber.contains(num)) matchCount++;
        }
        return matchCount;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
