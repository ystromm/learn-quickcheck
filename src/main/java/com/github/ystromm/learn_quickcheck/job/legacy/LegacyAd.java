package com.github.ystromm.learn_quickcheck.job.legacy;

import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Wither;

import java.util.List;

/**
 * Legacy job advertisement.
 */
@Value
@Builder
@Wither
public class LegacyAd {
    @NonNull
    private Long id;
    @NonNull
    private String employer;
    @NonNull
    @Singular
    private List<String> descriptions;
    @NonNull
    private String address;
}
