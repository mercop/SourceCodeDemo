package com.marving.code.java.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by mercop on 2017/8/6.
 */

public class bd1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int totalConsumes = 0;

        if(n < 1 || m < 1)
            return ;
        int[] health = new int[n];
        int[] defensive = new int[n];

        for(int i = 0; i < n; i++){
            health[i] = in.nextInt();
            defensive[i] = in.nextInt();
        }

        ArrayList<Skill> skillList = new ArrayList<>();

        for(int i = 0; i < m; i ++){
            Skill skill = new Skill();
            skill.consume = in.nextInt();
            skill.damage = in.nextInt();
            skill.value = (skill.damage * 1.0)/ skill.consume;
            skillList.add(skill);
        }

        skillList.sort(new SkillComparator());

        for(Skill s : skillList)
            System.out.println(s);


        for(int i = 0; i < n;i++){
            int d = defensive[i];
            for(int j = 0;j < m && health[i] > 0; j ++){
                Skill s = skillList.get(j);
                if(s.damage > d){
                    if(health[i] < s.damage - d){
                        //找到消耗最少满足条件的技能
                        int minIndex = j;
                        int min = s.consume;
                        for(int k = j; k < m;k++){
                            Skill s1 = skillList.get(k);
                            if(health[i] < s1.damage - d && min > s1.consume){
                                min = s.consume;
                                health[i] -= (s1.damage -d);
                                minIndex = k;
                            }
                        }

                    }
                    else{
                        health[i] -= (s.damage - d);
                        totalConsumes +=s.consume;
                    }
                }
            }

            if(health[i] != 0){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(totalConsumes);
    }
}

class Monster{

    int health;
    int defensive;
}

class Skill{

    public int consume;
    public int damage;
    public double value;

    @Override
    public String toString() {
        return "Skill{" +
                "consume=" + consume +
                ", damage=" + damage +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Skill){
            Skill skill = (Skill) obj;
            if(skill.consume == this.consume && skill.damage == skill.damage)
                return true;
        }
        return false;
    }

}

class SkillComparator implements Comparator<Skill>{

    @Override
    public int compare(Skill o1, Skill o2) {
        if(o1.equals(o2))
            return 0;
        return o1.value > o2.value ? -1:1;
    }
}


