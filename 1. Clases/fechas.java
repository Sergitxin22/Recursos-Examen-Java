String fecha = JOptionPane.showInputDialog("Introduce una fecha dd/mm/aaaa: ");
    int s1 = fecha.indexOf("/");
    int s2 = fecha.lastIndexOf("/");
    
    int dia = Integer.parseInt(fecha.substring(0, s1));
    int mes = Integer.parseInt(fecha.substring(s1+1, s2));
    int año = Integer.parseInt(fecha.substring(s2+1));
    
    // Crear Calendario Gregoriano con el día, mes y año del usuario
    GregorianCalendar gc = new GregorianCalendar(año, mes-1, dia);
    System.out.println(App.mostrar(gc));
    
    // Añadirle 30 días a la fecha
    gc.add(Calendar.DATE, 30);
    System.out.println(App.mostrar(gc));
    
    // Comprobar si es sábado o domingo y si es así pasar al siguiente lunes
    if(gc.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
        gc.add(Calendar.DATE, 2);
    }else if(gc.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
        gc.add(Calendar.DATE, 1);
    }
    System.out.println(App.mostrar(gc));
    
    // Mostrar el siguiente día 15
    if(gc.get(Calendar.DAY_OF_MONTH) > 15){
        gc.add(Calendar.MONTH, 1);
    }
    gc.set(Calendar.DAY_OF_MONTH, 15);
    System.out.println(App.mostrar(gc));
    
    // Mostrar el trimestre
    int trim = gc.get(Calendar.MONTH) /3 + 1;        
    System.out.println("Trimestre: " + trim);
    
    // Comprobar si es festivo o no
    if(gc.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || gc.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
        System.out.println("ES FESTIVO");
    }else{
        System.out.println("ES LABORABLE");
    }
    
    // Comprobar cuantos días han pasado desde el principio del año
    int diaAño = gc.get(Calendar.DAY_OF_YEAR);
    System.out.println("Han pasado " + (diaAño-1) + " días desde principio de año");
    
    // Comprobar cuantos días quedan hasta el fin del año
    int diasQuedan = gc.getActualMaximum(Calendar.DAY_OF_YEAR) - diaAño;
    System.out.println("Quedan " + diasQuedan + " días hasta el fin del año");
    
    // Días hasta fin de mes
    diasQuedan = gc.getActualMaximum(Calendar.DAY_OF_MONTH) - gc.get(Calendar.DAY_OF_MONTH);
    System.out.println("Quedan " + diasQuedan + " días hasta el fin del mes");
    
    // Comprobar si es bisiesto
    System.out.println((gc.isLeapYear(gc.get(Calendar.YEAR)) ? "Es bisiesto" : "NO es bisiesto"));
    
    // Pasar al siguiente lunes
    if (gc.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
        switch (gc.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.TUESDAY:
                gc.add(Calendar.DATE, 6);
                break;
            case Calendar.WEDNESDAY:
                gc.add(Calendar.DATE, 5);
                break;  
            case Calendar.THURSDAY:
                gc.add(Calendar.DATE, 4);
                break;
            case Calendar.FRIDAY:
                gc.add(Calendar.DATE, 3);
                break;
            case Calendar.SATURDAY:
                gc.add(Calendar.DATE, 2);
                break;
            default:
                gc.add(Calendar.DATE, 1);
                break;
        }
    }
    System.out.println(App.mostrar(gc));
    
    // Mi próximo cumpleaños 20/06
    if(gc.get(Calendar.MONTH) > 6 || (gc.get(Calendar.MONTH) == 6 && gc.get(Calendar.DAY_OF_MONTH) > 20)){
        gc.add(Calendar.YEAR, 1);
    }
    gc.set(Calendar.MONTH, 6-1);
    gc.set(Calendar.DAY_OF_MONTH, 20);
    System.out.println(App.mostrar(gc));
    
    // Si la fecha es anterior el mensaje será Hace días días que fue fecha. Donde fecha es la fecha del calendario y días el número de días calculado.
    GregorianCalendar gcHoy = new GregorianCalendar();
    gcHoy.set(Calendar.HOUR,0);
    gcHoy.clear(Calendar.HOUR_OF_DAY);
    gcHoy.clear(Calendar.MINUTE);
    gcHoy.clear(Calendar.SECOND);
    gcHoy.clear(Calendar.MILLISECOND);
    int dias = 0;
    if (gcHoy.before(gc)){
        /*while (gcHoy.before(gc)){
            gcHoy.add(Calendar.DATE, 1);
            dias++;
        }*/
        dias = (int) ((gc.getTimeInMillis() - gcHoy.getTimeInMillis())
                / (24*3600*1000));
        System.out.println("Faltan " + dias + " días");
    } else {
        while (gcHoy.after(gc)){
            gcHoy.add(Calendar.DATE, -1);
            dias++;
        }
        System.out.println("Han pasado " + dias + " días");
    }
}

private static String mostrar(GregorianCalendar gc){
    String res =  gc.get(Calendar.DAY_OF_MONTH) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.YEAR);
    
    String dia = "";
    switch (gc.get(Calendar.DAY_OF_WEEK)){
        case Calendar.MONDAY:
            dia = "Lunes";
            break;
        case Calendar.TUESDAY:
            dia = "Martes";
            break;
        case Calendar.WEDNESDAY:
            dia = "Miércoles";
            break;
        case Calendar.THURSDAY:
            dia = "Jueves";
            break;
        case Calendar.FRIDAY:
            dia = "Viernes";
            break;
        case Calendar.SATURDAY:
            dia = "Sábado";
            break;
        case Calendar.SUNDAY:
            dia = "Domingo";
            break;
    }
    return res + "(" + dia + ")";
}

private static String mostrarConDateFormat(GregorianCalendar gc){
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy ( EEEE )");
    return df.format(gc.getTime());
}