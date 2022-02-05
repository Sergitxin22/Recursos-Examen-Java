public static void main(String[] args) {
        int opc;
        do {
            String resp = JOptionPane.showInputDialog(
                    "1. Vender Libro\n"
                    + "2. Buscar Tema\n"
                    + "3. Salir\n\n"
                    + "Opción [1-3]");
            opc = Integer.parseInt(resp);
            switch (opc) {
                case 1:
                    venderLibro();
                    break;
                case 2:
                    listarPorTema();
                    break;
                case 3:
                    resumenVentas();
                    break;
            }
        } while (opc != 3);

    }

    private static void venderLibro() {
		String titulo = JOptionPane.showInputDialog("Título del Libro");
		// Búsqueda DESORDENADA
		int i;
		for (i = 0; i < libros.length
				&& !titulo.equalsIgnoreCase(libros[i].getTitulo());
				i++);
		// Si NO HEMOS LLEGADO AL FINAL lo hemos encontrado
		if (i < libros.length) {
			if (libros[i].getUnidades() == 0) {
				JOptionPane.showMessageDialog(null,
						"No quedan unidades del libro",
						"No Hay Stock",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				String resp = JOptionPane.showInputDialog(
						"<html><h2>" + libros[i].getTitulo() + "</h1>"
						+ "<table border=1 bgcolor=white>"
						+ "<tr><td>Tema : </td><td>" + libros[i].getTema() + "</td></tr>"
						+ "<tr><td>Unidades : </td><td>" + libros[i].getUnidades() + "</td></tr>"
						+ "<tr><td>Precio : </td><td>" + nfMoneda.format(libros[i].getPrecio()) + "</td></tr>"
						+ "</table>"
						+ "<h4>Cuántos libros desea comprar</h4></html>");
				int cantidad = Integer.parseInt(resp);
				double importe = libros[i].vender(cantidad);
				if (importe == 0) {
					JOptionPane.showMessageDialog(null,
							"No hay suficientes unidades. Quedan " + libros[i].getUnidades() + " unidades",
							"No hay Stock",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"Venta REALIZADA!\n\n"
							+ "Importe : " + nfMoneda.format(importe));
				}
			}
		} else {
			// NO ESTÁ
			JOptionPane.showMessageDialog(null,
					"No existe ningún libro con ese título",
					"No Encontrado",
					JOptionPane.WARNING_MESSAGE);
		}
    }