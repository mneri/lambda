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
    public static final λ NOT   = (λ p) -> β(p, FALSE, TRUE);
    public static final λ XOR   = (λ p) -> (λ q) -> β(p, β(NOT, q), q);
    public static final λ IF    = (λ p) -> (λ t) -> (λ f) -> β(p, t, f);

    public static final λ CONST  = (λ m) -> (λ x) -> m;
    public static final λ ISZERO = (λ n) -> β(n, (λ x) -> FALSE, TRUE);
    public static final λ SUCC   = (λ n) -> (λ f) -> (λ x) -> β(f, β(n, f, x));
    public static final λ PRED   = (λ n) -> (λ f) -> (λ x) -> β(n, (λ g) -> (λ h) -> β(h, β(g, f)), (λ u) -> x, (λ u) -> u);
    public static final λ ADD    = (λ m) -> (λ n) -> β(n, SUCC, m);
    public static final λ SUB    = (λ m) -> (λ n) -> β(n, PRED, m);
    public static final λ MUL    = (λ m) -> (λ n) -> (λ f) -> β(m, β(n, f));
    public static final λ EXP    = (λ m) -> (λ n) -> β(n, m);
    public static final λ MAX    = (λ m) -> (λ n) -> β(IF, β(ISZERO, β(SUB, m, n)), n, m);
    public static final λ MIN    = (λ m) -> (λ n) -> β(IF, β(ISZERO, β(SUB, m, n)), m, n);

    public static final λ LEQ   = (λ m) -> (λ n) -> β(ISZERO, β(SUB, m, n));
    public static final λ GEQ   = (λ m) -> (λ n) -> β(ISZERO, β(SUB, n, m));
    public static final λ EQ    = (λ m) -> (λ n) -> β(AND, β(LEQ, m, n), β(LEQ, n, m));
    public static final λ LESS  = (λ m) -> (λ n) -> β(AND, β(LEQ, m, n), β(NOT, β(LEQ, n, m)));
    public static final λ GREAT = (λ m) -> (λ n) -> β(AND, β(GEQ, m, n), β(NOT, β(GEQ, n, m)));

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

    public static final λ DIV    = β(Y, (λ f) -> (λ m) -> (λ n) -> β(IF, β(LESS, m, n), ZERO, β(SUCC, β(f, β(SUB, m, n), n))));
    public static final λ MOD    = β(Y, (λ f) -> (λ m) -> (λ n) -> β(IF, β(LESS, m, n), m, β(f, β(SUB, m, n), n)));
    public static final λ ISEVEN = (λ n) -> β(ISZERO, β(MOD, n, TWO));
    public static final λ ISODD  = (λ n) -> β(NOT, β(ISEVEN, n));

    public static final λ PAIR   = (λ x) -> (λ y) -> (λ z) -> β(z, x, y);
    public static final λ FIRST  = (λ p) -> β(p, (λ x) -> (λ y) -> x);
    public static final λ SECOND = (λ p) -> β(p, (λ x) -> (λ y) -> y);

    public static final λ CONS  = PAIR;
    public static final λ HEAD  = FIRST;
    public static final λ TAIL  = SECOND;
    public static final λ NIL   = FALSE;
    public static final λ ISNIL = (λ l) -> β(β(l, (λ h) -> (λ t) -> (λ d) -> FALSE), TRUE);

    public static final λ CAT    = β(Y, (λ f) -> (λ a) -> (λ b) -> β(IF, β(ISNIL, a), b, β(CONS, β(HEAD, a), β(f, β(TAIL, a), b))));
    public static final λ FILTER = β(Y, (λ f) -> (λ p) -> (λ l) -> β(IF, β(ISNIL, l), NIL, β(IF, β(p, β(HEAD, l)), β(CONS, β(HEAD, l), β(f, p, β(TAIL, l))), β(f, p, β(TAIL, l)))));
    public static final λ FLIP   = (λ f) -> (λ x) -> (λ y) -> β(f, y, x);
    public static final λ FOLDL  = β(Y, (λ f) -> (λ a) -> (λ z) -> (λ l) -> β(IF, β(ISNIL, l), z, β(a, β(HEAD, l), β(f, a, z, β(TAIL, l)))));
    public static final λ FOLDR  = β(Y, (λ f) -> (λ a) -> (λ z) -> (λ l) -> β(IF, β(ISNIL, l), z, β(a, β(f, a, z, β(TAIL, l)), β(HEAD, l))));
    public static final λ LEN    = β(FOLDR, (λ a) -> (λ c) -> β(SUCC, a), ZERO);
    public static final λ MAP    = β(Y, (λ f) -> (λ m) -> (λ l) -> β(IF, β(ISNIL, l), NIL, β(CONS, β(m, β(HEAD, l)), β(f, m, β(TAIL, l)))));
    public static final λ NTH    = β(Y, (λ f) -> (λ n) -> (λ l) -> β(IF, β(ISZERO, n), β(HEAD, l), β(f, β(PRED, n), β(TAIL, l))));
    //@formatter:on

    private Lambdas() {
    }
}
