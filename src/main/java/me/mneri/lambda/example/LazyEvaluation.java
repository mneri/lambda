package me.mneri.lambda.example;

import me.mneri.lambda.λ;

import static me.mneri.lambda.Lambdas.*;
import static me.mneri.lambda.Redex.β;

public class LazyEvaluation {
    public static void main(String... args) {
        λ DIE = β(IF, TRUE, I, β(Ω, Ω));
        λ r   = DIE.compute();

        System.out.println("Not dead, it works out of the box.");
    }
}
