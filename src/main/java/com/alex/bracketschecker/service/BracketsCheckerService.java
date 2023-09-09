package com.alex.bracketschecker.service;

import com.alex.bracketschecker.models.BracketsCheckerModel;

public interface BracketsCheckerService {
    BracketsCheckerModel checkBrackets(BracketsCheckerModel bracketsCheckerModel);
    boolean isEmptyBrackets(String text);
    boolean isCorrectBrackets (String text);
}
