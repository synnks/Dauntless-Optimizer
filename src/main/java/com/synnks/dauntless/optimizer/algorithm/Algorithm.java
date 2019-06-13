package com.synnks.dauntless.optimizer.algorithm;

import java.util.Collection;

@FunctionalInterface
public interface Algorithm {

    Collection<Solution> solve();
}
