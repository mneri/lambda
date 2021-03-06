# lambda
`lambda` is a really tiny library that brings lambda calculus in Java.

[![Build Status](https://travis-ci.org/mneri/lambda.svg?branch=master)](https://travis-ci.org/mneri/lambda)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7ee59eb78d354cbc9b38ffd3199e187e)](https://app.codacy.com/app/mneri7/lambda?utm_source=github.com&utm_medium=referral&utm_content=mneri/lambda&utm_campaign=Badge_Grade_Dashboard)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mneri/lambda.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mneri/lambda/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mneri/lambda.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mneri/lambda/alerts/)
[![Coverage Status](https://coveralls.io/repos/github/mneri/lambda/badge.svg?branch=master)](https://coveralls.io/github/mneri/lambda?branch=master)

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

Long story short, it sucks, but it has never been the goal.

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

# Examples
```java
λ FACT = β(Y, (λ f) -> (λ n) -> β(IF, β(LEQ, n, ONE),
                                      ONE,
                                      β(MUL, n, β(f, β(PRED, n)))));
```

```java
λ FIB = β(Y, (λ f) -> (λ n) -> β(IF, β(LEQ, n, TWO),
                                     ONE,
                                     β(ADD, β(f, β(PRED, n)), β(f, β(SUB, n, TWO)))));
```

```java
λ COLLATZ = β(Y, (λ f) -> (λ n) -> β(IF, β(EQ, n, ONE),
                                         β(CONS, ONE, NIL),
                                         β(CONS, n, β(f, β(IF, β(ISEVEN, n),
                                                               β(DIV, n, TWO),
                                                               β(SUCC, β(MUL, n, THREE)))))));
```

```java
λ SORT = β(Y, (λ f) -> (λ l) -> β(IF, β(ISNIL, l),
                                      NIL,
                                      β(CAT, β(CAT, β(f, β(FILTER, β(FLIP, LEQ, β(HEAD, l)), β(TAIL, l))),
                                                         β(CONS, β(HEAD, l), NIL)),
                                             β(f, β(FILTER, β(FLIP, GREAT, β(HEAD, l)), β(TAIL, l))))));
```
