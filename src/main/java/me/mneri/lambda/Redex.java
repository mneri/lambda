package me.mneri.lambda;

public class Redex implements λ {
    private λ cache;
    private λ x;
    private λ[] ys;

    private Redex(λ x, λ... ys) {
        this.x = x;
        this.ys = ys;
    }

    @Override
    public λ apply(λ x) {
        return compute().apply(x);
    }

    @Override
    public λ compute() {
        if (cache == null) {
            cache = x.compute();

            for (λ y : ys)
                cache = cache.apply(y);

            cache = cache.compute();

            x = null;
            ys = null;
        }

        return cache;
    }

    public static λ β(λ x, λ... ys) {
        return new Redex(x, ys);
    }
}
