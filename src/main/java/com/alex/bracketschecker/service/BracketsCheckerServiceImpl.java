package com.alex.bracketschecker.service;

import com.alex.bracketschecker.models.BracketsCheckerModel;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BracketsCheckerServiceImpl implements BracketsCheckerService {
    @Override
    public BracketsCheckerModel checkBrackets(BracketsCheckerModel bracketsCheckerModel) {
        String text = bracketsCheckerModel.getText();
        bracketsCheckerModel.setIsCorrect(!(text.trim().isEmpty() || isEmptyBrackets(text) || isCorrectBrackets(text)));
        return bracketsCheckerModel;
    }

    @Override
    public boolean isEmptyBrackets(String text) {
        return Pattern.compile("\\(\\s*\\)").matcher(text).find();
    }

    @Override
    public boolean isCorrectBrackets(String text) {
        return text.chars()
                       .filter(c -> c == '(' || c == ')')
                       .mapToObj(c -> (char) c)
                       .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                       .values()
                       .stream()
                       .reduce((a, b) -> a - b)
                       .orElse(0L) != 0;
    }
}
