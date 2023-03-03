package top.hang.oa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/3/3 9:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leave {
    private Long formId;
    private String reason;
    private Long employeeId;
    private String state;
    private Integer formType;
    private Date startTime;
    private Date endTime;
    private Date createTime;

}
