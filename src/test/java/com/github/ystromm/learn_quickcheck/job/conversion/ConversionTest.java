package com.github.ystromm.learn_quickcheck.job.conversion;

import com.github.ystromm.learn_quickcheck.job.legacy.LegacyAd;
import com.google.common.collect.ImmutableList;
import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.CombinedGenerators;
import net.java.quickcheck.generator.iterable.Iterables;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.github.ystromm.learn_quickcheck.job.conversion.Problem.EMPTY_DESCRIPTION;
import static java.util.Arrays.asList;
import static net.java.quickcheck.generator.CombinedGenerators.lists;
import static net.java.quickcheck.generator.PrimitiveGenerators.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ConversionTest {

    static Generator<String> strings(final List<String> strings) {
        return new Generator<String>() {
            private final Generator<Integer> indices = integers(0, strings.size());

            @Override
            public String next() {
                return strings.get(indices.next());
            }
        };
    }

    static class LegacyAds implements Generator<LegacyAd> {


        final Generator<String> adresses = strings(asList("",
                "Regeringsgatan, Stockholm",
                "Storsvängen 95, Hägersten",
                "Örnsberg",
                "New Jersey"));
        final Generator<String> employers = strings(Arrays.asList("",
                "Omegapoint AB",
                "Google Inc.",
                "Pub Diset",
                "Berras bil"));
        final Generator<Long> ids = longs();
        final Generator<List<String>> descriptions = lists(printableStrings());

        @Override
        public LegacyAd next() {
            return LegacyAd.builder()
                    .id(ids.next())
                    // s.employer(employers.next())
                    .address(adresses.next())
                    .descriptions(descriptions.next())
                    .build();
        }
    }

    Iterable<LegacyAd> legacyAds() {
        return Iterables.toIterable(new LegacyAds());
    }

    @Test
    public void empty_descriptions_should_have_problem_empty_description() {
        for (LegacyAd legacyAd : legacyAds()) {
            if (legacyAd.getDescriptions().isEmpty()) {
                assertThat(Conversion.legacyAd2Ad(legacyAd).getProblems(), contains(EMPTY_DESCRIPTION));
            }
        }
    }

    @Test
    public void non_empty_descriptions_should_have_heading() {
        for (LegacyAd legacyAd : legacyAds()) {
            if (!legacyAd.getDescriptions().isEmpty()) {
                final String heading = legacyAd.getDescriptions().get(0);
                final Result result = Conversion.legacyAd2Ad(legacyAd);
                if (result.getAd().isPresent()) {
                    assertThat(result.getAd().get().getHeading(), equalTo(heading));
                }
            }
        }
    }

    @Test
    public void result_should_have_no_problems() {
        for (LegacyAd legacyAd : legacyAds()) {
            final Result result = Conversion.legacyAd2Ad(legacyAd);
            if (result.getAd().isPresent()) {
                assertThat(result.getProblems(), empty());
            }
        }
    }

}