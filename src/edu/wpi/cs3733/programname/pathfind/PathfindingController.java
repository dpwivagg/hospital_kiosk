package edu.wpi.cs3733.programname.pathfind;

import edu.wpi.cs3733.programname.commondata.EdgeData;
import edu.wpi.cs3733.programname.commondata.NodeData;
import edu.wpi.cs3733.programname.pathfind.PathStrategies.HandicappedPath;
import edu.wpi.cs3733.programname.pathfind.entity.AStar;
import edu.wpi.cs3733.programname.pathfind.PathStrategies.StandardPath;
import edu.wpi.cs3733.programname.pathfind.entity.InvalidNodeException;
import edu.wpi.cs3733.programname.pathfind.entity.NoPathException;
import edu.wpi.cs3733.programname.pathfind.entity.PathFinderFacade;

import java.util.LinkedList;
import java.util.List;

public class PathfindingController {

    public enum searchType {
        ASTAR, DFS, BFS, DIJKSTRA
    }
    /**
     * Takes in the starting and ending locations, and calls PathFinderFacade to find the path between them
     * currently also takes linkedlists for nodedata and edges
     *
     * @param allNodes  - the list of all nodes
     * @param allEdges  - the list of all edges
     * @param startNode - the ID of the starting location for the path
     * @param endNode   - the ID of the end node, aka the destination, for the path
     * @return - result is the list of nodes efficiently connecting startNode to endNode
     */
    public List<NodeData> initializePathfind(List<NodeData> allNodes, List<EdgeData> allEdges, String startNode,
                                             String endNode, Boolean handicapped, searchType type) throws InvalidNodeException {
        // ManageController manager = new ManageController();
        // List<EdgeData> allEdges = manager.getAllEdgeData();
        //something about getEdges()
        try {

            List<EdgeData> currentList = allEdges;

            if(handicapped) allEdges = filterPath(allEdges);

            PathFinderFacade newPath = new PathFinderFacade(allNodes, currentList, startNode, endNode);

            if (type == searchType.ASTAR) {
                return newPath.findAstarPath();
            }
            else if (type == searchType.DFS) {
                return newPath.findDfsPath();
            }
            else if (type == searchType.BFS) {
                return newPath.findBfsPath();
            }
            else if (type == searchType.DIJKSTRA) {
                return newPath.findDijkstraPath();
            }

        } catch (NoPathException npe) {
            // Add exception later
        }
        return null;
    }

    private List<EdgeData> filterPath(List<EdgeData> edges) {
        List<EdgeData> handicappedPath = new LinkedList<EdgeData>();
        for(EdgeData e: edges) {
            if(!e.getStartNode().contains("STAI") && !e.getEndNode().contains("STAI")) {
                handicappedPath.add(e);
            }
        }
        return handicappedPath;
    }
}