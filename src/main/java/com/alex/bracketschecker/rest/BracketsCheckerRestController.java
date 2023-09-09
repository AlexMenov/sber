package com.alex.bracketschecker.rest;

import com.alex.bracketschecker.models.BracketsCheckerModel;
import com.alex.bracketschecker.service.BracketsCheckerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/checkBrackets")
public class BracketsCheckerRestController {
    private final BracketsCheckerService bracketsCheckerService;
    @PostMapping
    public BracketsCheckerModel bracketsChecker (BracketsCheckerModel bracketsCheckerModel) {
        return bracketsCheckerService.checkBrackets(bracketsCheckerModel);
    }
}
