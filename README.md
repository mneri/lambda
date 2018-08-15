# lambda
lambda is a small library that brings lambda calculus functions, syntax and lazy evaluation into Java.

# Examples

The simplest example is the identity function

![I](http://mneri.me/pnglatex?f=I%3D%5Clambda%20x%5Ccdot%20x%0A "I")

In Java

    λ I = (λ x) -> x;

Other examples:

    λ TRUE  = (λ t) -> (λ f) -> t;
    λ FALSE = (λ t) -> (λ f) -> f;
    λ AND   = (λ p) -> (λ q) -> β(p, q, p);
    λ OR    = (λ p) -> (λ q) -> β(p, p, q);
    λ NOT   = (λ b) -> (λ t) -> (λ f) -> β(b, f, t);
    λ XOR   = (λ p) -> (λ q) -> β(p, β(q, FALSE, p), q);
