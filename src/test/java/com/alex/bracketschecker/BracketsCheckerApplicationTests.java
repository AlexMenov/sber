package com.alex.bracketschecker;

import com.alex.bracketschecker.models.BracketsCheckerModel;
import com.alex.bracketschecker.service.BracketsCheckerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BracketsCheckerApplicationTests {
    private final BracketsCheckerService bracketsCheckerService;

    @Autowired
    BracketsCheckerApplicationTests(BracketsCheckerService bracketsCheckerService) {
        this.bracketsCheckerService = bracketsCheckerService;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testCheckBracketsIsCorrect() {
        Collection<BracketsCheckerModel> models = List.of(
                new BracketsCheckerModel(true, "(abc)"),
                new BracketsCheckerModel(true, "(это мое любимое место для отдыха)"),
                new BracketsCheckerModel(true, "((для) разнообразия)."),
                new BracketsCheckerModel(true, "(я почувствовал, (что) все (усилия (стоили)) того)."),
                new BracketsCheckerModel(true, "]"),
                new BracketsCheckerModel(true, "(abc) (def)"),
                new BracketsCheckerModel(true, "((abc) def)"),
                new BracketsCheckerModel(true, "(abc) (def) (ghi)"),
                new BracketsCheckerModel(true, "(abc (def)) (ghi)"),
                new BracketsCheckerModel(true, "((abc (def)) ghi)"));
        for (BracketsCheckerModel model : models) {
            Boolean result = bracketsCheckerService.checkBrackets(model).getIsCorrect();
            System.out.println(result);
            assertTrue(result);
        }
    }

    @Test
    public void testCheckBracketsIsNotCorrect() {
        Collection<BracketsCheckerModel> models = List.of(
                new BracketsCheckerModel(false, ""),
                new BracketsCheckerModel(false, "       "),
                new BracketsCheckerModel(false, "()"),
                new BracketsCheckerModel(false, "(     )"),
                new BracketsCheckerModel(false, "((]"),
				new BracketsCheckerModel(false, "(({}[()]))"),
                new BracketsCheckerModel(false, "((dd)d)d)d)d]"),
                new BracketsCheckerModel(false, "(()"),
                new BracketsCheckerModel(true, "(a (b (c (d (e (f (g (h (i))))))))))"));
        for (BracketsCheckerModel model : models) {
            Boolean result = bracketsCheckerService.checkBrackets(model).getIsCorrect();
            assertFalse(result);
        }
    }
}
