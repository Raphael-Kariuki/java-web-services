package runner;


import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mo
 */
public class runnerClass {


    public static void main(String[] args) {
     

    //inconsistency while processing stream elements in parallel


        StreamProcessor streamProcessor = new StreamProcessor();

        for (int i = 1; i <= 10; i++) {
            streamProcessor.addNumber(i);
        }

        // Creating two threads to process stream elements concurrently
        Thread thread1 = new Thread(streamProcessor::processNumbers);
        Thread thread2 = new Thread(streamProcessor::processNumbers);

        thread1.start();
        thread2.start();


    }
}
 class StreamProcessor {

     //new arrayList creation
        private List<Integer> numbers = new ArrayList<>();

        //method that receives single int as argument and adds it to the arrayList
        public void addNumber(int number) {
            numbers.add(number);
        }

        //method that converts the arrayList to a stream - that processes elements in parallel and (
        //1. sleeps for 100s, 
        //2. double the provided int arg and assigns value to variable doubleValue, 
        //3.prints (associated thread,int arg supplied and double it's value))
        public void processNumbers() {
            numbers.parallelStream().forEach(this::processNumber);
        }

        //1. method that sleeps for 100 secs, takes the int argument supplied and doubles it then assigns it to the doubleValue
        //2. Prints the thread that processed the number, the number supplied and it's double value
        //3. removes the supplied number from the arrayList
        private void processNumber(int number) {
            // Simulating a time-consuming task
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("" + e.getMessage());
            }

            // Inconsistent operation - modifying shared data without synchronization
            int doubledValue = number * 2;
            System.out.println(Thread.currentThread().getName() + ": Processed " + number + ", Result: " + doubledValue);

            // Modifying shared data without synchronization
            numbers.remove(Integer.valueOf(number));
        }
    }
