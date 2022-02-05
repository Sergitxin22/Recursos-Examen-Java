private static void bucarPorHabYBaños() {
        String resp = JOptionPane.showInputDialog("Nº Habitaciones");
        int numH = Integer.parseInt(resp);
        resp = JOptionPane.showInputDialog("Nº Baños");
        int numB = Integer.parseInt(resp);
        int i;
        for(i=0; i<numInmuebles && 
            (inmuebles[i].getHabitaciones()<numH
            ||
            inmuebles[i].getBaños()<numB);
            i++);
        if (i<numInmuebles){
            String listado = "<html><h1>Inmuebles mínimo de " +numH + " habitaciones y " + numB + " baños.</h1>"
                    + "<table border=1 bgcolor=white><tr><td>Ref</td>"
                    + "<td>Descripción</td><td>Dirección</td><td>Zona</td>"
                    + "<td>Hab.</td><td>Baños</td>"
                    + "<td>Precio</td></tr>";
            for(; i<numInmuebles;i++){
                if (inmuebles[i].getHabitaciones()>=numH &&
                    inmuebles[i].getBaños()>=numB){
                    listado += "<tr><td>" + inmuebles[i].getReferencia() + "</td>"
                        + "<td>" + inmuebles[i].getDescripcion() + "</td>"
                        + "<td>" + inmuebles[i].getDireccion() + "</td>"
                        + "<td>" + inmuebles[i].getZona() + "</td>"
                        + "<td>" + inmuebles[i].getHabitaciones() + "</td>"
                        + "<td>" + inmuebles[i].getBaños() + "</td>"
                        + "<td>" + nfMoneda.format(inmuebles[i].getPrecio()) + "</td></tr>";
                }
            }
            listado += "</table></html>";
            JOptionPane.showMessageDialog(
                    null,
                    listado,
                    "Inmuebles encontrados",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No hey ningún inmueble que cumpla",
                    "No Encontrado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }