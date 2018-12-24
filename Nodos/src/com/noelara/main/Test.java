package com.noelara.main;

import java.util.List;

public class Test {

	public static void main(String[] args) {

		ArbolNodos aNodos = new ArbolNodos();
		aNodos.generaArbolNodos();

		System.out.println(aNodos.toString());

		System.out.println("la profundidad máxima del árbol de nodos es: " + maxDepth(aNodos.getNodoRaiz()));
	}

	/* Obtiene la profundidad máxima de un arbol donde solo se recibe el nodo raíz 
	 * y referencias a los nodos inmediatos
	 * 
	 * @param	Nodo 	el nodo Raíz
	 * @return 	int 	el valor entero de la profundidad máxima 
	 */
	public static int maxDepth(Nodo nodo) {

		int maxDepth = 1, cuentaAux = 1;
		Nodo nodoHijo = null;
		Nodo nodoPadre = nodo;
		Nodo nodoAux = null;

		List<Nodo> liNodo = nodo.getLiNodosHijos();

		if ((liNodo).size() > 0)
			cuentaAux = 2;

		maxDepth = cuentaAux;

		for (Nodo n : liNodo) {
			nodoHijo = null;
			nodoAux = null;
			if (nodoHijo == null ? n.tieneMasHijos() : n.tieneMasHijos(nodoHijo)) {

				cuentaAux = 3;
				maxDepth = cuentaAux;
				nodoPadre = n;
				nodoHijo = n.getPrimerHijo();

				while (nodoPadre.TienePadre()) {
					System.out.println("id unico: -------" + nodoHijo.getRefNodo());
					if (nodoAux == null ? nodoHijo.tieneMasHijos() : nodoHijo.tieneMasHijos(nodoAux)) {
						nodoPadre = nodoHijo;
						nodoHijo = nodoAux == null ? nodoHijo.getSiguienteHijo() : nodoHijo.getSiguienteHijo(nodoAux);
						System.out.println("el id del nodo hijo++++++++: " + nodoHijo.getRefNodo());
						cuentaAux++;
						nodoAux = null;
						if (maxDepth < cuentaAux) {
							maxDepth = cuentaAux;
						}
					} else {
						nodoAux = nodoHijo;
						nodoHijo = nodoPadre;
						nodoPadre = nodoPadre.getNodoPadre();
						cuentaAux--;
					}
				}
			}
		}

		return maxDepth;
	}
}
