package top.hang.oa.service.impl;

import org.junit.jupiter.api.Test;
import top.hang.oa.entity.Node;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeServiceImplTest {
    @Test
    void selectNodeByUserId() {
        List<Node> nodes = new NodeServiceImpl().selectNodeByUserId(1L);
        System.out.println(nodes);
    }
}