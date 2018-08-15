package me.mneri.lambda;

import java.util.function.Function;

@FunctionalInterface
public interface λ extends Function<λ, λ> {
    λ apply(λ x);

    default λ compute() {
        return this;
    }
}
