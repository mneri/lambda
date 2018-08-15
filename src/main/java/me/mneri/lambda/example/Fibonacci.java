package me.mneri.lambda.example;

import me.mneri.lambda.λ;

import static me.mneri.lambda.Lambdas.*;
import static me.mneri.lambda.Redex.β;

public class Fibonacci {
    public static void main(String... args) {
        λ FIB = β(Y, (λ f) -> (λ n) -> β(IF, β(LEQ, n, TWO), ONE, β(ADD, β(f, β(SUB, n, ONE)), β(f, β(SUB, n, TWO)))));
        λ r   = β(EQ, β(FIB, SEVEN), THIRTEEN).compute();

        System.out.println(r == TRUE ? "T" : "F");
    }
}
