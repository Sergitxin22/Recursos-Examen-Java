private static void votarSerie() {
	do {
		String titulo = JOptionPane.showInputDialog("Título");
		// Búsqueda Binaria
		int menor = 0;
		int mayor = numSeries - 1;
		int medio = mayor / 2;
		// Mientras no lleguemos a una incongruencia y la serie no sea la del medio
		while (menor <= mayor && !titulo.equalsIgnoreCase(series[medio].getTitulo())) {
			//Comprobamos si tenemos que buscar en la mitad superior
			if (titulo.compareToIgnoreCase(series[medio].getTitulo()) > 0) {
				// Tenemos que buscar en la parte superior
				menor = medio + 1;
			} else {
				// Tenemos que buscar en la parte inferior
				mayor = medio - 1;
			}
			// Recalculamos el nuevo punto medio del nuevo rango
			medio = (menor + mayor) / 2;
		}
		if (menor <= mayor) {
			// Está en la posición medio
			String resp = JOptionPane.showInputDialog(
					"<html><table border=1 bgcolor=white>"
					+ "<tr><td>Título</td><td>" + series[medio].getTitulo() + "</td></tr>"
					+ "<tr><td>Sinopsis</td><td>" + series[medio].getSinopsis() + "</td></tr>"
					+ "<tr><td>Votos</td><td>" + series[medio].getVotos() + "</td></tr>"
					+ "<tr><td>Valoración</td><td>" + nf.format(series[medio].getValoracion()) + "</td></tr>"
					+ "</table>Introduzca su Valoración :</html>");
			int valoracion = Integer.parseInt(resp);
			series[medio].votar(valoracion);
			JOptionPane.showMessageDialog(null, "Su valoración se ha registrado correctamente\nMuchas Gracias!");
		} else {
			JOptionPane.showMessageDialog(null, "No existe ninguna serie con ese título",
					"No Encontrado",
					JOptionPane.WARNING_MESSAGE);
		}
	} while (JOptionPane.showConfirmDialog(null,
			"Desea Valorar Otra Serie",
			"Pregunta",
			JOptionPane.YES_NO_OPTION)
			== JOptionPane.YES_OPTION);

}2