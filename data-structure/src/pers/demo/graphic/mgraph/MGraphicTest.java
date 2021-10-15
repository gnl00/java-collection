package pers.demo.graphic.mgraph;

/**
 * MGraphic 邻接矩阵
 *
 * @author gnl
 */

public class MGraphicTest {
    public static void main(String[] args) {

    }
}

// 顶点类型
class VertexType {

    // 顶点编号
    private int no;

    // 顶点信息
    private String info;

}

class MGraph {

    // 邻接矩阵
    private int[][] edges;

    // 边数
    private int n;

    // 顶点数
    private int edge;

    // 存放结点信息
    private VertexType[] vertex;

}
