package pers.demo.graphic.agraph;

/**
 * AGraph 邻接表
 *
 * @author gnl
 */

public class AGraphTest {
}

class ArcNode {

    // 边所指向的结点的位置
    private int adjvex;

    // 下一个结点的信息
    private ArcNode nextNode;

    // 边的相关信息，如权值
    int info;

}

class VNode {

    // 顶点信息
    private int data;

    // 第一条边的信息
    private ArcNode firstNode;

}

class AGraph {

    private VNode[] adjList;

    // 边数
    int n;

    // 顶点数
    int e;

}
