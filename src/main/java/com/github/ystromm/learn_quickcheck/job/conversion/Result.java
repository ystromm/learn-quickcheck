package com.github.ystromm.learn_quickcheck.job.conversion;

import com.github.ystromm.learn_quickcheck.job.ad.Ad;
import com.github.ystromm.learn_quickcheck.job.legacy.LegacyAd;
import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

import java.util.Optional;
import java.util.Set;

/**
 * The result of a conversion.
 */
@Builder
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Result {
    @NonNull
    private LegacyAd legacyAd;
    @NonNull
    private Optional<Ad> ad = Optional.empty();
    @Singular
    @NonNull
    private Set<Problem> problems = ImmutableSet.of();

    public static Result empty(LegacyAd legacyAd) {
        return Result.builder().legacyAd(legacyAd).build();
    }
}
