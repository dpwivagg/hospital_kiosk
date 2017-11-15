/**
 * Star node class is a wrapper for NodeData with the extra fields
 * neighbors: list of connected nodes to this node
 * previous node: the node that this node was accessed through in pathfinding
 * f, g: cost to travel to this node and action cost, respectively
 */

package edu.wpi.cs3733.programname.pathfind.entity;

import edu.wpi.cs3733.programname.commondata.NodeData;

import java.util.LinkedList;

public class StarNode extends edu.wpi.cs3733.programname.commondata.NodeData implements Comparable<StarNode> {
    protected double f, g; // f is total cost, g is action cost to this node
    protected StarNode previousNode;
    protected LinkedList<StarNode> neighbors = new LinkedList<StarNode>();

    public StarNode(NodeData node) {
        super(node.getId(), node.getLocation(), node.getFloor(),
                node.getType(), node.getLongName(), node.getShortName());
    }

    @Override
    public int compareTo(StarNode newNode) {
        double newNodeF = newNode.getF();
        if(this.f > newNodeF) return 1;
        else if(this.f == newNodeF) return 0;
        else return -1;
    }

    public LinkedList<StarNode> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(StarNode neighbor) {
        neighbors.add(neighbor);
    }

    public StarNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(StarNode previousNode) {
        this.previousNode = previousNode;
    }

    public double getF() {
        return this.f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public double getG() {
        return this.g;
    }

    public void setG(double g) {
        this.g = g;
    }
}
