import io.ktor.util.KtorExperimentalAPI
import jdk.internal.net.http.common.Log.trace
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.graalvm.compiler.core.common.alloc.Trace
import scientifik.plotly.Plotly
import scientifik.plotly.models.Trace
import scientifik.plotly.server.serve
import sun.tools.jconsole.LabeledComponent.layout
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin



fun main() {
    val server = Plotly.serve {
        val x = (0..100).map { it.toDouble() / 100.0 }.toDoubleArray()
        val y1 = x.map { sin(2.0 * PI * it) }.toDoubleArray()
        val y2 = x.map { cos(2.0 * PI * it) }.toDoubleArray()

        val trace1 = Trace.build(x = x, y = y1) { name = "sin" }
        val trace2 = Trace.build(x = x, y = y2) { name = "cos" }


        //root level plots go to default page

        plot(1, 8) {
            trace(trace1, trace2)
            layout {
                title = "First graph, row: 1, size: 8/12"
                xaxis { title = "x axis name" }
                yaxis { title = "y axis name" }
            }
        }

        val plot1 = plot(1, 4) {
            trace(trace1, trace2)
            layout {
                title = "Second graph, row: 1, size: 4/12"
                xaxis { title = "x axis name" }
                yaxis { title = "y axis name" }
            }
        }

        plot(2, 12) {
            trace(trace1, trace2)
            layout {
                title = "Third graph, row: 2, size: 12/12"
                xaxis { title = "x axis name" }
                yaxis { title = "y axis name" }
            }
        }

        page("other") {
            title = "Other page"
            plot(plot1, id = "plot1")
        }

    }

    println("Press Enter to close server")
    readLine()

    server.stop()

}
