package com.yveschiong.yelpreviews;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.yveschiong.yelpreviews.rules.RxImmediateSchedulerRule;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

// Base class for Unit tests. Inherit from it to create test cases which DO NOT contain android
// framework dependencies or components.
@RunWith(MockitoJUnitRunner.class)
public abstract class UnitTests {
    @ClassRule
    public static final RxImmediateSchedulerRule SCHEDULERS = new RxImmediateSchedulerRule();

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
}
