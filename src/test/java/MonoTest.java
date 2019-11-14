import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    void firstMonoTest() {
        Mono.just("A")
                .log()
            .subscribe();

    }

    @Test
    void monoWithSubscribe() {
        Mono.just("A")
                .log()
                .subscribe(s-> System.out.println("This line is printed for test reason " + s));

    }

    @Test
    void emptyMono() {
        Mono.empty()
                .log()
                .subscribe(System.out::println);

    }

    @Test
    void emptyCompleteConsumerMono() {
        Mono.empty()
                .log()
                .subscribe(System.out::println, null, () -> System.out.println("DONE"));

    }

    @Test
    void monotWithDoOn() {
        Mono.just("A")
                .log()
                .doOnSubscribe(subs -> System.out.println("#### " + subs))
                .doOnRequest(request -> System.out.println("#### " + request))
                .doOnSuccess(succ -> System.out.println("#### " + succ))
                .subscribe(System.out::println);

    }
}
