import java.util.*;

public class Main {
    static ArrayList<Integer> JoueurPositions = new ArrayList<Integer>();
    static ArrayList<Integer> OrdinateurPositions = new ArrayList<Integer>();
    public static void main(String[] args) {
        char [][] jeu = {{' ', '|', ' ', '|', ' '},
                {'_', '|', '_', '|', '_'},
                {' ', '|', ' ', '|', ' '},
                {'_', '|', '_', '|', '_'},
                {' ', '|', ' ', '|', ' '},
                {' ', '|', ' ', '|', ' '},
        };
         jeuboard(jeu);

        while (true){

            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez l'emplacement 1-9");
            int position = sc.nextByte();
            while(JoueurPositions.contains(position)|| OrdinateurPositions.contains(position)){
                System.out.println("Male Position choissiez une autre position");
                position = sc.nextInt();
            }
            position(position,jeu,"joueur");
            String Resultat = Verification_Qui_Gagne();
            if(Resultat.length() > 0){
                Resultat = Verification_Qui_Gagne();
                System.out.println(Resultat);
                break;
            }
            Random rand = new Random();
            int  ordinateurposition = rand.nextInt(9)+1;
            while(JoueurPositions.contains(ordinateurposition)|| OrdinateurPositions.contains(ordinateurposition)){
                ordinateurposition = rand.nextInt(9)+1;
            }
            position(ordinateurposition,jeu,"Ordinateur");
            jeuboard(jeu);
            if(Resultat.length() > 0){
                Resultat = Verification_Qui_Gagne();
                System.out.println(Resultat);
                break;
            }

           System.out.println(Resultat);
        }

    }
    public  static String Verification_Qui_Gagne(){
        List HAUT = Arrays.asList(1,2,3);
        List MILIEU = Arrays.asList(4,5,6);
        List DESSENT = Arrays.asList(7,8,9);
        List Col_gauche = Arrays.asList(1,4,7);
        List Col_milieu = Arrays.asList(2,5,8);
        List Col_bas = Arrays.asList(3,6,9);
        List Col_mil = Arrays.asList(1,5,9);
        List col_droit = Arrays.asList(7,5,3);
        List<List> Ganeur = new ArrayList<List>();
        Ganeur.add(HAUT);
        Ganeur.add(MILIEU);
        Ganeur.add(DESSENT);
        Ganeur.add(Col_gauche);
        Ganeur.add(Col_milieu);
        Ganeur.add(Col_bas);
        Ganeur.add(Col_mil);
        Ganeur.add(col_droit);
        for (List i:Ganeur) {
            if(JoueurPositions.containsAll(i)){
                return "FELICITATIONS VOUS AVEZ GAGNEZ! :)";
            } else if(OrdinateurPositions.containsAll(i)){
                return "ORDINATEUR A GAGNEZ DESOLER :( ";
            }else if(JoueurPositions.size() + OrdinateurPositions.size() == 9){
                return "MATCH NULL !";
            }
        }

        return "";
    }
    public static void jeuboard(char [][] jeu){
        for (char[] chars : jeu) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static void position(int position,char jeu[][],String user){
        char symobole = ' ';
        if(user.equals("joueur")){
            symobole = 'X';
            JoueurPositions.add(position);
        } else if(user.equals("Ordinateur")){
            symobole= 'O';
            OrdinateurPositions.add(position);
        }

        switch (position){
            case 1:
                jeu [0][0] = symobole;
                break;

            case 2:
                jeu [0][2] = symobole;
                break;
            case 3:
                jeu [0][4] = symobole;
                break;
            case 4:
                jeu [2][0] = symobole;
                break;
            case 5:
                jeu [2][2] = symobole;
                break;
            case 6:
                jeu [2][4] = symobole;
                break;
            case 7:
                jeu [4][0] =symobole;
                break;
            case 8:
                jeu [4][2] = symobole;
                break;
            case 9:
                jeu [4][4] = symobole;
                break;
        }
    }
}