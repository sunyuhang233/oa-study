package top.hang.oa.mapper;

import org.junit.jupiter.api.Test;
import top.hang.oa.entity.Node;
import top.hang.oa.service.impl.NodeServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeMapperTest {
@Test
void selectNodeByUserId() {
//    Node node = new NodeMapper().selectNodeByUserId(1L);
//    System.out.println(node);
    List<Node> nodes = new NodeServiceImpl().selectNodeByUserId(1L);
    System.out.println(nodes);
}
}