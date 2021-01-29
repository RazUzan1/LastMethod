package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Company {
    String name;
    ArrayList<Worker> allWorkers;
    ArrayList<Integer> sales;

    public Company(String name) {
        this.name = name;
        allWorkers = new ArrayList<Worker>();
        sales = new ArrayList<Integer>();
    }

    int totalPayments() {
        int i = 0;
        double sum = 0;
        for (i = 0; i < allWorkers.size(); i++) {
            sum += allWorkers.get(i).Salary();
        }
        return (int) sum;
    }


    int totalEarnings() {
        double sum = 0;
        int i = 0;
        for (i = 0; i < sales.size(); i++) {
            sum += sales.get(i);
        }
        return (int) sum;
    }

    Worker workedMost() {
        int max = 0;
        Worker mostDays = allWorkers.get(0);
        for (int i = 0; i < allWorkers.size(); i++) {
            if (allWorkers.get(i).workingDays() > max) {
                mostDays = allWorkers.get(i);
                max = allWorkers.get(i).workingDays();
            }

        }
        return mostDays;
    }

    void addWorker(Worker w) {
        allWorkers.add(w);
    }

        void swap(Object x, Object y){
            Object temp = x;
            x = y;
            y = temp;
        }


        void crisis(){
            ArrayList<Worker> MostWorker = new ArrayList<>();
            MostWorker.addAll(allWorkers);
            ArrayList<Worker> Expensiv = new ArrayList<>();
            Expensiv.addAll(allWorkers);

            //עבדו הכי הרבה שעות נוספות
            for (int i = 1; i <MostWorker.size() - 1;  i++) {
                for (int j = 0; j < MostWorker.size(); j++) {
                    Worker a = MostWorker.get(j - 1);
                    Worker b = MostWorker.get(j);

                    if (a.getWorkdays().get(j).Extra() >b.getWorkdays().get(j).Extra()){
                        swap(j - 1, j);
                    }
                }
            }
            //מרוויחים הכי הרבה לפי שעה
            for (int i = 1; i < Expensiv.size() - 1; i++) {
                for (int j = 0; j < Expensiv.size(); j++) {
                    Worker a = MostWorker.get(j - 1);
                    Worker b = MostWorker.get(j);

                    if (a.getPay() > b.getPay()){
                        swap(j - 1, j);
                    }
                }
            }

            for (int i = 0; i < (Expensiv.size() * 0.75); i++) {
                Expensiv.remove(i);
            }
            for (int i = 0; i < (MostWorker.size() * 0.75); i++) {
                MostWorker.remove(i);
            }


            for (Worker hour:MostWorker){
            if (allWorkers.contains(hour)){
                allWorkers.remove(hour);
             }
            }

            for (Worker payed:Expensiv){
                if (allWorkers.contains(payed)){
                    allWorkers.remove(payed);
                }
            }
         }
       }