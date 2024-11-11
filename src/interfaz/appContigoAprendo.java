package interfaz;

import entidad.Paciente;

import java.util.Arrays;

public class appContigoAprendo {
    public static void main(String[] args) {
        int dni, edad;
        String nombre, sexo;
        String[] Mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        Paciente paciente = null;

        int opción;

        do {
            System.out.println("                                                                  ");
            System.out.println("                                                                  ");
            System.out.println("-------------------- Clínica: Contigo Aprendo --------------------");
            System.out.println("--------------------- 1) Registrar Paciente ----------------------");
            System.out.println("---------------- 2) Visualizar datos del Paciente ----------------");
            System.out.println("--------- 3) Visualizar Mes con menor peso del paciente ----------");
            System.out.println("----- 4) Informe de meses con menos peso a uno determinado -------");
            System.out.println("------------------- 5) Condición del Paciente --------------------");
            System.out.println("--------------------------- 6) Salir -----------------------------");
            System.out.println("                                                                  ");
            System.out.println("                                                                  ");
            System.out.println("Por favor, ingrese una opción para Continuar. Ej: 1");
            opción = Leer.datoInt();

            switch (opción) {
                case 1:
                    System.out.println("Por favor, ingrese el DNI del Paciente");
                    dni = Leer.datoInt();
                    System.out.println("Por favor, ingrese el nombre del Paciente");
                    nombre = Leer.dato();
                    System.out.println("Por favor, ingrese la Edad del Paciente");
                    edad = Leer.datoInt();

                    String F;
                    String M;
                    do {
                        System.out.println("Por favor, ingrese el Sexo del Paciente (F: femenino y M: masculino)");
                        sexo = Leer.dato();
                        sexo = sexo.toUpperCase();
                    } while (!sexo.equals("F") && !sexo.equals("M"));

                    paciente = new Paciente(dni,nombre,edad,sexo);

                    System.out.println("***** El paciente fue registrado correctamente *****");

                    break;
                case 2:
                    if (paciente == null) {
                        System.out.println("El paciente no esta registrado. Por favor proceda con la opción 1");
                    } else {
                        System.out.println("Paciente registrado: " +'\n' + "DNI: " +paciente.getDni() + '\n' + "Nombre: "
                                + paciente.getNombre() + '\n' + "Edad: " + paciente.getEdad() + '\n' + "Sexo: "
                                + paciente.getSexo());
                       for (int i = 0; i < paciente.getPeso().length; i++) {
                            System.out.println("El Peso para el mes de " + Mes[i] + " es: " + paciente.getPeso()[i]);

                            }

                    }
                    break;

                case 3:
                    if (paciente == null) {
                        System.out.println("El paciente no esta registrado. Por favor proceda con la opción 1");
                    } else {
                        System.out.println("El mes con menor peso de " + paciente.getNombre() + " es: " + paciente.menorPesoMensual());
                    }
                    break;

                case 4:
                    if (paciente == null) {
                        System.out.println("El paciente no esta registrado. Por favor proceda con la opción 1");
                    } else {

                        int xKilos = 0;

                        do {
                            System.out.println("Por favor, ingrese un valor en kilos entre 70 y 250");
                            xKilos = Leer.datoInt();
                            } while ((xKilos < 70) || (xKilos > 250));

                        int cont = 0;
                        int cont1 = 0;
                        String[] mesesMenos = new String[0];

                        for(int i = 0; i<paciente.menosDeXKilos(xKilos).length; i++){
                            if(paciente.menosDeXKilos(xKilos)[i] == null){
                                cont = cont + 1;
                            } else {
                                cont1 = cont1 + 1;

                            }
                        }
                        if(cont == paciente.menosDeXKilos(xKilos).length){
                            System.out.println("El paciente nunca peso menos de " +xKilos);
                        }else {
                            System.out.println("Los meses en los que el paciente peso menos de " + xKilos + " kg son "
                                    +cont1+ " y son los siguientes: " + Arrays.toString(paciente.menosDeXKilos(xKilos)));
                        }
                    }
                    break;

                case 5:
                    if (paciente == null) {
                        System.out.println("El paciente no esta registrado. Por favor proceda con la opción 1");
                    } else {
                        double estatura = 0;

                        do {
                            System.out.println("Ingrese la estatura del Paciente");
                            estatura = Leer.datoDouble();
                        } while ((estatura < 1.00) || (estatura > 2.50));

                        int mesX;
                        System.out.println("Ingrese el mes a consultar");
                        mesX = Leer.datoInt();
                        /*System.out.printf("El indice de masa corporal para el mes de " +mesX+ " es: %.2f", +paciente.indiceMasaCorporal(estatura,mesX));
                        System.out.println("");*/

                        System.out.println("La condición de salud del paciente para el mes de " +Mes[mesX-1]+ " es: " +paciente.pesoMesX(paciente.indiceMasaCorporal(estatura,mesX)));
                    }
                    break;

            }
        } while (opción != 6);
    }
}