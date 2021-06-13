import com.haroldadmin.spacexkmp.Http
import com.haroldadmin.spacexkmp.cores.Core
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

public fun main(): Unit = runBlocking {
    val cores: List<Core> = Http.client.get("https://api.spacexdata.com/v4/cores/123")
    cores.forEach {
        println(it)
    }
}