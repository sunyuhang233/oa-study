package top.hang.oa.service.impl;


import top.hang.oa.entity.Node;
import top.hang.oa.mapper.NodeMapper;
import top.hang.oa.service.NodeService;
import top.hang.oa.utils.MybatisUtils;

import java.util.List;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/28 13:30
 */
public class NodeServiceImpl implements NodeService {

    @Override
    public List<Node> selectNodeByUserId(Long id) {
        return (List<Node>) MybatisUtils.executeQuery(sqlSession -> {
            NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
            return nodeMapper.selectNodeByUserId(id);
        });
    }
}
