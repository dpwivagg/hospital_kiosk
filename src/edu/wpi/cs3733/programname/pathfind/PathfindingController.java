package edu.wpi.cs3733.programname.pathfind;

import edu.wpi.cs3733.programname.ManageController;
import edu.wpi.cs3733.programname.commondata.Edge;
import edu.wpi.cs3733.programname.pathfind.entity.AStar;
import edu.wpi.cs3733.programname.pathfind.PathStrategies.StandardPath;

import java.util.List;

public class PathfindingController {

    public List<Edge> initializePathfind(String startNode, String endNode){
        ManageController manager = new ManageController();
        // List<Edge> allEdges = manager.getAllEdgeData();
                //something about getEdges()
        AStar newAstar = new AStar(manager, startNode, endNode);
        return AStar.getFinalPath();
    }

    // getPath needs to take in the starting node and ending node!!! its currently broken.
    // How do we take in the starting and ending node


}