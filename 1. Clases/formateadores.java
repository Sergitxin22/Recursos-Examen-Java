public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance();
        NumberFormat nfMoneda = NumberFormat.getCurrencyInstance();
        NumberFormat nfPorc = NumberFormat.getPercentInstance();
		
		// Cambiar mínimo - maximo de decimales en fracción
        nfPorc.setMinimumFractionDigits(2);
        nfPorc.setMaximumFractionDigits(2);
		
		// Crear formateador de fecha corta - media
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat dfMedio = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
        double capital = 0, interes = 0;
        int años = 0;
        Date fecha = null;
        String resp = JOptionPane.showInputDialog("Capital Solicitado");
		
		// Validar numberFormat
        boolean ok = false;
        while (!ok){
            try {
                Number n = nf.parse(resp);
                ok = true;
                capital = n.doubleValue();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, 
                    "El capital debe ser un valor numérico",
                    "Dato Erróneo",
                    JOptionPane.ERROR_MESSAGE);
                resp = JOptionPane.showInputDialog("Capital Solicitado");
            }
        }
		
        // numFormateador.format(loQueSea) ---> Muestra loQueSea formateado
        System.out.println("\n\nTotal Pagado : " + nfMoneda.format(p.getAños()*12*pago));
    }