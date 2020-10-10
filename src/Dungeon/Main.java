package Dungeon;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();
//------------ Ennemis --------------//
        String[] enemies = { "Zombie", "Squelette", "Ninja", "Elf "};
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 25;
//------------ Stats --------------//
        int health = 100;
        int attackDamage = 20;
        int numHealthPotions = 3;
        int healthPotionsAmount = 20;
        int healthPotionsDropChance = 20; //%

        boolean running = true;

        System.out.println("Bienvenue dans le Donjon!");

        GAME:
        while (running) {
            System.out.println("__________________________________");

            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[random.nextInt(enemies.length)];
            System.out.println("Un " + enemy + " vient d'apparaître!");

            while (enemyHealth > 0){
                System.out.println("\tPV:" + health);
                System.out.println(enemy + " PV: " + enemyHealth);
                System.out.println("\n\tQue veux-tu faire?");
                System.out.println("\t1. Attaquer!");
                System.out.println("\t2. Prendre une potion!");
                System.out.println("\t3. Fuir!");

                String input = in.nextLine();
                if(input.equals("1")) {
                    int damageDealt = random.nextInt(attackDamage);
                    int damageTaken = random.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> Tu as infligé " + damageDealt + " à "  + enemy + "!");
                    System.out.println("\t> Tu as reçu " + damageTaken + " par " + enemy + "!");

                    if(health < 1) {
                        System.out.println("\t>Tu as pris trop de dégats, tu es trop faible pour continuer.");
                        break;
                    }
                }
            else if(input.equals("2")) {
                if (numHealthPotions > 0) {
                    health += healthPotionsAmount;
                    numHealthPotions--;
                    System.out.println("\t> Tu as pris une potion." + healthPotionsAmount + "regénéré!" +
                            "\n\t> Tu as maintenant " + health + " PV" +
                            "\n\t> Tu as " + numHealthPotions + " potions restante.\n");

                }
                else {
                    System.out.println("\t> Tu n'as plus de potions! Tue un ennemis pour avoir une chance d'en récupérer une!");
                }
            }
            else if(input.equals("3")) {
                System.out.println("\tTu as échappé à " + enemy + "!");
                continue GAME;
            }
            else {
                System.out.println("\tCommande invalide");
            }

            }

        if(health < 1) {
            System.out.println("Tu es sortie du Donjon!");
        }

        System.out.println("__________________________________");
        System.out.println(enemy + " a était battu!" );
        System.out.println("Il te reste " + health + " HP!");
        if(random.nextInt(100) < healthPotionsDropChance) {
            numHealthPotions++;
            System.out.println("Le" + enemy + " a laché une potion!");
            System.out.println("Tu as maintenant " + numHealthPotions + " !");
        }
            System.out.println("__________________________________");
            System.out.println("Que veux-tu faire maintenant?");
            System.out.println("1. Continuer de te battre!");
            System.out.println("2. Quitter le Donjon!");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Commande invalide");
                input = in.nextLine();
            }

            if(input.equals("1")) {
                System.out.println("Tu continues l'aventure!");
            }

            else if(input.equals("2")) {
                System.out.println("Tu as quitté le Donjon!");
            break;
            }

        }
    }
}
