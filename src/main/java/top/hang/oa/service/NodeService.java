package top.hang.oa.service;

import top.hang.oa.entity.Node;

import java.util.List;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/28 15:00
 */
public interface NodeService {
    List<Node> selectNodeByUserId(Long id);
}
