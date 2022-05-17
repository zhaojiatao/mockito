package zjt.learn.howToMock;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import zjt.learn.service.IdGenerateService;
import zjt.learn.service.impl.IdGenerateServiceImpl;

import static org.mockito.Mockito.mock;

/**
 * 功能：
 *
 * @Author: zhaojiatao
 * @Date: 2022/5/16 10:34
 * @ClassName: MockByRunnerTest
 */
@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {


    @Test
    public void testMock(){
        //mock之后如果不stabbling，则返回默认值
        IdGenerateService idGenerateService=mock(IdGenerateServiceImpl.class);
        Long generate = idGenerateService.generate();
        System.out.println(generate);
        Assertions.assertEquals(0,generate);
    }


}
