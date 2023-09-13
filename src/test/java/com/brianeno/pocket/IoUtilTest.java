package com.brianeno.pocket;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class IoUtilTest {

    @Test
    void shouldConvertStreamToBytes() throws IOException {
        // given
        byte[] streamBytes = "some test stream bytes".getBytes();
        InputStream is = new ByteArrayInputStream(streamBytes);

        // when
        byte[] outputBytes = IoUtil.toBytes(is);

        // then
        assertThat(outputBytes).isEqualTo(streamBytes);
    }
}