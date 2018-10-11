package com.ipartek.formacion.ejemplos.listas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayListPrueba {
	 public static String[] bands = {"1", "2","3", "4"};
     public static List<String> bandList = new ArrayList<String>();

	public static void main(String[] args){
		 
       
        //add elements from String array to List
        for (String band : bands){
            bandList.add(band);
        }
 
        String[] undesirableBands = {"1", "4"};
        List<String> undesirableList = new ArrayList<String>();
 
        //add elements from String array to List
        for (String undesirableBand : undesirableBands){
            undesirableList.add(undesirableBand);
        }
 
        System.out.println("List of bands has: ");
        for (int count = 0; count < bandList.size(); count++){
            System.out.printf("%s ", bandList.get(count));
        }
 
        removeBands(bandList, undesirableList);
        System.out.println("\n\nI just wish these bands: ");
 
        for (int count = 0; count < bandList.size(); count++){
            System.out.printf("%s ", bandList.get(count));
        }
        addBands();
    }
 
    public static void removeBands(Collection<String> bands,
                                         Collection<String> undesirableBands){
        Iterator<String> iteratorBand = bands.iterator();
 
        while(iteratorBand.hasNext()){
            if(undesirableBands.contains(iteratorBand.next())){
                iteratorBand.remove();
            }
        }
    }
    public static void addBands() {
    	 bandList.add(2,"nueva");
    	 bandList.add(3,"nueva2");
    	 
    	 for (int count = 0; count < bandList.size(); count++){
             System.out.printf("%s ", bandList.get(count));
         }
    }
}
