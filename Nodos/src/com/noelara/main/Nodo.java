package com.noelara.main;

import java.util.List;

public class Nodo {
	
	Integer refNodo;
	Integer refNodoPadre;
	Nodo nodoHijo;
	Nodo nodoPadre;
	List<Integer> liRefsnodosHijos;
	List<Nodo> liNodosHijos;
	boolean tieneHijos;
	boolean tienePadre;
	
	public Nodo() {
		tieneHijos = false;
		tienePadre = false;
	}
	
	public Nodo getNodoPadre() {
		return nodoPadre;
	}

	public void setNodoPadre(Nodo nodoPadre) {
		this.nodoPadre = nodoPadre;
	}
	
	public boolean TienePadre() {
		return tienePadre;
	}

	public void setTienePadre(boolean tienePadre) {
		this.tienePadre = tienePadre;
	}

	public Nodo getPrimerHijo() {
		if(this.tieneHijos()) {
			return this.getLiNodosHijos().get(0);
		}else {
			return null;
		}
	}
	
	public boolean tieneMasHijos() {
		
		Nodo n = new Nodo();
		System.out.println(this.getRefNodo());
		if(tieneHijos) {
			n = this.getNodoHijo(0);
			//System.out.println("id de n: " + n.getRefNodo());
			return true;
		}
		
		return false;
	}
	
	public boolean tieneMasHijos(Nodo nodo) {
		
		Nodo n = new Nodo();
		System.out.println("el id unico del nodo es: " + this.getRefNodo() + 
				" y el del hijo es: " + nodo.getRefNodo());
		if(tieneHijos) {
			if( nodo==null || nodo.equals(null)) {
				n = this.getNodoHijo(0);
				return true;
			}else {
				try {
					System.out.println(nodo);
					int val = nodo.getRefNodo();
					int indexOfVal = -2;
					List<Nodo> liNodo = this.getLiNodosHijos();
					int index = 0;
					int refNod = 0;
					while(index<liNodo.size()) {
						refNod = liNodo.get(index).getRefNodo();
						Nodo n1 = new Nodo();
						if(val==refNod) {
							n1 = liNodo.get(index);
							indexOfVal = liNodo.indexOf(n1);
							break;
						}
						index++;
					}
					if(liNodo.size()>indexOfVal+1) {
						n = liNodo.get(indexOfVal+1);
						return true;
					}else {
						return false;
					}
				}catch(IndexOutOfBoundsException exception){
					System.out.println("fuera del intervalo del arreglo: " + n);
					return false;
				}catch(NullPointerException e) {
					System.out.println("se ha capturado la excepcion de apuntador nulo");
					return false;
				}
			}
		}
		
		return false;
	}
	
	public Nodo getSiguienteHijo() {
		
		Nodo n = new Nodo();
		
		if(tieneHijos) {
			n = this.getNodoHijo(0);
			//System.out.println("id de n: " + n.getRefNodo());
			return n;
		}
		
		return n;
	}
	
	public Nodo getSiguienteHijo(Nodo nodo) {
		
		Nodo n = new Nodo();
		
		if(this.tieneHijos()) {
			if( nodo==null) {
				n = this.getNodoHijo(0);
				return n;
			}else {
				try {
					System.out.println(nodo);
					int val = nodo.getRefNodo();
					int indexOfVal = -2;
					List<Nodo> liNodo = this.getLiNodosHijos();
					int index = 0;
					int refNod = 0;
					while(index<liNodo.size()) {
						refNod = liNodo.get(index).getRefNodo();
						Nodo n1 = new Nodo();
						if(val==refNod) {
							n1 = liNodo.get(index);
							indexOfVal = liNodo.indexOf(n1);
							break;
						}
						index++;
					}
					if(liNodo.size()>indexOfVal+1) {
						n = liNodo.get(indexOfVal+1);
					}
				}catch(ArrayIndexOutOfBoundsException exception){
					System.out.println("fuera de los limites del arreglo");
					return null;
				}
			}
		}
		return n;
	}
	
	public boolean tieneHijos() {
		return tieneHijos;
	}
	public void setTieneHijos(boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}
	public List<Nodo> getLiNodosHijos() {
		return liNodosHijos;
	}
	public void setLiNodosHijos(List<Nodo> liNodosHijos) {
		this.liNodosHijos = liNodosHijos;
	}
	public List<Integer> getLiRefsnodosHijos() {
		return liRefsnodosHijos;
	}
	public void setLiRefsnodosHijos(List<Integer> liRefsnodosHijos) {
		this.liRefsnodosHijos = liRefsnodosHijos;
	}
	public Nodo getNodoHijo(int i) {
		return liNodosHijos.get(i);
	}
	public void setNodoHijo(Nodo nodoHijo) {
		this.liNodosHijos.add(nodoHijo);
	}
	public int getRefNodo() {
		return refNodo;
	}
	public void setRefNodo(Integer refNodo) {
		this.refNodo = refNodo;
	}
	public int getRefNodoPadre() {
		return refNodoPadre;
	}
	public void setRefNodoPadre(Integer refNodoPadre) {
		this.refNodoPadre = refNodoPadre;
	}
}
