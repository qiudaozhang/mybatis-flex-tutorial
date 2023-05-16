package top.daozhang.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class UserDto {

    private Long uid;

    private Long id;

    private String nickname;

    private String goodsName;

    private BigDecimal amount;
}
