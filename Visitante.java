package p1029;

public class Visitante {

    private String name;
    private int edad;
    private int estatura;
    private double dinero;
    private int tipo;            // 1 = General, 2 = VIP, 3 = Estudiante
    private int numAtracciones;
    private int costo;

    // Constructor: valida los datos y calcula el costo
    public Visitante(String name, int edad, int estatura, double dinero,
            int tipo, int numAtracciones) {

        if (name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120.");
        }
        if (estatura <= 0 || estatura > 250) {
            throw new IllegalArgumentException("La estatura debe estar entre 1 y 250 cm.");
        }
        if (dinero < 0) {
            throw new IllegalArgumentException("El dinero no puede ser negativo.");
        }
        if (tipo < 1 || tipo > 3) {
            throw new IllegalArgumentException("El tipo de entrada debe ser 1, 2 o 3.");
        }
        if (numAtracciones < 0) {
            throw new IllegalArgumentException("La cantidad de atracciones no puede ser negativa.");
        }
        if (tipo == 3 && edad > 25) {
            throw new IllegalArgumentException("El descuento de estudiante es hasta los 25 años.");
        }

        this.name = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.dinero = dinero;
        this.tipo = tipo;
        this.numAtracciones = numAtracciones;
        this.costo = calcularCosto();
    }

    // ---------- Getters ----------
    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public int getEstatura() {
        return estatura;
    }

    public double getDinero() {
        return dinero;
    }

    public int getNumAtracciones() {
        return numAtracciones;
    }

    public int getCosto() {
        return costo;
    }

    // ---------- Metodos ----------
    public String clasificar() {
        if (edad <= 5) {
            return "Infantil";
        } else if (edad <= 12) {
            return "Niño";
        } else if (edad <= 17) {
            return "Adolescente";
        } else if (edad <= 59) {
            return "Adulto";
        } else {
            return "Adulto mayor";
        }
    }

    public String nombreTipo() {
        if (tipo == 1) {
            return "General";
        } else if (tipo == 2) {
            return "VIP";
        } else {
            return "Estudiante";
        }
    }

    public int calcularCosto() {
        int precio;

        if (tipo == 1) {
            precio = 150;
        } else if (tipo == 2) {
            precio = 280;
        } else {
            precio = 100;
        }

        if (edad <= 5) {
            precio = 0;                  // infantil no paga
        } else if (edad <= 12) {
            precio = precio * 70 / 100;  // niño 30% de descuento
        } else if (edad >= 60) {
            precio = precio / 2;         // adulto mayor 50% de descuento
        }

        return precio;
    }

    // Atraccion: 1 = Infantil, 2 = Familiar, 3 = Extrema
    public boolean puedeSubir(int atraccion) {

        if (atraccion < 1 || atraccion > 3) {
            throw new IllegalArgumentException("La atraccion debe ser 1, 2 o 3.");
        }

        if (atraccion == 1) {
            return estatura >= 80 && edad >= 0;
        } else if (atraccion == 2) {
            return estatura >= 100 && edad >= 6;
        } else {
            return estatura >= 140 && edad >= 15;
        }
    }
}
