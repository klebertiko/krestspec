/*
import rx.Observable
import rx.schedulers.Schedulers
import java.io.File

*/
/**
 * Created by Kleber on 11/05/2016.
 */
/*

fun hello(names: Array<String>) {
    rx.Observable.from(names).subscribe { subs -> println("Hello $subs!") }
}

fun observableSubscriber() {
    val myObservable = rx.Observable.create(rx.Observable.OnSubscribe<String> { subscriber ->
        subscriber.onNext("Tarefa do mal iniciada") // Aqui vc faz a tarefas do mal muahahahaha!!!
        subscriber.onNext("Tarefa do mal processando") // Aqui vc nao vera processo por causa do take(1)
        //subscriber.onError(new Exception("Tarefa do mal com erro"));
        subscriber.onCompleted()
    }).take(1)

    val mySubscriber = object : rx.Subscriber<String>() {
        override fun onNext(string: String) {
            println(string)
        }

        override fun onCompleted() {
            println("Tarefa do mal terminada")
        }

        override fun onError(e: Throwable) {
            println(e.message)
        }
    }
    myObservable.subscribe(mySubscriber)
}

fun mainThread() {
    val max = 5
    val gerador: rx.Observable<Int> = rx.Observable.from(1..max).doOnNext { i -> println("Comecou " + i + " na ${Thread.currentThread().name}") }
    val somar10 = gerador.map { i -> i + 10 }.doOnNext { i -> println("Soma 10 " + i + " na ${Thread.currentThread().name}") }
    val subtrair10 = somar10.map { i -> i - 10 }.doOnNext { i -> println("Subtrai 10 " + i + " na ${Thread.currentThread().name}") }
    subtrair10.subscribe { i -> println("Recebido " + i + " na ${Thread.currentThread().name}") }
}

fun observeEmComputationThread() {
    val max = 5
    val gerador: rx.Observable<Int> = rx.Observable.from(1..max).observeOn(rx.schedulers.Schedulers.computation()).doOnNext { i -> println("Comecou " + i + " observe na ${Thread.currentThread().name}") }
    val somar10 = gerador.map { i -> i + 10 }.doOnNext { i -> println("Soma 10 " + i + " observe na ${Thread.currentThread().name}") }
    val subtrair10 = somar10.map { i -> i - 10 }.doOnNext { i -> println("Subtrai 10 " + i + " observe na ${Thread.currentThread().name}") }
    subtrair10.subscribeOn(rx.schedulers.Schedulers.computation()).subscribe { i -> println("Recebido " + i + " subscribe na ${Thread.currentThread().name}") }
}

fun subscribeEmNovaThread() {
    val max = 5
    val gerador: rx.Observable<Int> = rx.Observable.from(1..max).subscribeOn(rx.schedulers.Schedulers.newThread()).doOnNext { i -> println("Comecou " + i + " subscribe na ${Thread.currentThread().name}") }
    val somar10 = gerador.map { i -> i + 10 }.doOnNext { i -> println("Soma 10 " + i + " subscribe na ${Thread.currentThread().name}") }
    val subtrair10 = somar10.map { i -> i - 10 }.doOnNext { i -> println("Subtrai 10 " + i + " subscribe na ${Thread.currentThread().name}") }
    subtrair10.subscribe { i -> println("Recebido " + i + " subscribe na ${Thread.currentThread().name}") }
}

data class FileInfo(val file: java.io.File,
                    var bytes: Long = 0,
                    var filesCount: Long = 1)

fun fileToFileInfo(file: java.io.File): rx.Observable<FileInfo> {
    if (file.isFile)
        return rx.Observable.just(FileInfo(file, file.length()))
                .print({ "emit\t\t\t${it.file}" }) // HERE
    else if (file.isDirectory)
        return Observable.defer({
            // DEFER THE CREATION...
            Observable.from(file.listFiles())
                    .flatMap({ fileToFileInfo(it) })
                    .reduce(FileInfo(file), { acc, b ->
                        acc.bytes += b.bytes
                        acc.filesCount += b.filesCount
                        acc
                    })
                    .print({ "reduced\t${it.file}" })
        }).subscribeOn(Schedulers.io()) // ... ON ANOTHER THREAD
    return Observable.error(IllegalArgumentException("$file is neither a file or a directory"))
}

val DEBUG = true

fun <T> Observable<T>.print(message: (T) -> String = { "" }): Observable<T> {
    if (!DEBUG) return this
    return this.map({ println("[${Thread.currentThread().name}] ${message(it)}"); it })
}

fun String.hello() {
    println("Hello, $this!")
}

fun Int.somar(x: Int): Int {
    return this + x
}

fun main(args: Array<String>) {
    println(Thread.currentThread().name)
    hello(arrayOf("Kleber", "Rafael"))
    observableSubscriber()
    mainThread()
    observeEmComputationThread()
    subscribeEmNovaThread()
    Thread.sleep(3000)

    Observable.just("Hello World")
            //each subscription is going to be on a new thread.
            .subscribeOn(Schedulers.newThread())
            .map { }
            //observation on the io thread pool
            .observeOn(Schedulers.io())
            //Now our subscriber!
            .subscribe { println("[Thread: ${Thread.currentThread().name}] - Output: $it") }

    Thread.sleep(3000)

    Observable.just(File("C:\\kleber\\root\\"))
            //.observeOn(Schedulers.computation())
            .flatMap({ fileToFileInfo(it) })
            .subscribe(
                    { fileInfo -> println("[${Thread.currentThread().getName()}] $fileInfo") },
                    { throwable -> throwable.printStackTrace() })

    Thread.sleep(20000)

    "world".hello() // prints 'Hello, world!'
    val numero: Int = 2
    println(numero.somar(1))
}
*/
