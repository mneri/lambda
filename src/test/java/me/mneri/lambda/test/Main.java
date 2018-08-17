package me.mneri.lambda.test;

import me.mneri.lambda.λ;

import org.junit.Test;

import static me.mneri.lambda.Lambdas.*;
import static me.mneri.lambda.Redex.β;

import static org.junit.Assert.*;

public class Main {
    @Test
    public void collatz() {
        //@formatter:off
        λ COLLATZ = β(X, (λ f) -> (λ n) -> β(IF, β(EQ, n, ONE),
                                                 β(CONS, ONE, NIL),
                                                 β(CONS, n, β(f, β(IF, β(ISEVEN, n),
                                                                       β(DIV, n, TWO),
                                                                       β(SUCC, β(MUL, n, THREE)))))));
        β(COLLATZ, FIFTEEN).compute();
        //@formatter:on
    }

    @Test
    public void comparison() {
        λ M = β(SUCC, β(EXP, TWO, TEN));
        λ N = β(EXP, TWO, TEN);
        assertEquals(β(GREAT, M, N).compute(), TRUE);
        assertEquals(β(LESS, N, M).compute(), TRUE);
    }

    @Test
    public void factorial() {
        //@formatter:off
        λ FACT = β(Y, (λ f) -> (λ n) -> β(IF, β(LEQ, n, ONE),
                                              ONE,
                                              β(MUL, n, β(f, β(PRED, n)))));
        assertEquals(β(EQ, β(FACT, FIVE), β(MUL, TWELVE, TEN)).compute(), TRUE);
        //@formatter:on
    }

    @Test
    public void fibonacci() {
        //@formatter:off
        λ FIB = β(Θ, (λ f) -> (λ n) -> β(IF, β(LEQ, n, TWO),
                                             ONE,
                                             β(ADD, β(f, β(PRED, n)), β(f, β(SUB, n, TWO)))));
        assertEquals(β(EQ, β(FIB, SEVEN), THIRTEEN).compute(), TRUE);
        //@formatter:on
    }

    @Test
    public void filter() {
        λ LIST = β(CONS, ONE, β(CONS, TWO, β(CONS, THREE, β(CONS, FOUR, NIL))));
        assertEquals(β(EQ, β(LEN, β(FILTER, ISEVEN, LIST)), TWO).compute(), TRUE);
    }

    @Test
    public void fold() {
        //@formatter:off
        λ LIST = β(CONS, ONE, β(CONS, TWO, β(CONS, THREE, β(CONS, FOUR, NIL))));
        λ SUML = β(FOLDL, ADD, ZERO);
        λ SUMR = β(FOLDR, ADD, ZERO);
        λ SUM  = β(DIV, β(MUL, FOUR, β(SUCC, FOUR)), TWO);
        assertEquals(β(EQ, β(SUML, LIST), β(SUMR, LIST)).compute(), TRUE);
        assertEquals(β(EQ, SUM, β(SUML, LIST)).compute(), TRUE);
        //@formatter:on
    }

    @Test
    public void lazy() {
        λ DIE = β(IF, TRUE, I, Ω);
        DIE.compute();
    }

    @Test
    public void len() {
        λ LIST = β(CONS, ONE, β(CONS, TWO, β(CONS, THREE, β(CONS, FOUR, NIL))));
        assertEquals(β(EQ, β(LEN, LIST), FOUR).compute(), TRUE);
    }

    @Test
    public void max() {
        assertEquals(β(EQ, β(MAX, FOUR, FIVE), FIVE).compute(), TRUE);
        assertEquals(β(EQ, β(MAX, FIVE, FIVE), FIVE).compute(), TRUE);
    }

    @Test
    public void min() {
        assertEquals(β(EQ, β(MIN, FOUR, FIVE), FOUR).compute(), TRUE);
        assertEquals(β(EQ, β(MIN, FOUR, FOUR), FOUR).compute(), TRUE);
    }
}
