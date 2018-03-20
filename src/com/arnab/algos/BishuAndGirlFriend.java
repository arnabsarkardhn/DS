package com.arnab.algos;

import java.util.LinkedList;
import java.util.List;


class VillageGraph {
	private List<Integer> villageNames[];
	private List<Integer> girlsInVillage = new LinkedList<Integer>();
	//Initialize list
	public VillageGraph(int noOfVillage) {
		villageNames = new LinkedList[noOfVillage];
		for(int villageName = 0; villageName < noOfVillage; villageName++) {
			villageNames[villageName] = new LinkedList<Integer>();
			girlsInVillage.add(villageName, 0);
		}
	}
	
	public void addRoads(int from, int to) {
		villageNames[from].add(to);
	}
	
	public void girlsInVillage(int villageName) {
		girlsInVillage.set(villageName, 1);
	}
	
	public void dfs()
}

public class BishuAndGirlFriend {

	public static void main(String[] args) {
		VillageGraph vs = new VillageGraph(6);
		vs.addRoads(0, 1);
		vs.addRoads(0, 2);
		vs.addRoads(0, 3);
		vs.addRoads(1, 4);
		vs.addRoads(1, 5);

		vs.girlsInVillage(4);
		vs.girlsInVillage(5);
		vs.girlsInVillage(2);
		vs.girlsInVillage(3);
	}

}
