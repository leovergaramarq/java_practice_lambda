package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        sortExample();
        functionalInterfaceExample();
        forEachExample();
    }
    
    @FunctionalInterface
    interface ILambda{
        void print(String msg);
    }
    
    static void sortExample(){
        ArrayList<String> lista=new ArrayList();
        lista.add("b");
        lista.add("a");
        lista.add("c");
        
        /*Collections.sort(lista, new java.util.Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.compareTo(o2);
            }
        });
        */
        
        Collections.sort(lista, (String o1, String o2) -> o1.compareTo(o2));
        
        for(String s: lista){
            System.out.println(s);
        }
    }
    
    static void functionalInterfaceExample(){
        ILambda lambda=(msg)->System.out.println(msg);
        lambda.print("Lambda expression");
    }
    
    static void forEachExample(){
        List<String> people=Arrays.asList(
                "John", "Stephan", "Clarck", "Adam"
        );
        
        
        /*for (String person : people) {
            System.out.println(person);
        }
        
        people.forEach(new java.util.function.Consumer(){
            @Override
            public void accept(Object p) {
                System.out.println(p);
            }
        });
        */
        
        //Lambda Expression
        people.forEach(person->System.out.println(person));
        
        //Lambda Expression
        people.forEach((String person)->{
            System.out.println(person);
        });
        
        //Member reference
        people.forEach(System.out::println);
        
    }
    
    static void print(String msg){
        System.out.println(msg);
    }
}