package com.sportconnect.teamsservice;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamAggregateTest {
    private FixtureConfiguration<TeamAggregate> fixture;

    public void setUp() {
        fixture = new AggregateTestFixture<>(TeamAggregate.class);
    }
}
