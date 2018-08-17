package me.mneri.lambda;

public class Redex implements λ {
    private λ cache;
    private λ x;
    private λ y;
    private λ[] zs;

    private Redex(λ x, λ y, λ... zs) {
        this.x = x;
        this.y = y;
        this.zs = zs;
    }

    @Override
    public λ apply(λ x) {
        return compute().apply(x);
    }

    @Override
    public λ compute() {
        if (cache == null) {
            cache = x.apply(y);

            for (λ z : zs)
                cache = cache.apply(z);

            cache = cache.compute();

            x = null;
            y = null;
            zs = null;
        }

        return cache;
    }

    public static λ β(λ x, λ y, λ... z) {
        return new Redex(x, y, z);
    }
}
