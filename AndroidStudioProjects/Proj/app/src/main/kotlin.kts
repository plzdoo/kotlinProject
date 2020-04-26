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




fun main(args: Array<String>) {

}