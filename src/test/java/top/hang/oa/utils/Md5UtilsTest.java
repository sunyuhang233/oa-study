package top.hang.oa.utils;

import org.junit.jupiter.api.Test;

class Md5UtilsTest {

    @Test
    void md5Digest() {
        System.out.println(Md5Utils.md5Digest("test", 188));
    }
}