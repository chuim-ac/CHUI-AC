package com.maths.huim.models;

import java.util.*;

public class AntRoutingGraphNode {

    private int keyItem;
    private List<AntRoutingGraphNode> children;
    private double pheromone;
    private double desirability;
    private boolean visited;

    public AntRoutingGraphNode() {

        this.keyItem = '0';
        this.children = new ArrayList<AntRoutingGraphNode>(1);
        this.visited = false;
        this.pheromone = Constants.tauBefore;
        this.desirability = 0.0;
    }

    public AntRoutingGraphNode(int keyItem){
        this.keyItem = keyItem;
    }

    public void addChild(AntRoutingGraphNode antRoutingGraphNode) {
        this.children.add(antRoutingGraphNode);
    }


    public int getKeyItem() {
        return this.keyItem;
    }

    public void setKeyItem(int keyItem) {
        this.keyItem = keyItem;
    }

    public List<AntRoutingGraphNode> getChildren() {
        return this.children;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getPheromone() {
        return pheromone;
    }

    public void setPheromone(double pheromone) {
        this.pheromone = pheromone;
    }

    public double getDesirability() {
        return desirability;
    }

    public void setDesirability(double desirability) {
        this.desirability = desirability;
    }

    @Override
    public String toString() {

        String trieString = "";
        for(AntRoutingGraphNode node : this.children) {
            trieString += node.getKeyItem() + " -> {" + node.getChildren() + " } ";
        }
        return trieString;
    }
}
