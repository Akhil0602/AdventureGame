import java.util.*;
import java.lang.*;
import java.io.*;
public class AdventureGame
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        Random rand=new Random();
        System.out.print("\u000C");
        String[] enemies={"Blade Knight","Parasol","Flamer","Sword Knight"};
        
        int playerHealth=100;
        int enemyMaxHealth=70;
        int healthPotions=3;
        int healHealth=40;
        int enemyMaxDamage=20;
        int playerMaxDamage=30;
        int potionDropChance=40;
        System.out.println("\n #Welcome to the Adventure Dungeon#");
        GAME:
        while(true)
        {
            String enemy=enemies[rand.nextInt(enemies.length)];
            int enemyHealth=rand.nextInt(enemyMaxHealth+1);
            System.out.println("\t$ An "+enemy+" has appeared $");
            while(enemyHealth>0)
            {
                System.out.println("\t$ Your health is: "+playerHealth+" HP $");
                System.out.println("\t$ Enemy health is: "+enemyHealth+" HP $");
                System.out.println("\t1.Attack\n\t2.Drink Health Potion\n\t3.Run\n\t$ What would you like to do? $");
                String choice=in.readLine();
                if(choice.equals("1"))
                {
                    int damageDone=rand.nextInt(playerMaxDamage+1);
                    int damageDealt=rand.nextInt(enemyMaxDamage+1);
                    playerHealth-=damageDealt;
                    enemyHealth-=damageDone;
                    System.out.println("\t$ You did a damage of "+damageDone+"HP to the enemy $");
                    System.out.println("\t$ Enemy did a damage of "+damageDealt+"HP to you $");
                    if(playerHealth<1)
                    {
                        System.out.println("\t$ Too much damage done by the enemy... $\n\t$ Your journey in the Dungeon ends Here $");
                        break;
                    }
                }
                else if(choice.equals("2"))
                {
                    if(healthPotions>0)
                    {
                     playerHealth+=healHealth;
                     healthPotions--;
                     System.out.println("\t$ Your health was increased by "+healHealth+"HP $\n\t$ Your current Health is "+playerHealth+"HP $\n\t $You have "+healthPotions+" health potions left $");
                     }
                     else
                     System.out.println("\t$ You do not have any health potions.Try fighting the enemy or run away $");
                }
                else if(choice.equals("3"))
                {
                System.out.println("\t$ You ran away from the current enemy.Lets continue our further journey $");
                continue GAME;
                }
                else
                System.out.println("\t$ Invalid Choice.Please Enter Again $");
            }
            if(playerHealth<1)
            break;
            System.out.println("\t$ "+enemy+" was killed...Great Work $");
            if(rand.nextInt(100)<potionDropChance)
            {
                healthPotions++;
                System.out.println("\t$ The enemy dropped a health potion. $\n\t$ Now,you have "+healthPotions+" health potions $");
            }
            System.out.println("\n\n\n\t$ 1.Continue your Journey\n\t2.Exit the Dungeon $\n\t$ Please Enter your choice");
            String choice=in.readLine();
            while(!choice.equals("1")&&!choice.equals("2"))
            {
                System.out.println("Invalid Choice");
                choice=in.readLine();
            }
            if(choice.equals("1"))
            continue;
            else
            {
                break;
            }
        }
        System.out.println("\t##########################\n\t#####Thanks for playing###\n\t##########################");
    }
}
            