package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber){
        this.winningNumber = new ArrayList<>(winningNumber);
        Collections.sort(winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
