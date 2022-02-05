public class OrdenacionQuickSort {

    private static Empleado[] empleados = new Empleado[20];
    private static Oficina[] oficinas = {
        new Oficina(3, "Oficina NORTE"),
        new Oficina(2, "Oficina CENTRO"),
        new Oficina(1, "Oficina SUR")
    };
    private static int numEmpleados;

    private static DateFormat df = DateFormat.getDateInstance();
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();

    private static void inicializarEmpleados() {
        empleados[0] = new Empleado(1, "Juan", "Acebedo", new GregorianCalendar(1972, 0, 12).getTime(), 1234.45, 2);
        empleados[1] = new Empleado(3, "Ana", "Alonso", new GregorianCalendar(1978, 3, 24).getTime(), 2000.4, 2);
        empleados[2] = new Empleado(6, "Luis", "De Miguel", new GregorianCalendar(1983, 1, 11).getTime(), 1234.45, 3);
        empleados[3] = new Empleado(4, "Marta", "Fernandez", new GregorianCalendar(1985, 3, 3).getTime(), 2300.23, 1);
        empleados[4] = new Empleado(10, "Pedro", "Fernandez", new GregorianCalendar(1990, 11, 2).getTime(), 908.5, 3);
        empleados[5] = new Empleado(21, "Carlos", "García", new GregorianCalendar(1975, 2, 6).getTime(), 2090.11, 2);
        empleados[6] = new Empleado(5, "Eva", "González", new GregorianCalendar(1972, 3, 16).getTime(), 1234.45, 2);
        empleados[7] = new Empleado(11, "Luisa", "López", new GregorianCalendar(1989, 4, 21).getTime(), 1375.75, 1);
        empleados[8] = new Empleado(9, "Miguel", "Santos", new GregorianCalendar(2001, 5, 1).getTime(), 1421.5, 2);
        numEmpleados = 9;
    }

    public static void main(String[] args) {
        inicializarEmpleados();
        quicksort(0, numEmpleados - 1);
        // Listamos los empleados
        String listado = "<html><h1>Listado de Empleados</h1>"
                + "<table border=1 bgcolor=white>"
                + "<tr><td>Id</td><td>Nombre</td><td>Apellidos</td>"
                + "<td>Oficina</td><td>Salario</td><td>Fecha Nac.</td></tr>";
        for (int i = 0; i < numEmpleados; i++) {
            listado += "<tr><td>" + empleados[i].getId() + "</td>"
                    + "<td>" + empleados[i].getNombre() + "</td>"
                    + "<td>" + empleados[i].getApellidos() + "</td>"
                    + "<td>" + empleados[i].getIdOficina() + "</td>"
                    + "<td>" + nf.format(empleados[i].getSalario()) + "</td>"
                    + "<td>" + df.format(empleados[i].getFechaNacimiento()) + "</td></tr>";
        }
        listado += "</table></html>";
        JOptionPane.showMessageDialog(null, listado,
                "Listado",
                JOptionPane.PLAIN_MESSAGE);
    }

    private static void quicksort(int menor, int mayor) {
        int i = menor;
        int j = mayor - 1;
        int pivote = mayor;
        do {
            for (; i < pivote && empleados[i].getNombre()
                    .compareToIgnoreCase(empleados[pivote].getNombre())
                    > 0; i++);
            for (; j > i && empleados[j].getNombre()
                    .compareToIgnoreCase(empleados[pivote].getNombre())
                    < 0; j--);
            if (i < j) {
                Empleado temp = empleados[i];
                empleados[i] = empleados[j];
                empleados[j] = temp;
            }
        } while (i < j);
        // El pivote va en i (o en j)
        Empleado temp = empleados[i];
        empleados[i] = empleados[pivote];
        empleados[pivote] = temp;
        // Quedan elementos a la izquierda?
        if (menor + 1 < i){ // i - menor >= 2
            quicksort(menor, i - 1);
        }
        if (mayor - 1 > i){
            quicksort(i+1, mayor);
        }
    }
}