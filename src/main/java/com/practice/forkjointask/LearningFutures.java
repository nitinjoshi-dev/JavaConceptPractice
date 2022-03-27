package com.practice.forkjointask;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearningFutures {

    public static CompletableFuture<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        completableFuture.complete("First task");

        return completableFuture;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        completableFuturesExample();
        forkAndJoinExample();
    }

    private static void forkAndJoinExample() {
        int []array = new int[50];
        for(int i = 0 ; i < 50; i++) {
            array[i] = i;
        }
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(array);
        ForkJoinPool.commonPool().execute(customRecursiveTask); //ForkJoinPool.commonPool().submit(customRecursiveTask);
        int result = customRecursiveTask.join();
        System.out.println("Result " + result);

        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("123456789012345678901234567890");
        ForkJoinPool.commonPool().invoke(customRecursiveAction);

        CustomRecursiveAction customRecursiveAction2 = new CustomRecursiveAction("123456789012345678901234567890");
        CustomRecursiveAction customRecursiveAction3 = new CustomRecursiveAction("abcdefghijklnopqrstuvwxyz");
        ForkJoinTask.invokeAll(Arrays.asList(customRecursiveAction2, customRecursiveAction3));


    }

    private static void completableFuturesExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = calculateAsync();
        System.out.println(completableFuture.getNow("test"));

        completableFuture =  CompletableFuture.supplyAsync(() -> "supply async");
        System.out.println(completableFuture.get());

        completableFuture = completableFuture.thenApply(s-> s+ " with then apply");
        System.out.println(completableFuture.get());

        completableFuture = CompletableFuture.supplyAsync(() -> "supply async").thenCompose(s-> CompletableFuture.supplyAsync(() -> s +  " with then compose"));
        System.out.println(completableFuture.get());

        CompletableFuture<Void> voidFuture = CompletableFuture.supplyAsync(() -> "supply async").thenAccept(s -> System.out.println(s + " then accept"));
        voidFuture.get();

        completableFuture = CompletableFuture.supplyAsync(() -> "supply async").thenCombine(CompletableFuture.supplyAsync(() -> " with "), (s1, s2) -> s1 + s2 + "then combine");
        System.out.println(completableFuture.get());

        voidFuture = CompletableFuture.supplyAsync(() -> "supply async").thenAcceptBoth(CompletableFuture.supplyAsync(() -> " then accept both"), (s1, s2) -> System.out.println(s1 + s2));
        voidFuture.get();

        CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(() -> 10).thenApply(s -> s + 10);
        System.out.println(intFuture.get());

        intFuture = CompletableFuture.supplyAsync(() -> 10).thenCompose(s -> CompletableFuture.supplyAsync(() -> s + 10));
        System.out.println(intFuture.get());

        usingCompletableFutureAllOf();

        usingStreamAndJoining();
    }

    private static void usingStreamAndJoining() {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Combining the output ");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "of futures using");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "stream and joining");

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println(combined);

    }

    private static void usingCompletableFutureAllOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Using 3 future");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "with allOf method");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "but output is not combined");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();

        //Have to get individual results
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}
