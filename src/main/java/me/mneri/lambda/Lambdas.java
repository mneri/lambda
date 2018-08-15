package me.mneri.lambda;

import static me.mneri.lambda.Redex.β;

public final class Lambdas {
    //@formatter:off
    public static final λ B = (λ x) -> (λ y) -> (λ z) -> β(x, β(y, z));
    public static final λ C = (λ x) -> (λ y) -> (λ z) -> β(x, z, y);
    public static final λ I = (λ x) -> x;
    public static final λ K = (λ x) -> (λ y) -> x;
    public static final λ S = (λ x) -> (λ y) -> (λ z) -> β(x, z, β(y, z));
    public static final λ U = (λ x) -> (λ y) -> β(y, β(x, x, y));
    public static final λ W = (λ x) -> (λ y) -> β(x, y, y);
    public static final λ X = (λ f) -> β((λ x) -> β(x, x), (λ x) -> β(f, β(x, x)));
    public static final λ Y = (λ f) -> β((λ x) -> β(f, β(x, x)), (λ x) -> β(f, β(x, x)));
    public static final λ Θ = β((λ x) -> (λ y) -> β(y, β(x, x, y)), (λ x) -> (λ y) -> β(y, β(x, x, y)));
    public static final λ ι = (λ f) -> β(f, S, K);
    public static final λ ω = (λ x) -> β(x, x);
    public static final λ Ω = β(ω, ω);

    public static final λ TRUE  = (λ t) -> (λ f) -> t;
    public static final λ FALSE = (λ t) -> (λ f) -> f;
    public static final λ AND   = (λ p) -> (λ q) -> β(p, q, p);
    public static final λ OR    = (λ p) -> (λ q) -> β(p, p, q);
    public static final λ NOT   = (λ b) -> (λ t) -> (λ f) -> β(b, f, t);
    public static final λ XOR   = (λ p) -> (λ q) -> β(p, β(q, FALSE, p), q);
    public static final λ IF    = (λ p) -> (λ t) -> (λ f) -> β(p, t, f);

    public static final λ ISZERO = (λ n) -> β(n, (λ x) -> FALSE, TRUE);
    public static final λ SUCC = (λ n) -> (λ f) -> (λ x) -> β(f, β(n, f, x));
    public static final λ PRED = (λ n) -> (λ f) -> (λ x) -> β(n, (λ g) -> (λ h) -> β(h, β(g, f)), (λ u) -> x, (λ u) -> u);
    public static final λ ADD  = (λ m) -> (λ n) -> β(n, SUCC, m);
    public static final λ SUB  = (λ m) -> (λ n) -> β(n, PRED, m);
    public static final λ MUL  = (λ m) -> (λ n) -> (λ f) -> β(m, β(n, f));
    public static final λ EXP  = (λ m) -> (λ n) -> β(n, m);

    public static final λ LEQ    = (λ m) -> (λ n) -> β(ISZERO, β(SUB, m, n));
    public static final λ GEQ    = (λ m) -> (λ n) -> β(ISZERO, β(SUB, n, m));
    public static final λ EQ     = (λ m) -> (λ n) -> β(AND, β(LEQ, m, n), β(LEQ, n, m));
    public static final λ LESS   = (λ m) -> (λ n) -> β(AND, β(LEQ, m, n), β(NOT, β(EQ, m, n)));
    public static final λ GREAT  = (λ m) -> (λ n) -> β(AND, β(GEQ, m, n), β(NOT, β(EQ, m, n)));

    public static final λ ZERO     = (λ f) -> (λ x) -> x;
    public static final λ ONE      = β(SUCC, ZERO);
    public static final λ TWO      = β(SUCC, ONE);
    public static final λ THREE    = β(SUCC, TWO);
    public static final λ FOUR     = β(SUCC, THREE);
    public static final λ FIVE     = β(SUCC, FOUR);
    public static final λ SIX      = β(SUCC, FIVE);
    public static final λ SEVEN    = β(SUCC, SIX);
    public static final λ EIGHT    = β(SUCC, SEVEN);
    public static final λ NINE     = β(SUCC, EIGHT);
    public static final λ TEN      = β(SUCC, NINE);
    public static final λ ELEVEN   = β(SUCC, TEN);
    public static final λ TWELVE   = β(SUCC, ELEVEN);
    public static final λ THIRTEEN = β(SUCC, TWELVE);
    public static final λ FOURTEEN = β(SUCC, THIRTEEN);
    public static final λ FIFTEEN  = β(SUCC, FOURTEEN);
    public static final λ SIXTEEN  = β(SUCC, FIFTEEN);

    public static final λ THIRTYTWO             = β(EXP, TWO, FIVE);
    public static final λ SIXTYFOUR             = β(EXP, TWO, SIX);
    public static final λ ONEHUNDREDTWENTYEIGHT = β(EXP, TWO, SEVEN);
    public static final λ TWOHUNDREDFIFTYSIX    = β(EXP, TWO, EIGHT);
    public static final λ FIVEHUNDREDSIXTEEN    = β(EXP, TWO, NINE);
    public static final λ ONETHOUSANDTWENTYFOUR = β(EXP, TWO, TEN);

    public static final λ PAIR  = (λ x) -> (λ y) -> (λ z) -> β(z, x, y);
    public static final λ FIRST = (λ p) -> β(p, (λ x) -> (λ y) -> x);
    public static final λ SECOND = (λ p) -> β(p, (λ x) -> (λ y) -> y);
    //@formatter:on

    private Lambdas() {
    }
}
