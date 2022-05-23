package zjt.learn.springtest;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import zjt.learn.dao.IOrderDAO;
import zjt.learn.dto.MakeOrderDTO;
import zjt.learn.service.IOrderService;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 功能：
 *
 * @Author: zhaojiatao
 * @Date: 2022/5/23 14:35
 * @ClassName: OrderServiceTest
 */
public class OrderServiceTest extends BaseTest{


    @Autowired
    private IOrderService orderService;

    /**
     * @MockBean 注解将Mock对象添加到Spring上下文中。
     * 注解的对象将替换Spring上下文中任何相同类型的现有bean，如果没有定义相同类型的bean，将添加一个新的bean。
     */
    @MockBean
    private IOrderDAO orderDAO;


    @Before
    public void init(){
        //如果使用@RunWith(MockitoJUnitRunner.class)，则此处无需初始化注解扫描
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void queryTest(){
        MakeOrderDTO query = orderService.query(1L);
        System.out.println(JSON.toJSONString(query));
    }




    @Test
    public void queryTest2(){
        when(orderDAO.loadFromDB(anyLong())).thenReturn(MakeOrderDTO.builder().id(11111L).build());
        MakeOrderDTO query = orderService.query(1L);
        System.out.println(JSON.toJSONString(query));
    }


}
