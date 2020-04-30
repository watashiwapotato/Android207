package COM.TQC.GDD02

import android.util.Log

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

import javax.net.ssl.HttpsURLConnection

class HippoWebService {
    private val TAG = "HIPPO_DEBUG"

    fun getMethodHTTPs(strGetURL: String): String {
        var strReturn = String()
        try {
            val myUrl = URL(strGetURL)
            // 2. TO DO
            val connection = myUrl.openConnection() as HttpsURLConnection
            strReturn = connection.inputStream.bufferedReader().readText()

        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, e.toString())
        }
        return strReturn
    }
}
