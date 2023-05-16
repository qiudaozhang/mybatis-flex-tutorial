package top.daozhang.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(value = "t_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

    @Id(keyType = KeyType.Auto)
    private Long id;
    private String nickname;
    private LocalDate birthday;
    private LocalDateTime created;
    private Integer sex=0;
}
