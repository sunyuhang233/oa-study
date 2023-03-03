package top.hang.oa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/3/3 9:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessFlow {
private Long processId ;
private  Long formId;
private String action;
private String result;
private String reason;
private Date createTime;
private Date auditTime;
private Integer orderNo;
private  String state;
private Integer isLast;
private Long operatorId;

}
