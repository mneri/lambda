package me.mneri.lambda.example;

import me.mneri.lambda.λ;

import static me.mneri.lambda.Lambdas.*;
import static me.mneri.lambda.Redex.β;

public class Factorial {
    public static void main(String... args) {
        λ FACT = β(Y, (λ f) -> (λ n) -> β(IF, β(LEQ, n, ONE), ONE, β(MUL, n, β(f, β(PRED, n)))));
        λ r    = β(EQ, β(FACT, FIVE), β(MUL, TWELVE, TEN)).compute();

        System.out.println(r == TRUE ? "T" : "F");
    }
}
