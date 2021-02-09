package com.maths.huim.models;

import java.util.Map;

public class AntRoutingGraph {

    private AntRoutingGraphNode root;

    public AntRoutingGraph() {
        this.root = new AntRoutingGraphNode();
    }

    public AntRoutingGraph(AntRoutingGraphNode root) {
        this.root = root;
    }

    public AntRoutingGraphNode getRoot() {
        return root;
    }

    public void setRoot(AntRoutingGraphNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "{ " + this.root.getKeyItem() + " -> {" + this.root + " } }";
    }
}