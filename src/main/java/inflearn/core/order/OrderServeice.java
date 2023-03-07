package inflearn.core.order;

public interface OrderServeice {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
