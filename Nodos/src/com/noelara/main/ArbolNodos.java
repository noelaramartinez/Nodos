package com.noelara.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArbolNodos {

	private Nodo nodoRaiz = new Nodo();
	private HashMap<Integer, Nodo> mapaDeNodos = new HashMap<>();
	private static ArrayList<Nodo> liNodos = new ArrayList<>();
	private static ArrayList<Nodo> liNodosAux = new ArrayList<>();
	private static ArrayList<Nodo> liNodosAux2 = new ArrayList<>();
	private Integer idUnico;
	private int profundidad = 1;
	
	public HashMap<Integer, Nodo> getMapaDeNodos() {
		return mapaDeNodos;
	}

	public void setMapaDeNodos(HashMap<Integer, Nodo> mapaDeNodos) {
		this.mapaDeNodos = mapaDeNodos;
	}
	
	public Nodo getNodoRaiz() {
		return nodoRaiz;
	}
	
	public ArbolNodos(){
		nodoRaiz.setRefNodo(0);
		nodoRaiz.setRefNodoPadre(null);
	}
	
	public void generaArbolNodos() {
		
		idUnico = 0;
		int numeroAleatorio = (int) (Math.random() * 6) + 1;
		ArrayList<Integer> liRefNodosHijos = new ArrayList<>();
		
		System.out.println("Profundidad=1\t" + nodoRaiz.getRefNodo() + "\n");
		for(int i=0;i<numeroAleatorio;i++) {
			
			if(i==0) {
				int numAleatorio = (int) (Math.random() * 3) +1;
				System.out.print("profundidad="+(++profundidad) + "\t");
				for(int j=0;j<numAleatorio;j++) {
					nodoRaiz.setTieneHijos(true);
					Nodo nodo = new Nodo();
					nodo.setRefNodo(++idUnico);
					nodo.setRefNodoPadre(nodoRaiz.refNodo);
					nodo.setTienePadre(true);
					nodo.setNodoPadre(nodoRaiz);
					liRefNodosHijos.add(idUnico);
					mapaDeNodos.put(idUnico, nodo);
					liNodosAux.add(nodo);
					liNodos.add(nodo);
					System.out.print(nodo.getRefNodoPadre() + "-" + nodo.getRefNodo() + "  " +  "\t");
				}
				nodoRaiz.setLiNodosHijos((List<Nodo>) liNodosAux.clone());
				liNodosAux.clear();
				System.out.println("\n");
			}else {
				if(liNodos!=null && !liNodos.isEmpty() && liNodos.size()>0)
					System.out.print("profundidad="+(++profundidad) + "\t");
				
				for(Nodo n:liNodos) {
					int numAleatorio2 = (int) (Math.random() * 5);
					for(int j=0;j<numAleatorio2;j++) {
						n.setTieneHijos(true);
						Nodo nodo = new Nodo();
						nodo.setRefNodo(++idUnico);
						nodo.setRefNodoPadre(n.getRefNodo());
						nodo.setTienePadre(true);
						nodo.setNodoPadre(n);
						liRefNodosHijos.add(idUnico);
						mapaDeNodos.put(idUnico, nodo);
						liNodosAux.add(nodo);
						liNodosAux2.add(nodo);
						System.out.print(nodo.getRefNodoPadre() + "-" + nodo.getRefNodo() + "  " +  "\t");
					}
					n.setLiRefsnodosHijos((List<Integer>) liRefNodosHijos.clone());
					liRefNodosHijos.clear();
					n.setLiNodosHijos((List<Nodo>) liNodosAux2.clone());
					liNodosAux2.clear();
				}
				System.out.println("\n");
				liNodos = (ArrayList<Nodo>) liNodosAux.clone();
				liNodosAux.clear();
			}
		}
		liNodos.clear();
		
	}

	@Override
	public String toString() {
		return "ArbolNodos [nodoRaiz=" + nodoRaiz + ", mapaDeNodos=" + mapaDeNodos + ", idUnico=" + idUnico + "]";
	}
	
	
}
