package com.craftincode.turbochess.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(ValidatorTests.class)
@Categories.ExcludeCategory(SlowTests.class)
@Suite.SuiteClasses({QueenMoveValidatorParameterizedTest.class,QueenMoveValidatorTest.class})
public class ValidatorSuite {
}
