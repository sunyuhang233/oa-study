package top.hang.oa.service;

import top.hang.oa.entity.Leave;
import top.hang.oa.entity.ProcessFlow;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/3/3 10:17
 */
public interface ProcessService {
//    ProcessFlow insetIntoProcess(ProcessFlow processFlow);

    Leave createLeave(Leave leave);
}
