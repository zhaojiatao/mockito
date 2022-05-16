package zjt.learn.service;
import zjt.learn.dto.MakeOrderDTO;

/**
 * 功能：
 *
 */
public interface IOrderService {

    MakeOrderDTO query(Long id);

    MakeOrderDTO makeOrder(MakeOrderDTO makeOrderDTO);
}
