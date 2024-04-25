package com.koreait.exam.batch_ex_24_04.app_batch_ex_24_04;


import org.junit.jupiter.api.DisplayName;
import com.koreait.exam.batch_ex_24_04.util.Util;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTests {
    @Test
    @DisplayName("특정 월의 마지막 날을 계산")
    void t1() {
        int endDayOf_2023_02 = Util.date.getEndDayOf(2023, 2);

        assertThat(endDayOf_2023_02).isEqualTo(28);

        int endDayOf_2024_02 = Util.date.getEndDayOf(2024, 2);

        assertThat(endDayOf_2024_02).isEqualTo(29);

        int endDayOf_2024_04 = Util.date.getEndDayOf(2024, 4);

        assertThat(endDayOf_2024_04).isEqualTo(31);
    }

}