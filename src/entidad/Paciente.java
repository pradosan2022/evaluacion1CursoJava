package entidad;

import java.text.Format;

public class Paciente {

    private int dni;
    private String nombre;
    private int edad;
    private char sexo;
    private int[] peso;
    private double estatura;
    String Mes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Paciente(int dni, String nombre, int edad, char sexo, double estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = new int[12];
        this.estatura = estatura;

        for (int i = 0; i < peso.length; i++) {
            peso[i] = (int) (Math.random() * (251 - 70));
        }
    }

    public Paciente() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int[] getPeso() {
        return peso;
    }

    public void setPeso(int[] peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String menorPesoMensual() {
        int min = getPeso()[0];
        String minMes = Mes[0];

        for (int i = 1; i < Mes.length; i++) {
            if (getPeso()[i] < min) {
                min = getPeso()[i];
                minMes = Mes[i];
            }
        }
        return "El mes con menor peso es: " + minMes;
    }

    public double indiceMasaCorporal(int mesX) {
        int pesoMesX = peso[mesX - 1];
        double IMC = 0;
        IMC = pesoMesX / Math.pow(getEstatura(), 2);
        return IMC;
    }

    public String[] menosDeXKilos(int xKilos) {
        String[] mesesMenorXKilos = new String[12];
        for (int i = 0; i < peso.length; i++) {

            if (getPeso()[i] < xKilos) {
                mesesMenorXKilos[i] = Mes[i];
            }
        }
        return mesesMenorXKilos;
    }

    public String pesoMesX() {
        String condición = null;
        indiceMasaCorporal(6);

        if (indiceMasaCorporal(6) > 15 && indiceMasaCorporal(6) < 20){
            condición = "Normal";
        } else if (indiceMasaCorporal(6) >= 20 && indiceMasaCorporal(6) < 28) {
            condición = "Sobrepeso";
        } else if (indiceMasaCorporal(6) >= 28) {
            condición = "Obeso";
        } else {
            condición = "Valor por debajo de 15";
        }
        return condición;

        }
}
