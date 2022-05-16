package zjt.learn.howToMock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import zjt.learn.dto.MakeOrderDTO;
import zjt.learn.service.IOrderService;
import zjt.learn.service.impl.OrderServiceImpl;

/**
 * 功能：
 *
 * @Author: zhaojiatao
 * @Date: 2022/5/16 11:01
 * @ClassName: MockByAnnotiationTest
 */
public class MockByAnnotiationTest {

    @Mock
    private OrderServiceImpl orderService;

    @Before
    public void init(){
        //如果使用@RunWith(MockitoJUnitRunner.class)，则此处无需初始化注解扫描
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMock(){
        MakeOrderDTO result = orderService.query(1L);
        System.out.println(result);
    }



}
