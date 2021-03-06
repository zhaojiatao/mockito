package zjt.learn.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import zjt.learn.dao.IOrderDAO;
import zjt.learn.dto.MakeOrderDTO;
import zjt.learn.service.IdGenerateService;

import static org.mockito.Mockito.when;

/**
 * 功能：
 *
 * @Author: zhaojiatao
 * @Date: 2022/5/16 20:43
 * @ClassName: OrderServiceImplTest
 */
class OrderServiceImplTest {


    @InjectMocks
    @Spy
    private OrderServiceImpl orderService;

    @Mock
    private IdGenerateService idGenerateService;

    @Mock
    private IOrderDAO orderDAO;

    @BeforeEach
    void setUp() {
        //mock 注解需要搭配 MockitoAnnotations.openMocks(testClass) 方法一起使用。
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void makeOrder() {
        try{
            orderService.makeOrder(null);
            Assertions.fail("这里会挂掉");
        }catch (Exception e){
            Assertions.assertTrue(e instanceof RuntimeException);
        }

        {
            MakeOrderDTO makeOrderDTO=new MakeOrderDTO();
            //给普通mock对象打桩
            when(idGenerateService.generate()).thenReturn(123456789L);
        }


        {
            //mock静态方法必须使用mockito-inline
            //对静态方法打桩
            //使用 mockStatic() 方法来 mock静态方法的所属类，此方法返回一个具有作用域的模拟对象。

            /**
             * 最好使用java7的try-with-resources，自动关闭资源
             * 原因是因为 mockStatic() 方法是将当前需要 mock 的类注册到本地线程上（ThreadLocal），
             * 而这个注册在一次 mock 使用完之后是不会消失的，需要我们手动的去销毁。
             * 如过没有销毁，再次 mock 这个类的时候 Mockito 将会提示我们
             * ：”当前对象 mock 的对象已经在线程中注册了，请先撤销注册后再试“。
             * 这样做的目的也是为了保证模拟出来的对象之间是相互隔离的，
             * 保证同时和连续的测试不会收到上下文的影响。
             *
             * */


            try(MockedStatic<OrderServiceImpl> staticService = Mockito.mockStatic(OrderServiceImpl.class)){
                staticService.when(() -> OrderServiceImpl.buildName(Mockito.any())).thenReturn("aabb");
                staticService.when(() -> OrderServiceImpl.buildName("aa1")).thenCallRealMethod();
                Assertions.assertEquals("aabb", OrderServiceImpl.buildName("aa"));
                Assertions.assertEquals("aa1CC", OrderServiceImpl.buildName("aa1"));
            }
        }

        {
            when(idGenerateService.generate()).thenThrow(new RuntimeException("自定义异常"));
            try{
                MakeOrderDTO makeOrderDTO=new MakeOrderDTO();
                orderService.makeOrder(makeOrderDTO);
                Assertions.fail("这里会挂掉");
            }catch (Exception e){
                System.out.println(e.getMessage());
                Assertions.assertTrue(e instanceof RuntimeException);
            }

        }

    }

}