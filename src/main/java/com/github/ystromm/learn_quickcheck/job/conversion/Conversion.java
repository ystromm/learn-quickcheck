package com.github.ystromm.learn_quickcheck.job.conversion;

import com.github.ystromm.learn_quickcheck.job.legacy.LegacyAd;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Conversion {
    private final GetLocation getLocation;

    Result legacyAd2Ad(LegacyAd legacyAd) {

        if (legacyAd.getDescriptions().isEmpty()) {
            return Result.empty(legacyAd).problem(Problem.EMPTY_DESCRIPTION).build();
        }
        return Result.empty(legacyAd).build();
    }
}
