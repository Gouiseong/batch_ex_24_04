package com.koreait.exam.batch_ex_24_04.app.order.entity;

import com.koreait.exam.batch_ex_24_04.app.base.entity.BaseEntity;
import com.koreait.exam.batch_ex_24_04.app.product.entity.ProductOption;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class OrderItem extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
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


    public OrderItem(ProductOption productOption, int quantity) {
        this.productOption = productOption;
        this.quantity = quantity;
        this.price = productOption.getPrice();
        this.salePrice = productOption.getSalePrice();
        this.wholesalePrice = productOption.getWholesalePrice();
    }

    public int calculatePayPrice() {
        return salePrice * quantity;
    }

    public void setPaymentDone() {
        this.pgFee = 0;
        this.payPrice = calculatePayPrice();
        this.isPaid = true;
    }
}