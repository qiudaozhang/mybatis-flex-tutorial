package top.daozhang.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "t_order")
public class Order implements Serializable {

    /**
     * 订单主键
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 购买时间
     */
    private LocalDateTime buyTime;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 金额
     */
    private BigDecimal amount;

}
