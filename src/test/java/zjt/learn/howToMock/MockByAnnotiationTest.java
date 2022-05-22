package zjt.learn.howToMock;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import zjt.learn.dto.MakeOrderDTO;
import zjt.learn.service.IOrderService;

/**
 * 功能：
 * 当使用了@RunWith(MockitoJUnitRunner.class)就不需要使用MockitoAnnotations.openMocks(this);了
 * @Author: zhaojiatao
 * @Date: 2022/5/16 11:01
 * @ClassName: MockByAnnotiationTest
 */
@RunWith(MockitoJUnitRunner.class)
public class MockByAnnotiationTest {

    /*@Mock
    private OrderServiceImpl orderService;*/
    /**
     * 自动创建mock对象并注入
     */
    @Mock
    private IOrderService orderService;

    @Before
    public void init(){
        //如果使用@RunWith(MockitoJUnitRunner.class)，则此处无需初始化注解扫描
//        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMock(){
        MakeOrderDTO result = orderService.query(1L);
        System.out.println(result);
        Assertions.assertNull(result);
    }



}
