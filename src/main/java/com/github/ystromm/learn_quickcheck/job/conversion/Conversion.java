package com.github.ystromm.learn_quickcheck.job.conversion;

import com.github.ystromm.learn_quickcheck.job.legacy.LegacyAd;

public final class Conversion {
    static Result legacyAd2Ad(LegacyAd legacyAd) {

        if (legacyAd.getDescriptions().isEmpty()) {
            return Result.empty(legacyAd).problem(Problem.EMPTY_DESCRIPTION).build();
        }
        return Result.empty(legacyAd).build();
    }

    // hidden
    private Conversion() {
        // empty
    }
}
