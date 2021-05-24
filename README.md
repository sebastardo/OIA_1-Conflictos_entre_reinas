## Descripción del problema
El problema de las reinas de ajedrez consiste encontrar una distribución de **N** reinas sobre un tablero de ajedrez de **NxN** escaques o casillas, de manera tal que éstas no se ataquen entre sí. De esta forma, como las reinas no deben atacarse, no puede encontrarse más de una en la misma fila, columna o diagonal. Este es un problema muy antiguo, ya que fue propuesto para N=8 (tamaño de un tablero de ajedrez) en el año 1848, y aún hoy sigue siendo un problema muy interesante de estudio e investigación.
Para indicar la posición de una reina sobre el tablero simplemente se da un par de números, indicando la fila y la columna donde se encuentra.
En nuestro caso, a partir de un conjunto de reinas ya ubicadas sobre el tablero de tamaño determinado, nos interesa saber en cuantos conflictos interviene cada reina y cuáles son esos conflictos.
Tenga en cuenta que si tres reinas A, B y C están alineadas y en ese orden, entonces sólo hay dos conflictos: (A,B) y (B,C). A y C no constituyen un conflicto porque las reinas no saltan por arriba de otra pieza.
Por lo tanto, se te pide que escribas un programa que de solución al problema para nuestro caso.

## Datos de entrada
Se recibe un archivo **conflictos.in** con el siguiente formato:

- Una línea con dos números **N** y **M** **( 1 ≤ N ≤ 10.000, 1 ≤ M ≤ 50.000)**, que indican las dimensiones del tablero y la cantidad de reinas ubicadas sobre el exittablero. No pueden existir dos reinas sobre una misma casilla.
- **M** líneas con dos números **F** y **C** , cada uno indicando la fila y la columna en que se encuentra la reina **( 1 ≤ F, C ≤ N )**.


## Datos de salida
Se debe generar un archivo **conflictos.out** conteniendo **M** líneas, una por cada reina respetando el orden de entrada, las cuales a su vez contienen: un numero **K ( 0 ≤ K ≤ M )**, que indica en cuantos conflictos participa esa reina, seguido de **K** números, ordenados de menor a mayor, que indicaran los números de reinas con los que existe conflicto. El número de cada reina se determina de acuerdo al orden de aparición correspondiente en el archivo de entrada, empezando la numeración en 1.

# Ejemplo 1
Si tenemos el siguiente tablero:

```
  1 2 3 4 5 6 7 8
1     X          
2           X    
3       X        
4 X              
5               X
6         X      
7             X  
8   X            
```

La entrada **reinas.in** seria:

```
8 8
4 1
8 2
1 3
3 4
6 5
2 6
7 7
5 8 
```

La salida **reinas.out** debería ser: 

```
0
0
0
0
0
0
0
0
```