package observer;

import strategy.Context;
import strategy.DefaultStrategyImpl;
import strategy.Strategy;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        Scanner scanner = new Scanner(System.in);
        Map<String, Strategy> strategyMap = new HashMap<>();
        Strategy strategy;
        while (true) {
            System.out.println("Tapez le numero d'une strategie : ");
            String str = scanner.nextLine();
            strategy = strategyMap.get(str);
            if (strategy == null) {
                try {
                    System.out.println("Creation d'un nouvel objet de StrategyImpl" + str);
                    strategy = (Strategy) Class.forName("strategy.StrategyImpl" + str).getConstructor().newInstance();
                    strategyMap.put(str, strategy);
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | 
                         InstantiationException | IllegalAccessException e) {
                    System.out.println("Strategie " + str + " n'existe pas, utilisation de la strategie par defaut");
                    strategy = new DefaultStrategyImpl();
                }
            }
            context.setStrategy(strategy);
            context.effectuerOperation();
        }
    }
}