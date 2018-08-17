package me.mneri.lambda.example;

import me.mneri.lambda.λ;

import static me.mneri.lambda.Lambdas.*;
import static me.mneri.lambda.Redex.β;

public class Collatz {
    public static void main(String... args) {
        //@formatter:off
        λ COLLATZ = β(Y, (λ f) -> (λ n) -> β(IF, β(EQ, n, ONE),
                                                 β(CONS, ONE, NIL),
                                                 β(CONS, n, β(f, β(IF, β(ISEVEN, n),
                                                                 β(DIV, n, TWO),
                                                                 β(SUCC, β(MUL, n, THREE)))))));
        //@formatter:on

        β(COLLATZ, FIFTEEN).compute();
    }
}
