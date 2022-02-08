import java.util.ArrayList;

public class Central {
    private ArrayList<Persona> personasEmpadronadas;
    private ArrayList<Persona> personasVacunacionCompleta;
    private ArrayList<Vacunatorio> vacunatorios;

    public Central() {
        personasEmpadronadas = new ArrayList<Persona>();
        personasVacunacionCompleta = new ArrayList<Persona>();
        vacunatorios = new ArrayList<Vacunatorio>();
    }

    public boolean empadronarPersona(int dni) {
        Persona persona = buscarPersona(dni, personasEmpadronadas);
        boolean pudoEmpadronar = false;

        if (persona == null && persona != buscarPersona(dni, personasVacunacionCompleta)) {
            pudoEmpadronar = personasEmpadronadas.add(new Persona(dni));
        }

        return pudoEmpadronar;

    }

    private Persona buscarPersona(int dni, ArrayList<Persona> listaBusqueda) {
        Persona elementoBuscado = null;
        int i = 0;
        int cantElementos = listaBusqueda.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (listaBusqueda.get(i).mismaPersona(dni)) {
                elementoBuscado = listaBusqueda.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public boolean agregarVacunatorio(String nombre, Marca marca, int cantidad) {
        boolean seAgrego = false;
        Vacunatorio vacunatorio = buscarVacunatorio(nombre);

        if (vacunatorio != null) {
            seAgrego = vacunatorios.add(new Vacunatorio(nombre, marca, cantidad));
        }

        return seAgrego;
    }

    private Vacunatorio buscarVacunatorio(String nombre) {
        Vacunatorio elementoBuscado = null;
        int i = 0, cantElementos = vacunatorios.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (vacunatorios.get(i).mismoVacunatorio(nombre)) {
                elementoBuscado = vacunatorios.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public Resultado vacunar(int dni, String nombre) {
        Resultado resultado = Resultado.DNI_INVALIDO;
        Persona persona = buscarPersona(dni, personasEmpadronadas);

        if (persona != null) {
            Vacunatorio vacunatorio = buscarVacunatorio(nombre);
            if (vacunatorio != null) {
                if (!persona.getEsquemaCompleto()) {

                    if (persona.obtenerPrimeraDosis() == null) {
                        resultado = Resultado.VACUNACION_OK;

                        Marca primeraDosis = persona.vacunarPrimeraDosis().getMarca();

                        Marca busquedaSegundaDosis = vacunatorio.buscarVacuna(primeraDosis).getMarca();

                        if (primeraDosis == busquedaSegundaDosis) {

                            Marca segundaDosis = persona.vacunarSegundaDosis().getMarca();
                            resultado = Resultado.VACUNACION_OK;

                            Marca busquedaTerceraDosis = vacunatorio.buscarVacuna(segundaDosis).getMarca();

                            if (segundaDosis != busquedaTerceraDosis) {
                                persona.vacunarTerceraDosis();
                                resultado = Resultado.VACUNACION_OK;

                            } else {
                                resultado = Resultado.VACUNA_NO_DISPONIBLE;
                            }
                        } else {
                            resultado = Resultado.VACUNA_NO_DISPONIBLE;
                        }
                    } else {
                        resultado = Resultado.VACUNA_NO_DISPONIBLE;
                    }
                } else {
                    resultado = Resultado.VACUNACION_COMPLETA;
                }
            } else {
                resultado = Resultado.VACUNATORIO_INEXISTENTE;
            }

        }

        return resultado;
    }

    public void mostrarVacunatorio(int dni) {
        Persona persona = buscarPersona(dni, personasEmpadronadas);

        if (persona != null) {

            if (persona.noTieneDosis()) {

                for (Vacunatorio vacunatorio : vacunatorios) {
                    System.out.println(vacunatorio);
                }

            } else if (persona.obtenerPrimeraDosis() != null) {
                Marca primeraDosis = persona.obtenerPrimeraDosis();

                for (Vacunatorio vacunatorio : vacunatorios) {
                    Marca dosisDisponible = vacunatorio.buscarVacuna(primeraDosis).getMarca();

                    if (dosisDisponible == primeraDosis) {
                        System.out.println(vacunatorio);
                    }
                }
            } else {
                Marca segundaDosis = persona.obtenerSegundaDosis();

                for (Vacunatorio vacunatorio : vacunatorios) {
                    Marca dosisDisponible = vacunatorio.buscarVacuna(segundaDosis).getMarca();
                    if (dosisDisponible != segundaDosis) {
                        System.out.println(vacunatorio);
                    }

                }
            }

        }
    }
}
