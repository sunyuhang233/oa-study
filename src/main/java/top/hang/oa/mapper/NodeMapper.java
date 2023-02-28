package top.hang.oa.mapper;

import top.hang.oa.entity.Node;

import java.util.List;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/28 15:05
 */
public interface NodeMapper {
    List<Node> selectNodeByUserId(Long id);
}
