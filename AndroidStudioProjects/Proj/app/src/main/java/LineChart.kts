//
import android.graphics.Color.red
import com.example.proj.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import android.graphics.Color.red
import android.system.Os.bind
import com.github.mikephil.charting.animation.Easing


data class SevenDays(val first: Int, val second: Int, val third: Int, val fourth: Int, val fifth: Int){
    val firPre = fifth * averageInc() + fifth
    val secPre = firPre * averageInc() + firPre
    val thiPre = secPre * averageInc() + secPre
    val fourPre = thiPre * averageInc() + thiPre
    val fifPre = fourPre * averageInc() + fourPre
}


fun averageInc():Double {

    val aveFir = (sevenDays.second - sevenDays.first)/sevenDays.first
    val aveSec = (sevenDays.third - sevenDays.second)/sevenDays.second
    val aveThi = (sevenDays.fourth - sevenDays.third)/sevenDays.third
    val aveFif = (sevenDays.fifth - sevenDays.fourth)/sevenDays.fourth
    val incFir = (aveSec - aveFir)/aveFir
    val incSec = (aveThi - aveSec)/aveSec
    val incThi = (aveFif - aveThi)/aveThi
    val ave = sequenceOf(incFir, incSec, incThi).average()
    return ave
}


val sevenDays = SevenDays(1,2,3,4,5)

val entries = ArrayList<Entry>()

entries.add(Entry(6f, sevenDays.firPre.toFloat()))
entries.add(Entry(7f,sevenDays.secPre.toFloat()))
entries.add(Entry(8f,sevenDays.thiPre.toFloat()))
entries.add(Entry(9f,sevenDays.fourPre.toFloat()))
entries.add(Entry(10f, sevenDays.fifPre.toFloat()))

val vl = LineDataSet(entries,"My Types")

val v = arrayOf(sevenDays.firPre.toString(),
                sevenDays.secPre.toString(),
                sevenDays.thiPre.toString(),
                sevenDays.fourPre.toString(),
                sevenDays.fifPre.toString())


vl.setDrawValues(false)
vl.setDrawFilled(true)
vl.lineWidth = 3f


//val lineChart by bind<LineChart>(R.id.lineChart)

val lineChart = LineChart(v)

//Part5
lineChart.xAxis.labelRotationAngle = 0f


//Part6
lineChart.data = LineData(vl)

//Part7
lineChart.axisRight.isEnabled = false
lineChart.xAxis.axisMaximum = j+0.1f

//Part8
lineChart.setTouchEnabled(true)
lineChart.setPinchZoom(true)

//Part9
lineChart.description.text = "Days"
lineChart.setNoDataText("No forex yet!")

//Part10
lineChart.animateX(1800, Easing.EaseInExpo)

//Part11
val markerView = CustomMarker(this@ShowForexActivity, R.layout.marker_view)
lineChart.marker = markerView