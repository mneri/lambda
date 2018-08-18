# lambda
`lambda` is a small library that brings lambda calculus functions, syntax and lazy evaluation into Java.

In lambda calculus everything is a λ-expression: there is no such thing as integer, floating point or operator. Numbers, operators and complex objects such as lists are encoded via λ-expressions.

[![Build Status](https://travis-ci.org/mneri/lambda.svg?branch=master)](https://travis-ci.org/mneri/lambda)

# Introduction

One of the goals of the project is to make Java look like lambda calculus as much as possible. The identity function ![I](http://mneri.me/pnglatex?f=I%3D%5Clambda%20x%5Ccdot%20x%0A "I"), for example, is pretty close.

```java
λ I = (λ x) -> x;
```
β-reductions are introduced by the word `β`; for example, the ![AND](http://mneri.me/pnglatex?f=%5Cmbox%7BAND%7D%3D%5Clambda%20a%5Ccdot%5Clambda%20b%5Ccdot%20a%5C%20b%5C%20a "AND") function becomes

```java
λ AND = (λ a) -> (λ b) -> β(a, b, a);
```

# Performances

Long story short, it sucks. But that has never been the goal.

# Example
The Collatz function can be implemented as follows.

```java
λ COLLATZ = β(X, (λ f) -> (λ n) -> β(IF, β(EQ, n, ONE),
                                         β(CONS, ONE, NIL),
                                         β(CONS, n, β(f, β(IF, β(ISEVEN, n),
                                                               β(DIV, n, TWO),
                                                               β(SUCC, β(MUL, n, THREE)))))));
```

# Function Library
The library contains a good number of λ-expressions. For example, three different fixed-point combinators (`X`, `Y`, and `Θ`).

```java
λ X = (λ f) -> β((λ x) -> β(x, x), (λ x) -> β(f, β(x, x)));
λ Y = (λ f) -> β((λ x) -> β(f, β(x, x)), (λ x) -> β(f, β(x, x)));
λ Θ = β((λ x) -> (λ y) -> β(y, β(x, x, y)), (λ x) -> (λ y) -> β(y, β(x, x, y)));
```

Church encoding for numbers through 16 and powers of two through 1024 have been implemented.

```java
λ ZERO  = (λ f) -> (λ x) -> x;
λ ONE   = β(SUCC, ZERO);
λ TWO   = β(SUCC, ONE);
// ...
λ ONETHOUSANDTWENTYFOUR = β(EXP, TWO, TEN);
```

Standard high-order functions such as `FILTER`, `MAP`, `FOLDL` and `FOLDR`.
