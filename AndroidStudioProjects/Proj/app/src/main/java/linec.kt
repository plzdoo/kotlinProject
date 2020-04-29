package values

import android.system.Os.bind
import com.aachartmodel.aainfographics.AAInfographicsLib.AAChartConfiger.AAChartModel
import com.aachartmodel.aainfographics.AAInfographicsLib.AAChartConfiger.AAChartType
import com.aachartmodel.aainfographics.AAInfographicsLib.AAChartConfiger.AAChartView
import com.aachartmodel.aainfographics.AAInfographicsLib.AAChartConfiger.AASeriesElement
import com.example.proj.R


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

val aaChartModel = AAChartModel()
    .dataLabelsEnabled(true)
    .chartType(AAChartType.Area)
    .title("title")
    .subtitle("subtitle")
    .backgroundColor("#4b2b7f")
    .yAxisGridLineWidth(0)
    .series(arrayOf(
        AASeriesElement()
            .name("Day six")
            .data(arrayOf(sevenDays.firPre.toFloat()))
            .name("Day seven")
            .data(arrayOf(sevenDays.secPre.toFloat()))
            .name("Day eight")
            .data(arrayOf(sevenDays.thiPre.toFloat()))
            .name("Day nine")
            .data(arrayOf(sevenDays.fourPre.toFloat()))
            .name("Day ten")
            .data(arrayOf(sevenDays.fifPre.toFloat()))
    )
    )
fun main(args: Array<String>) {
    val aaChartView by bind<AAChartView>(R.id.AAChartView)
    aaChartView?.aa_drawChartWithChartModel(aaChartModel!)
}