package com.github.ystromm.learn_quickcheck.job.ad;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Location {
    Double longitude;
    Double latitude;
}
