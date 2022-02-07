package Eclipse_Resuelto;

import java.util.ArrayList;

public class Proyecto {

	private String nombre;
	private ArrayList<Metodo> metodos;
	private boolean compilado;
	private boolean ejecucion;
	private int versionActual;
	
	public Proyecto(String nombre){
		metodos = new ArrayList<>();
		setNombre(nombre);
		versionActual = 0;
	}
	
	private void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public boolean mismoProyecto(String nombre){
		return this.nombre.equals(nombre);
	}
	
	private Metodo buscarMetodo(String nombre){
		Metodo metodo = null;
		int i = 0;
		
		while(i < metodos.size() && metodo == null){
			if(metodos.get(i).mismoMetodo(nombre)){
				metodo = metodos.get(i);
			}else{
				i++;
			}
		}
		
		return metodo;
	}
	
	public boolean agregarMetodo(String nombre, int cantidadInstrucciones){
		boolean pudeAgregar = false;
		
		Metodo metodo = buscarMetodo(nombre);
		if(metodo == null){
			metodos.add(new Metodo(nombre, cantidadInstrucciones));
			compilado = false;
			pudeAgregar = true;
		}
		
		return pudeAgregar;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getCantidadMetodos(){
		return metodos.size();
	}
	
	public int getVersionActual(){
		return versionActual;
	}
	
	public boolean compilar(){
		if(metodos.size() > 0){
			versionActual++;
			compilado = true;
		}
		
		return compilado;
	}
	
	public boolean isCompilado(){
		return compilado;
	}
	
	public boolean isEjecucion(){
		return ejecucion;
	}

	public boolean tieneMain() {
		return buscarMetodo("main") != null;
	}
	
	public int getCantidadBytes(){
		int suma = 0;
		for (Metodo metodo : metodos) {
			suma += metodo.getCantidadBytes();
		}
		return suma;
	}
	
	public void ejecutar(){
		ejecucion = true;
	}

	public void detener() {
		ejecucion = false;
		
	}
}
