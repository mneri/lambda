# lambda
lambda is a small library that brings lambda calculus functions, syntax and lazy evaluation into Java.

[![Build Status](https://travis-ci.org/mneri/lambda.svg?branch=master)](https://travis-ci.org/mneri/lambda)
# Introduction

One of the goals of the project is to make Java look like lambda calculus as much as possible. The identity function ![I](http://mneri.me/pnglatex?f=I%3D%5Clambda%20x%5Ccdot%20x%0A "I"), for example, is pretty close.

```java
λ I = (λ x) -> x;
```
β-reductions are introduced by the word `β`; the ![AND](http://mneri.me/pnglatex?f=%5Cmbox%7BAND%7D%3D%5Clambda%20a%5Ccdot%5Clambda%20b%5Ccdot%20a%5C%20b%5C%20a "AND") function becomes

```java
λ AND = (λ p) -> (λ q) -> β(p, q, p);
```
