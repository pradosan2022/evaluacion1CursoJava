package entidad;

public class Paciente {

    private int dni;
    private String nombre;
    private int edad;
    private String sexo;
    private int[] peso;
    public String[] Mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Paciente(int dni, String nombre, int edad, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = new int[12];

        for (int i = 0; i < peso.length; i++) {
            peso[i] = (int) (Math.random() * (251 - 70 +1)+70);
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int[] getPeso() {
        return peso;
    }

    public void setPeso(int[] peso) {
        this.peso = peso;
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
        return minMes;
    }

    int i = 0;
    public double indiceMasaCorporal(double estatura,int mesX) {
        double IMC = 0;
        IMC = this.peso[mesX -1] / Math.pow(estatura, 2);
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

    public String pesoMesX(double IMC) {
        String condición = null;

        if (IMC >= 15 && IMC < 20){
            condición = "Normal";
        } else if (IMC >= 20 && IMC < 28) {
            condición = "Sobrepeso";
        } else if (IMC >= 28) {
            condición = "Obeso";
        } else {
            condición = "Valor por debajo de 15";
        }
        return condición;

    }
}
