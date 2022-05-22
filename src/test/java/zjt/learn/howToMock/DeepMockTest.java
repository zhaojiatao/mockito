package zjt.learn.howToMock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import zjt.learn.dto.MakeOrderDTO;
import zjt.learn.service.impl.OrderServiceImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

/**
 * 功能：
 *
 * @Author: zhaojiatao
 * @Date: 2022/5/16 13:24
 * @ClassName: DeepMockTest02
 */
@RunWith(MockitoJUnitRunner.class)
public class DeepMockTest {

    @Mock
    private OrderServiceImpl orderService;

    @Mock
    private MakeOrderDTO makeOrderDTO;


    @Before
    public void init(){
//        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeepMock(){
        when( orderService.query(Mockito.anyLong())).thenReturn(makeOrderDTO);
        MakeOrderDTO result = orderService.query(1L);
        when(makeOrderDTO.getId()).thenReturn(1111L);
        assertThat(result.getId(),equalTo(1111L));
    }
}
