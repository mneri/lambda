package me.mneri.lambda;

@FunctionalInterface
public interface λ {
    λ apply(λ x);

    default λ compute() {
        return this;
    }
}
