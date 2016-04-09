package com.github.ystromm.learn_quickcheck.job.ad;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Wither;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * New and shiny job ad.
 */
@Value
@Wither
@Builder
public class Ad {
    @NonNull
    UUID id;
    @NonNull
    Instant lastChange;
    @NonNull
    String heading;
    @NonNull
    @Singular
    List<String> descriptions;
    @NonNull
    String adress;
    @NonNull
    Location location;
}
