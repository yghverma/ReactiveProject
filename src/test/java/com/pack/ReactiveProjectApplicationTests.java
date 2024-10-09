package com.pack;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
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
}