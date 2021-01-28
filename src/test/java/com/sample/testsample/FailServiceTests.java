package com.sample.testsample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FailServiceTests {
    @Disabled
    @Test
    public void 失敗するテスト() {
        Assertions.assertEquals(100, 200);
    }
}
