package com.github.ystromm.learn_quickcheck.job.conversion;

import com.github.ystromm.learn_quickcheck.job.ad.Ad;
import com.github.ystromm.learn_quickcheck.job.legacy.LegacyAd;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ResultTest {
    @Test
    public void empty_should_have_no_problems() {
        assertThat(Result.empty(legacyAd()).build().getProblems(), empty());
    }

    @Test
    public void empty_should_not_have_an_ad() {
        assertThat(Result.empty(legacyAd()).build().getAd(), equalTo(Optional.<Ad>empty()));
    }

    private LegacyAd legacyAd() {
        return LegacyAd.builder().id(1l).description("descriptionValue").address("adressValue").employer("employerValue").build();
    }

}