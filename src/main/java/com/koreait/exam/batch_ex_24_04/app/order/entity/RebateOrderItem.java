package com.koreait.exam.batch_ex_24_04.app.order.entity;

import com.koreait.exam.batch_ex_24_04.app.base.entity.BaseEntity;
import com.koreait.exam.batch_ex_24_04.app.product.entity.ProductOption;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class RebateOrderItem extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private OrderItem orderItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ProductOption productOption;

    private int quantity;

    //가격
    private int price; // 권장 판매가
    private int salePrice; // 실제 판매가
    private int wholesalePrice; // 도매가
    private int pgFee; // 결제대행사 수수료
    private int payPrice; // 결제금액
    private int refundPrice; // 환불금액
    private int refundQuantity; // 환불 한 갯수
    private boolean isPaid;  // 결제 여부

    // 상품
    private String productName;

    // 상품 옵션
    private String productOptionColor;
    private String productOptionSize;
    private String productOptionDisplayColor;
    private String productOptionDisplaySize;

    // 주문 품목
    private LocalDateTime orderItemCreateDate;

    public RebateOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
        order = orderItem.getOrder();
        productOption = orderItem.getProductOption();
        quantity = orderItem.getQuantity();
        price = orderItem.getPrice();
        salePrice = orderItem.getSalePrice();
        wholesalePrice = orderItem.getWholesalePrice();
        pgFee = orderItem.getPgFee();
        payPrice = orderItem.getPayPrice();
        refundPrice = orderItem.getRefundPrice();
        refundQuantity = orderItem.getRefundQuantity();
        isPaid = orderItem.isPaid();

        // 상품 추가데이터
        productName= orderItem.getProductOption().getProduct().getName();

        // 상품옵션 추가데이터
        productOptionColor = orderItem.getProductOption().getColor();
        productOptionSize = orderItem.getProductOption().getSize();
        productOptionDisplayColor = orderItem.getProductOption().getDisplayColor();
        productOptionDisplaySize = orderItem.getProductOption().getDisplaySize();

        // 주문 품목 추가데이터
        orderItemCreateDate = orderItem.getCreateDate();

    }
//    # 기존
//    SELECT ROI.order_item_id AS `주문품목 번호`,
//    DATE(OI.create_date) AS `주문날짜`,
//    CONCAT(FORMAT(ROI.pay_price - ROI.refund_price, 0), '원') AS `결제금액`,
//    P.name AS `상품명`,
//    PO.color AS `색상`,
//    PO.size AS `사이즈`,
//    ROI.quantity - ROI.refund_quantity AS `개수`
//    FROM rebate_order_item AS ROI
//    INNER JOIN order_item AS OI
//    ON ROI.order_item_id = OI.id
//    INNER JOIN product_option AS PO
//    ON ROI.product_option_id = PO.id
//    INNER JOIN product AS P
//    ON PO.product_id = P.id
//    ORDER BY ROI.order_item_id ASC;
//
//    # 개선 - 1
//    SELECT ROI.order_item_id AS `주문품목 번호`,
//    DATE(OI.create_date) AS `주문날짜`,
//    CONCAT(FORMAT(ROI.pay_price - ROI.refund_price, 0), '원') AS `결제금액`,
//    ROI.product_name AS `상품명`,
//    ROI.product_option_color AS `색상`,
//    ROI.product_option_size AS `사이즈`,
//    ROI.quantity - ROI.refund_quantity AS `개수`
//    FROM rebate_order_item AS ROI
//    INNER JOIN order_item AS OI
//    ON ROI.order_item_id = OI.id
//    ORDER BY ROI.order_item_id ASC;

//    # 개선 - 2
//    SELECT ROI.order_item_id AS `주문 품목 번호`,
//    DATE(ROI.order_item_create_date) AS `주문 날짜`,
//    CONCAT(FORMAT(ROI.pay_price - ROI.refund_price,0),'원') AS `결제금액`,
//    ROI.product_name AS `상품명`,
//    ROI.product_option_color AS `색상`,
//    ROI.product_option_size AS `사이즈`,
//    ROI.quantity - ROI.refund_quantity AS `수량`
//    FROM rebate_order_item AS ROI
//    ORDER BY ROI.order_item_id ASC;

}