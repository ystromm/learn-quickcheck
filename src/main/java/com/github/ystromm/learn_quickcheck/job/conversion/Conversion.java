package com.github.ystromm.learn_quickcheck.job.conversion;

import com.github.ystromm.learn_quickcheck.job.legacy.LegacyAd;

public final class Conversion {
    static Result legacyAd2Ad(LegacyAd legacyAd) {
        return Result.empty(legacyAd);
    }

    // hidden
    private Conversion() {
        // empty
    }
}
