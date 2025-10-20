package com.enet.sab.ui.view

fun gregorianToJalali(year: Int, month: Int, day: Int): Triple<Int, Int, Int> {
    // تنظیمات اولیه
    val gDaysInMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val jDaysInMonth = intArrayOf(31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29)

    var gy = year
    var gm = month
    var gd = day

    // بررسی سال کبیسه میلادی
    val isGregorianLeapYear = { y: Int ->
        (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)
    }

    if (isGregorianLeapYear(gy)) gDaysInMonth[1] = 29 // تنظیم فوریه در سال کبیسه

    var totalDays = gd
    for (i in 0 until gm - 1) {
        totalDays += gDaysInMonth[i]
    }

    var jYear = gy - 621
    val march21Days = if (isGregorianLeapYear(gy)) 80 else 79

    if (totalDays > march21Days) {
        totalDays -= march21Days
    } else {
        jYear -= 1
        totalDays += 365 + if (isGregorianLeapYear(gy - 1)) 1 else 0
        totalDays -= march21Days
    }

    var jMonth = 0
    for (i in 0..11) {
        if (totalDays <= jDaysInMonth[i]) {
            jMonth = i + 1
            break
        }
        totalDays -= jDaysInMonth[i]
    }

    val jDay = totalDays
    return Triple(jYear, jMonth, jDay)
}


//// نمونه استفاده
//val (jy, jm, jd) = com.enet.sab.ui.view.ui.gregorianToJalali(2025, 3, 30)
//Text( modifier = Modifier
//.padding(top = 40.dp, start = 40.dp),
//text = jy.toString() + "/" + jm.toString() + "/" + jd.toString())
