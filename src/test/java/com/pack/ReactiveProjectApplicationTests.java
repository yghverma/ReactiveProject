package com.pack;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;

import ch.qos.logback.core.util.StringUtil;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@SpringBootTest
class ReactiveProjectApplicationTests {
    	
    // Hello World
	//@Test
	public void test() {
		Mono<String> publisher = Mono.just("hello world");
		
		//  using Core Subscriber
		/*
		 * publisher.subscribe(new CoreSubscriber<String>() {
		 * 
		 * @Override public void onNext(String t) {
		 * System.out.println("on Next data done " + t); }
		 * 
		 * @Override public void onError(Throwable t) {
		 * System.out.println("on Error Done"); }
		 * 
		 * @Override public void onComplete() { System.out.println("Complete done"); }
		 * 
		 * @Override public void onSubscribe(Subscription s) {
		 * System.out.println("Subscription done"); s.request(1); } });
		 */
		
		// using publish
		publisher.subscribe(System.out::print);
		
	}
	
	// Other Mono functions
	@Test
	public void testMonoFunctions() throws InterruptedException {
	    Mono<String> monoM1 = Mono.just("Hello");
	    Mono<String> monoM2 = Mono.just("World");
	    
	    // using zip function in mono
	    Mono<Tuple2<String, String>> zipResponse = Mono.zip(monoM1, monoM2);
	    // to fetch all the data
//	    zipResponse.subscribe(System.out::println);
	    //to fetch T1 and T2 data 
	    
	    // to fetch individual data
//	    zipResponse.subscribe(data-> {
//		System.out.println(data.getT1());
//		System.out.println(data.getT2());
//	    });
	    // More than 2
	    Mono<String> monoM3 = Mono.just("part1");
	    Mono<Tuple3<String, String, String>> combnedAllThree = Mono.zip(monoM1, monoM2, monoM3);
//	    combnedAllThree.subscribe(System.out::println);
	    
	    // to fetch individual data
//	    combnedAllThree.subscribe(data-> {
//		System.out.println(data.getT1());
//		System.out.println(data.getT2());
//		System.out.println(data.getT3());
//	    });
	    
	    //using zipwith
	  //  Mono<Tuple2<String, String>> zipWith = monoM1.zipWith(monoM2);
	//    zipWith.subscribe(System.out::println);
	    
	    // using map it uses sync
	    
	//    Mono<String> monoWithMap = monoM1.map(data->{
	//	return data.toUpperCase();
	 //   });
	    //monoWithMap.subscribe(System.out::println);
	    
	   // Mono<String> monoWithMap1 = monoM1.map(data-> data.toUpperCase());
	   // monoWithMap1.subscribe(System.out::println);
	    
	    // using flatmap uses asyn 
	//    Mono<String> flatMap = monoM1.flatMap(data->Mono.just(data + " bro"));
	 //   flatMap.subscribe(System.out::println);
	 
	    // with flatmaany
//	    Flux<String> flux = monoM1.flatMapMany(data->Flux.just(data + " bro"));
//	    flux.subscribe(System.out::println);
	   
	    //concatwith
	//    Flux<String> concatWith = monoM1.concatWith(monoM3);
	 //   concatWith.subscribe(System.out::println);
	    
	    // when the main thread will not wait
	//    System.out.println(Thread.currentThread().getName());
	 //   Mono<String> monoM4 = Mono.just("Hello")
          //          .delayElement(Duration.ofSeconds(3));
	    
	  //  monoM4.subscribe(System.out::println);

	//    System.out.println("Main method finished!");
	    //Thread.sleep(Duration.ofSeconds(3));
	  //  System.out.println(Thread.currentThread().getName());

	    System.out.println(Thread.currentThread().getName());
	    Mono<String> monoM4 = Mono.just("Hello")
                    .delayElement(Duration.ofSeconds(3));
	    
	    monoM4.subscribe(data->{
		
		System.out.println("Data" + data);
		
		System.out.println(Thread.currentThread().getName());
	    });

	    System.out.println("Main method finished!");
	    Thread.sleep(Duration.ofSeconds(5));
	    System.out.println(Thread.currentThread().getName());
	}
	
	
	
	
	@Test	
	public void testFlux() {
	    /*Normal
	     * 
	     * Flux<String> flux1 = Flux.just("Tanisha", "Yogesh", "Manyata");
	     * flux1.subscribe(data -> { System.out.println("Hello " + data); });
	     */
	    
	    // using list
	  //  List<String> listOfString = List.of("Tanisha", "Yogesh", "Manyata");
	   // Flux<String> fromIterable = Flux.fromIterable(listOfString);
	    //fromIterable.subscribe(data -> {
////		System.out.println("Hello " + data);
	//    });
	    
	   // Flux<String> flux1 = Flux.just("Tanisha", "Yogesh", "Manyata");
	    //flux1.subscribe(data -> { System.out.println("Hello " + data); });
	    
	    
	   /* // checking empty
	    * Flux<Object> flux1 = Flux.empty().log(); flux1.subscribe(data -> {
	    * if(StringUtil.isNullOrEmpty(data.toString())) { System.out.println("Hello " +
	    * data); } else { System.out.println("no data"); } });
	    */
	    
	    
	    Flux<Object> flux1 = Flux.just("Tanisha", "Yogesh", "Manyata");
//	    Flux<Object> fluxMap = flux1.map(name-> String.valueOf(name).toUpperCase());
//	    fluxMap.subscribe(data -> {
//	    	System.out.println("Hello " + data); 
//	    });
	    
	 //   StepVerifier.create(fluxMap).expectNextCount(3).verifyComplete();
	    
	 //   StepVerifier.create(fluxMap).expectNext("TANISHA","YOGESH","MANYATA").verifyComplete();
	    
	//    Flux<Object> filterFlux = flux1.filter(name-> String.valueOf(name).length() > 6);
	    
	 //   StepVerifier.create(filterFlux).expectNextCount(2).verifyComplete();
	    
	 //   Flux<String> flatMapFlux = flux1.flatMap(data->Flux.just(data + " bro"));
	    
	  //  StepVerifier.create(flatMapFlux).expectNextCount(3).verifyComplete();
	 
	    // with default
//	    int lengthOfFluxTesting = 9;
//	 Flux<Object> fliterLog = flux1.filter(name->String.valueOf(name).length() > lengthOfFluxTesting).defaultIfEmpty("Yes you missed it").log();
//	 
//	 StepVerifier.create(fliterLog).expectNextCount(1).verifyComplete();
	    // A reusable transformation function
	        Function<Flux<Integer>, Flux<String>> processNumbers = flux ->
	            flux.filter(num -> num % 2 == 0)    // Filter even numbers
	                .map(num -> "Even: " + num);   // Map to descriptive string

	        // Creating a Flux of integers
	        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5, 6);

