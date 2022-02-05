

private static void buscarSeries() {
	do {
		String texto = JOptionPane.showInputDialog("Texto a Buscar").toLowerCase();
		// Buscamos la primera serie que comience con el texto
		// Búsqueda Ordenada
		int i;
		for (i = 0; i < numSeries
				&& texto.compareToIgnoreCase(series[i].getTitulo()) > 0;
				i++);
		// Lo encontramos si NO HEMOS LLEGADO AL FINAL y ESTÁ DONDE HEMOS PARADO
		
		if (i < numSeries && series[i].getTitulo().toLowerCase().startsWith(texto)) {
			// Ponemos totales y cabeceras
			int numS = 0;
			int numSeriesConVotos = 0;
			double valoracionTotal = 0;
			String listado = "<html><h1>Series Encontradas</h1>"
					+ "<table border=1 bgcolor=white><tr><td>Título</td><td>Votos</td><td>Valoración Media</td></tr>";
			for (; i < numSeries && series[i].getTitulo().toLowerCase().startsWith(texto); i++) {
				listado += "<tr><td>" + series[i].getTitulo() + "</td>"
						+ "<td>" + series[i].getVotos() + "</td>"
						+ "<td>" + nf.format(series[i].getValoracion()) + "</td></tr>";
				numS++;
				if (series[i].getVotos() > 0) {
					numSeriesConVotos++;
				}

				valoracionTotal += series[i].getValoracion();
			}
			double valoracionMedia = (numSeriesConVotos > 0) ? valoracionTotal / numSeriesConVotos : 0;
			listado += "</table>"
					+ "<h3>Se han encontrado " + numS + " series</h3>"
					+ "<h3>Valoración Media : " + nf.format(valoracionMedia) + "</h3>"
					+ "</html>";
			JOptionPane.showMessageDialog(null,
					listado,
					"Series",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No existe ninguna serie con ese texto",
					"No Encontrado",
					JOptionPane.WARNING_MESSAGE);
		}
	} while (JOptionPane.showConfirmDialog(null,
			"Buscar Otra Serie",
			"Pregunta",
			JOptionPane.YES_NO_OPTION)
			== JOptionPane.YES_OPTION);
}