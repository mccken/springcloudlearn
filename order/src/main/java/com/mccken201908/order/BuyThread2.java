package com.mccken201908.order;

//import com.huobi.client.req.trade.CreateOrderRequest;
//import com.huobi.entity.OrderEntity;
//import com.huobi.exchange.TradeService;
//import com.huobi.model.trade.Order;
//import com.huobi.webservice.RecorderService;
//import com.huobi.webutils.RecorderUtil;

import org.springframework.beans.factory.annotation.Autowired;

import com.mccken201908.order.service.OrderService;

public class BuyThread2 extends Thread {

//    @Autowired
//    private RecorderService recorderService;

	@Autowired
	private OrderService orderService;

	@Override
	public void run() {

		orderService.getPrice();
		System.out.println("ssss");
	}
}

//    @Override
//    public void run() {
//        
//        orderService.getPrice();
//        System.out.println("ssss");
//        while(ThreadPool.getStatus()){
//
//            OrderEntity  entity = ThreadPool.getBuyOrder();
//
//            //重置状态
//            entity.setCoinAmount(new BigDecimal(0));
//            entity.setTimes(0);
//            entity.setUpOrderId(null);
//            entity.setDownOrderId(null);
//            entity.setUsingUsdt(new BigDecimal(entity.getFirstBalance()));
//
//
//            //第一次买入
//            CreateOrderRequest orderRequest = TradeService.tradeOne(entity, entity.getFirstBalance());
//
//            //添加新买入记录,并且记录买入的价格
//            Order order = TradeService.getOrder(entity.getAppKey(), entity.getSecreteKey(), orderRequest.getClientOrderId());
//            TradeService.getPriceOrder(entity.getAppKey(), entity.getSecreteKey(), order);
//            entity.setLastTradePrice(order.getPrice());
//
//            recorderService.addRecorder(RecorderUtil.getRecorderEntity(entity, order, "buy"));
//
//
//            //添加买入的数量
//            BigDecimal buyAmount = order.getFilledAmount().subtract(order.getFilledFees()).setScale(entity.getAmountPrecision(), BigDecimal.ROUND_DOWN);
//            entity.setCoinAmount(buyAmount.add(entity.getCoinAmount()));
//
//
//            String[]  ordersId = TradeService.accordingNowPriceMakeTrust(entity);
//            entity.setDownOrderId(ordersId[0]);
//            entity.setUpOrderId(ordersId[1]);
//
//
//            ThreadPool.submitTrust(entity);
//        }
//    }
