package zjt.learn.howToMock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import zjt.learn.dto.MakeOrderDTO;
import zjt.learn.service.IOrderService;
import zjt.learn.service.IdGenerateService;
import zjt.learn.service.impl.IdGenerateServiceImpl;

import static org.mockito.Mockito.mock;

/**
 * 功能：
 *
 * @Author: zhaojiatao
 * @Date: 2022/5/16 11:11
 * @ClassName: MockByRuleTest
 */
public class MockByRuleTest {

    /**
     * 当想使用其他runner时，可以使用rule模式
     */
    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    @Mock
    private IOrderService orderService;

    @Test
    public void testMock(){
        //mock之后如果不stabbling，则返回默认值
        IdGenerateService idGenerateService=mock(IdGenerateServiceImpl.class);
        Long generate = idGenerateService.generate();
        System.out.println(generate);
        Assertions.assertEquals(0,generate);
    }


    @Test
    public void testMock2(){
        MakeOrderDTO result = orderService.query(1L);
        System.out.println(result);
        Assertions.assertNull(result);
    }

}
