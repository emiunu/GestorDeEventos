public class gestorDeEventos {

        public static void main(String[] args) {
            String[][] listaPersonas = new String[10][5];
        }


        public static void anadirPersona(String [][] listaPersonas, String nombre, String edad, String entrada, String invitados, String ingresado){
            for (int i = 0; i < listaPersonas.length; i++ ){
                if (listaPersonas[i][0] == null || listaPersonas[i][1].equals("") ){
                    listaPersonas[i][0] = nombre;
                    listaPersonas[i][1] = edad;
                    listaPersonas[i][2] = entrada;
                    listaPersonas[i][3] = invitados;
                    listaPersonas[i][4] = ingresado;
                    break;
                }
            }
        }

        public static boolean verificarEdad(String [][] listaPersonas, String nombre){
            for (int i = 0; i < listaPersonas.length; i++ ){
                if (listaPersonas[i][0].equals(nombre)){
                    int edad = Integer.parseInt(listaPersonas[i][1]);
                    if (edad >= 18){
                        return true;
                    }

                }
            }
            return false;
        }

        public static String verificarBoleto(String [][] listaPersonas, String nombre){
            for (int i = 0; i < listaPersonas.length; i++){
                if (listaPersonas[i][0].equals(nombre)){
                    String entrada = listaPersonas[i][2];
                    return entrada;
                }
            }return "";
        }

        public static boolean validarInvitados(String [][] listaPersonas, String nombre){
            for (int i = 0; i < listaPersonas.length; i++ ){
                if (listaPersonas[i][0].equals(nombre)){
                    String entrada = verificarBoleto(listaPersonas,nombre);
                    if (entrada == "VIP"){
                        int invitados = Integer.parseInt(listaPersonas[i][3]);
                        if (invitados > 2){
                            return false;
                        } else if (invitados >= 0){
                            return true;
                        }
                    } else if (entrada == "General"){
                        int invitados = Integer.parseInt(listaPersonas[i][3]);
                        if (invitados == 0){
                            return true;
                        }
                    }

                }
            }return false;
        }

        public static int aforoDisponible(String [][] listaPersonas, String sala, int aforoSala){

            for (int i = 0; i < listaPersonas.length; i++){
                if (listaPersonas[i][2].equals(sala)){
                    boolean ingresado = Boolean.parseBoolean(listaPersonas[i][4]);
                    if (ingresado == true){
                        aforoSala--;
                    }else{
                        continue;
                    }


                }
            }return aforoSala;
        }

        public static String [][] ingresarPersona(String [][] listaPersonas, String nombre){
            for (int i = 0; i < listaPersonas.length; i++ ){
                if (listaPersonas[i][0].equals(nombre)){
                    listaPersonas[i][4] = "True";
                    return listaPersonas;
                }
            }return listaPersonas;
        }

        public static boolean permitirEntrada(String [][] listaPersonas, String nombre, String sala, int aforoSala){
            for (int i = 0; i < listaPersonas.length; i++ ){
                if (listaPersonas[i][0].equals(nombre)){
                    boolean edad = verificarEdad(listaPersonas,nombre);
                    String entrada = verificarBoleto(listaPersonas,nombre);
                    int aforoDisponible = aforoDisponible(listaPersonas,sala, aforoSala);
                    if (edad == false){
                        return false;
                    } else if (entrada != "General" && entrada != "VIP"){
                        return false;
                    } else if (aforoDisponible <= 0){
                        return false;
                    } else {
                        return true;
                    }
                }
            }return false;
        }

        public static String [][] removerPersona(String[][] listaPersonas, String nombre){
            for (int i = 0; i < listaPersonas.length; i++ ){
                if (listaPersonas[i][0].equals(nombre)){
                    if (listaPersonas[i][2].equals("General")){
                        listaPersonas[i][4] = "False";
                        return listaPersonas;
                    } else if (listaPersonas[i][2].equals("VIP")){
                        listaPersonas[i][4] = "False";
                        listaPersonas[i][3] = "0";
                        return listaPersonas;
                    }
                }
            }return listaPersonas;
        }

    }