	        // Applying the reusable transformation using transform
	        Flux<String> processedNumbers = numbers.transform(processNumbers);

	        // Subscribing to the transformed Flux
	        processedNumbers.subscribe(System.out::println);
	    
//	    // with switch if empty
//	    
	    Flux<Object> flux2 = Flux.just("Ram", "Shyam", "Sita");
//	    
//	    int lengthOfFluxTSwitchCaseTesting = 9;
//	    Flux<Object> fliterLogSwitch = flux1.filter(name->String.valueOf(name).length() == lengthOfFluxTSwitchCaseTesting).switchIfEmpty(flux2).log();
//	    StepVerifier.create(fliterLogSwitch).expectNextCount(2).verifyComplete();

	
	// getting the data and combining synchronously  
	   //  // concat (can include any number of publisher) 
	    // /concatwith (merge one with another)
	    
	 //   Feature		merge / mergeWith		concat / concatWith
	 //   Order		Interleaved			Sequential
	 //   Concurrency		Concurrent streams		One stream at a time
	 //   Use Case		Fast, non-blocking, unordered	Ordered processing of data
	 //   Choose merge for parallelism and speed, and concat for maintaining order and sequential processing.
//	    
//	Flux<Object> concat = Flux.concat(flux1.delayElements(Duration.ofSeconds(1)),flux2.delayElements(Duration.ofSeconds(2))).log();
//	 StepVerifier.create(concat).expectNextCount(6).verifyComplete();
//	
// Getting the data async using merge and mergeWith
	 // merge (can include any number of publisher) 
	    // /mergewith (merge one with another)
//	   Flux<Object> mergeExample = Flux.merge(flux1.delayElements(Duration.ofSeconds(1)),flux2.delayElements(Duration.ofSeconds(2))).log();
//	   StepVerifier.create(mergeExample).expectNextCount(6).verifyComplete();
	
	
	// zip and zipwith
	 // /zipwith (merge one with another)
	//    Flux<Tuple2<Object, Object>> zipFlux = Flux.zip(flux1, flux2);
//	    zipFlux.subscribe(zip1 -> System.out.println(zip1));

	    
	    
	    // doOnEach doOnComplete donOnSubscribe methodds are siders
	    
	    
	}
}