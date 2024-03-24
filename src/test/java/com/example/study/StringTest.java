package com.example.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@SpringBootTest
public class StringTest {

    @Test
    @DisplayName("'1,2' 문자열을 split을 통해 '1', '2' 가 반환되도록 구현한다.")
    void isSplit_ShouldSplitStringByComma() { // isSplit_Should
        String targetStr = "1,2";
        String[] split = targetStr.split(",");

        assertThat(split).contains("1", "2");
    }

    @Test
    @DisplayName("'1' 문자열을 split을 통해 '1'만 반환되도록 구현한다.")
    void isSplit_ShouldSplitStringWithOutComma() {
        String targetStr = "1";
        String[] split = targetStr.split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)' 문자열을 substring을 통해 '1,2'가 반환되도록 구현한다.")
    void isSubstring_ShouldSubstringStringWithIndex() {
        String targetStr = "(1,2)";
        int startIndex = targetStr.indexOf("(") + 1; // substring은 startIndex를 포함한다.
        int endIndex = targetStr.lastIndexOf(")");
        String substring = targetStr.substring(startIndex, endIndex);

        assertThat(substring).isEqualTo("1,2");
    }


    @Test
    @DisplayName("'abc' 문자열을 charAt을 통해 특정 위치의 문자가 반환되도록 구현한다.")
    void isCharAt_ShouldReturnCharacterByIndex() {
        String targetStr = "abc";
        // targetStr를 벗어나지 않는 범위의 index : 마지막 문자
        int index = targetStr.length() - 1;
        char charAt = targetStr.charAt(index);

        assertThat(charAt).isEqualTo('c');
    }

    @Test
    @DisplayName("'abc' 문자열을 charAt을 통해 특정 위치의 문자가 반환되도록 구현할 때 범위를 벗어나면 Exception이 발생하고 이를 assertThatThrownBy를 통해 확인한다.")
    void isCharAt_ShouldThrowsException_CheckWithThrownBy() {
        String targetStr = "abc";
        // targetStr를 벗어나는 범위의 index
        int index = targetStr.length() + 1;

        assertThatThrownBy(() -> {
            char charAt = targetStr.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("'abc' 문자열을 charAt을 통해 특정 위치의 문자가 반환되도록 구현할 때 범위를 벗어나면 Exception이 발생하고 이를 assertThatExceptionOfType를 통해 확인한다.")
    void isCharAt_ShouldThrowsException_CheckWithExceptionOfType() {
        String targetStr = "abc";
        // targetStr를 벗어나는 범위의 index
        int index = targetStr.length() + 1;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                char charAt = targetStr.charAt(index);
            }).withMessageContaining("%d", index);
    }
}
