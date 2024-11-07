package interfaz;

import entidad.Paciente;

import java.util.Arrays;

public class appContigoAprendo {
    public static void main(String[] args) {
        Paciente paciente = new Paciente(30860820, "Sofia", 14, 'F', 1.60);

        System.out.println("Datos del Paciente");
        System.out.println("Ingrese DNI del paciente: " + paciente.getDni());
        System.out.println("Ingrese el nombre del paciente: " + paciente.getNombre());
        System.out.println("Ingrese la edad del paciente: " + paciente.getEdad());
        System.out.println("Ingrese la estatura del paciente: " + paciente.getEstatura());

        for (int i = 0; i < paciente.getPeso().length; i++) {
            System.out.println("El Peso para el mes " + (i + 1) + " es: " + paciente.getPeso()[i]);

        }

        System.out.println("" + paciente.menorPesoMensual());
        System.out.printf("El indice de masa corporal para el mes de Junio es: %.2f", +paciente.indiceMasaCorporal(6));
        System.out.println("");

        System.out.println("La condición de salud para el IMC calculado es: " +paciente.pesoMesX());

        //System.out.println("Los meses con menos de 90 kilos son: ");
        //for (int i = 0; i < paciente.menosDeXKilos(90).length; i++) {
        //System.out.println(paciente.menosDeXKilos(90)[i]);
        //}

        System.out.println("Los meses en los que se peso menos de 90 kilos son: " + Arrays.toString(paciente.menosDeXKilos(90)));

    }
}
