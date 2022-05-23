package zjt.learn.springtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zjt.learn.MockitoApplication;

/**
 * 功能：
 *
 * @Author: zhaojiatao
 * @Date: 2022/5/23 14:35
 * @ClassName: BaseTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockitoApplication.class)
public class BaseTest {
    @Test
    public void testBase() {
        Assert.assertTrue(true);
    }
}
