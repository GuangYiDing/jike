package me.cocode.jike.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 2021/5/11 下午3:18
 *
 * @author xiaodingsiren
 */
@Getter
@Setter
@Table(name = "wx_account")
public class WxAccount {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "open_id")
    private String openId;
    @Column(name = "session_key")
    private String sessionKey;
    @Column(name = "user_id")
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;
}
